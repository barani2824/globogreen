/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service;

import com.kdi.onboardinghelper.service.dto.CompleteFormDTO;
import com.kdi.onboardinghelper.service.dto.PhoneDTO;
import com.kdi.onboardinghelper.service.dto.AddressDTO;
import com.kdi.onboardinghelper.service.dto.BasicFormDTO;
import com.kdi.onboardinghelper.service.dto.DependentDTO;
import com.kdi.onboardinghelper.service.dto.EmergencyContactDTO;
import com.kdi.onboardinghelper.service.dto.FormFDTO;
import com.kdi.onboardinghelper.service.dto.FormIDTO;
import com.kdi.onboardinghelper.service.dto.FormQDTO;
import com.kdi.onboardinghelper.service.dto.NomineeFDTO;
import com.kdi.onboardinghelper.service.dto.NomineeIDTO;
import com.kdi.onboardinghelper.service.dto.PersonalFormDTO;
import com.kdi.onboardinghelper.service.dto.PreviousEmploymentDTO;
import com.kdi.onboardinghelper.service.dto.ProvidentFundFormDTO;
import com.kdi.onboardinghelper.model.Address;
import com.kdi.onboardinghelper.model.Dependent;
import com.kdi.onboardinghelper.model.EmergencyContact;
import com.kdi.onboardinghelper.model.Employee;
import com.kdi.onboardinghelper.model.Nominee;
import com.kdi.onboardinghelper.model.NomineeType;
import com.kdi.onboardinghelper.model.Phone;
import com.kdi.onboardinghelper.model.PreviousEmployment;
import com.kdi.onboardinghelper.model.ProvidentFund;
import com.kdi.onboardinghelper.repository.EmployeeRepository;
import com.kdi.onboardinghelper.repository.EstablishmentRepository;
import com.kdi.onboardinghelper.repository.ProvidentFundRepository;
import com.kdi.onboardinghelper.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author subasb
 */
@Service
public class HelperService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProvidentFundRepository providentFundRepository;

    public Employee getEmployee(CompleteFormDTO completeForm) {
        Employee employee = new Employee();
        if (completeForm.getEmployeeId() != null) {
            employee.setId(completeForm.getEmployeeId());
        }
        employee = fillEmployee(employee, completeForm);
        return employee;
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public BasicFormDTO getBasicFormById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillBasicForm(completeForm, employee);
        return completeForm.getBasicForm();
    }

    public PersonalFormDTO getPersonalFormById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillPersonalForm(completeForm, employee);
        return completeForm.getPersonalForm();
    }

    public ProvidentFundFormDTO getProvidentFormById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillProvidentFundForm(completeForm, employee);
        return completeForm.getProvidentFundForm();
    }

    public FormFDTO getFormFById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillFormF(completeForm, employee);
        return completeForm.getFormF();
    }

    public FormIDTO getFormIById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillFormI(completeForm, employee);
        return completeForm.getFormI();
    }

    public FormQDTO getFormQById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm = fillFormQ(completeForm, employee);
        return completeForm.getFormQ();
    }

    public CompleteFormDTO getCompleteForm(Employee employee) {
        CompleteFormDTO completeForm = new CompleteFormDTO();
        completeForm.setEmployeeId(employee.getId());
        completeForm = fillAllForms(completeForm, employee);
        return completeForm;
    }

    ////////////// FOR DB PURPOSE
    private Employee fillEmployee(Employee employee, CompleteFormDTO completeForm) {
        employee = fillBasicDetails(employee, completeForm);
        employee = fillPhoneDetails(employee, completeForm);
        employee = fillAddressDetails(employee, completeForm);
        employee = fillPFDetails(employee, completeForm);
        employee = fillDependentDetails(employee, completeForm);
        employee = fillEmergencyContactDetails(employee, completeForm);
        employee = fillNomineeDetails(employee, completeForm);
        return employee;
    }

    private Employee fillBasicDetails(Employee employee, CompleteFormDTO completeForm) {
        employee.setFirstname(completeForm.getBasicForm().getFirstname());
        employee.setLastname(completeForm.getBasicForm().getLastname());
        employee.setTitle(completeForm.getPersonalForm().getTitle());
        employee.setEmployeeCode(completeForm.getBasicForm().getEmployeeCode());
        employee.setDepartment(Util.HandleNull(completeForm.getFormF().getDepartment()));
        employee.setDesignation(completeForm.getFormQ().getDesignation());
        employee.setNatureOfWorkEntrusted(completeForm.getFormQ().getNatureOfWorkEntrusted());
        employee.setSerialNumber(Util.HandleNull(completeForm.getFormQ().getSerialNumber()));
        employee.setDateOfAppointment(completeForm.getFormF().getDateOfAppointment());
        employee.setDateOfBirth(completeForm.getBasicForm().getDateOfBirth());
        employee.setGender(completeForm.getPersonalForm().getGender());
        employee.setBloodGroup(completeForm.getBasicForm().getBloodGroup());
        employee.setMaritalStatus(completeForm.getPersonalForm().getMaritalStatus());
        employee.setNationality(completeForm.getPersonalForm().getNationality());
        employee.setReligion(completeForm.getFormF().getReligion());
        employee.setPlaceOfBirth(completeForm.getPersonalForm().getPlaceOfBirth());
        employee.setEmail(completeForm.getPersonalForm().getEmail());
        employee.setAadharNumber(completeForm.getPersonalForm().getAadharNumber());
        employee.setPanNumber(completeForm.getPersonalForm().getPanNumber());
        employee.setPassportNumber(completeForm.getPersonalForm().getPassportNumber());
        employee.setPlaceOfPassportIssue(completeForm.getPersonalForm().getPlaceOfPassportIssue());
        employee.setDateOfIssue(completeForm.getPersonalForm().getDateOfIssue());
        employee.setDateOfExpiry(completeForm.getPersonalForm().getDateOfExpiry());
        employee.setTicketNumber(Util.HandleNull(completeForm.getFormF().getTicketNumber()));
        employee.setExcludingHusbandDate(completeForm.getFormF().getExcludingHusbandDate());
        employee.setPostOffice(completeForm.getFormF().getPostOffice());
        employee.setDistrict(completeForm.getFormF().getDistrict());
        employee.setState(completeForm.getFormF().getState());
        employee.setPhoto(completeForm.getBasicForm().getPhoto());
        return employee;
    }

    private Employee fillPhoneDetails(Employee employee, CompleteFormDTO completeForm) {
        List<Phone> phones = new ArrayList<>();
        List<PhoneDTO> phonesDto = completeForm.getPersonalForm().getPhones();
        List<Phone> originalPhones = employee.getId() == null ? new ArrayList() : employeeRepository.getPhonesById(employee.getId());
        for (int i = 0; i < phonesDto.size(); i++) {
            PhoneDTO phoneDto = phonesDto.get(i);
            Phone phone = new Phone();
            if (i < originalPhones.size()) {
                phone.setId(originalPhones.get(i).getId());
            }
            phone.setNumber(phoneDto.getNumber());
            phone.setPhoneType(phoneDto.getPhoneType());
            phones.add(phone);
        }

        employee.setPhones(phones);
        return employee;
    }

    private Employee fillAddressDetails(Employee employee, CompleteFormDTO completeForm) {

        Address presentAddress = employee.getId() == null ? new Address() : employeeRepository.getPresentAddressById(employee.getId());
        Address postalAddress = employee.getId() == null ? new Address() : employeeRepository.getPostalAddressById(employee.getId());
        Address permanentAddress = employee.getId() == null ? new Address() : employeeRepository.getPermanentAddressById(employee.getId());

        AddressDTO presentAddressDto = completeForm.getPersonalForm().getPresentAddress();
        AddressDTO permanentAddressDto = completeForm.getFormQ().getPostalAddress();
        AddressDTO postalAddressDto = completeForm.getPersonalForm().getPermanentAddress();

        presentAddress.setShortAddress(presentAddressDto.getShortAddress());
        presentAddress.setPincode(presentAddressDto.getPincode());

        postalAddress.setShortAddress(postalAddressDto.getShortAddress());
        postalAddress.setPincode(postalAddressDto.getPincode());

        permanentAddress.setShortAddress(permanentAddressDto.getShortAddress());
        permanentAddress.setPincode(permanentAddressDto.getPincode());

        employee.setPresentAddress(presentAddress);
        employee.setPostalAddress(postalAddress);
        employee.setPermanentAddress(permanentAddress);
        return employee;
    }

    private Employee fillPFDetails(Employee employee, CompleteFormDTO completeForm) {
        ProvidentFund providentFund = employee.getId() == null ? new ProvidentFund() : employeeRepository.getProvidentFundById(employee.getId());
        PreviousEmployment previousEmployment = providentFund.getId() == null ? new PreviousEmployment() : providentFundRepository.getPreviousEmploymentById(providentFund.getId());

        ProvidentFundFormDTO providentFundDto = completeForm.getProvidentFundForm();
        PreviousEmploymentDTO previousEmploymentDto = providentFundDto.getPreviousEmployment();

        providentFund.setFatherOrSpouseName(providentFundDto.getFatherOrSpouseName());
        providentFund.setEmail(providentFundDto.getEmail());
        providentFund.setPhone(providentFundDto.getPhone());
        providentFund.setEarlierMemberOfPfScheme(providentFundDto.isEarlierMemberOfPScheme());
        providentFund.setEarlierMemberOfPScheme(providentFundDto.isEarlierMemberOfPScheme());
        providentFund.setAccountNumber(providentFundDto.getAccountNumber());
        providentFund.setIfscCode(providentFundDto.getIfscCode());
        providentFund.setAadharNumber(providentFundDto.getAadharNumber());
        providentFund.setPanNumber(providentFundDto.getPanNumber());

        previousEmployment.setUniversalAccountNumber(previousEmploymentDto.getUniversalAccountNumber());
        previousEmployment.setPfAccountNumber(previousEmploymentDto.getPfAccountNumber());
        previousEmployment.setDateOfExit(previousEmploymentDto.getDateOfExit());
        previousEmployment.setSchemeCertificateNumber(previousEmploymentDto.getSchemeCertificateNumber());
        previousEmployment.setPensionPaymentOrderNumber(previousEmploymentDto.getPensionPaymentOrderNumber());
        previousEmployment.setInternationalWorker(previousEmploymentDto.isInternationalWorker());
        previousEmployment.setCountry(previousEmploymentDto.getCountry());

        providentFund.setPreviousEmployment(previousEmployment);
        employee.setProvidentFund(providentFund);
        return employee;
    }

    private Employee fillDependentDetails(Employee employee, CompleteFormDTO completeForm) {
        List<Dependent> dependents = new ArrayList<>();
        List<DependentDTO> dependentsDto = completeForm.getPersonalForm().getDependents();
        List<Dependent> originalDependents = employee.getId() == null ? new ArrayList() : employeeRepository.getDependentsById(employee.getId());

        for (int i = 0; i < dependentsDto.size(); i++) {
            DependentDTO dependentDto = dependentsDto.get(i);
            Dependent dependent = new Dependent();
            if (i < originalDependents.size()) {
                dependent.setDependentId(originalDependents.get(i).getDependentId());
            }
            dependent.setName(dependentDto.getName());
            dependent.setRelationshipWithYou(dependentDto.getRelationshipWithYou());
            dependent.setDateOfBirth(dependentDto.getDateOfBirth());
            dependent.setAge(dependentDto.getAge());
            dependents.add(dependent);
        }
        employee.setDependents(dependents);
        return employee;
    }

    private Employee fillEmergencyContactDetails(Employee employee, CompleteFormDTO completeForm) {
        List<EmergencyContact> emergencyContacts = new ArrayList<>();
        List<EmergencyContactDTO> emergencyContactsDto = completeForm.getPersonalForm().getEmergencyContacts();
        List<EmergencyContact> originalEmergencyContacts = employee.getId() == null ? new ArrayList() : employeeRepository.getEmergencyContactsById(employee.getId());
        for (int i = 0; i < emergencyContactsDto.size(); i++) {
            EmergencyContactDTO emergencyContactDto = emergencyContactsDto.get(i);
            EmergencyContact emergencyContact = new EmergencyContact();
            if (i < originalEmergencyContacts.size()) {
                emergencyContact.setEmergencyContactId(originalEmergencyContacts.get(i).getEmergencyContactId());
            }
            emergencyContact.setName(emergencyContactDto.getName());
            emergencyContact.setRelationshipWithYou(emergencyContactDto.getRelationshipWithYou());
            emergencyContact.setAddress(emergencyContactDto.getAddress());
            emergencyContact.setPhone(emergencyContactDto.getPhone());
            emergencyContacts.add(emergencyContact);
        }
        employee.setEmergencyContacts(emergencyContacts);
        return employee;
    }

    private Employee fillNomineeDetails(Employee employee, CompleteFormDTO completeForm) {
        List<Nominee> nominees = new ArrayList<>();
        List<NomineeFDTO> nomineesFDto = completeForm.getFormF().getNominees();
        List<Nominee> originalFNominees = employee.getId() == null ? new ArrayList() : employeeRepository.getNomineesById(employee.getId(), NomineeType.FORM_F);
        List<Nominee> originalINominees = employee.getId() == null ? new ArrayList() : employeeRepository.getNomineesById(employee.getId(), NomineeType.FORM_I);
        List<Nominee> originalBothNominees = employee.getId() == null ? new ArrayList() : employeeRepository.getNomineesById(employee.getId(), NomineeType.BOTH);
        for (int i = 0; i < nomineesFDto.size(); i++) {
            NomineeFDTO nomineeFDto = nomineesFDto.get(i);
            Nominee nominee = new Nominee();
            if (i < originalFNominees.size()) {
                nominee.setId(originalFNominees.get(i).getId());
            }
            nominee.setName(nomineeFDto.getName());
            nominee.setAddress(nomineeFDto.getAddress());
            nominee.setRelationshipWithYou(nomineeFDto.getRelationshipWithYou());
            nominee.setProportion(nomineeFDto.getProportion());
            nominee.setAge(nomineeFDto.getAge());
            nominee.setNomineeType(NomineeType.FORM_F);
            nominees.add(nominee);
        }

        List<NomineeIDTO> nomineesIDto = completeForm.getFormI().getNominees();
        for (int i = 0; i < nomineesIDto.size(); i++) {
            NomineeIDTO nomineeIDto = nomineesIDto.get(i);
            int duplicateNomineeIndex = checkForDuplicate(nominees, nomineeIDto);
            if (duplicateNomineeIndex != -1) {
                if (i < originalBothNominees.size()) {
                    nominees.get(duplicateNomineeIndex).setId(originalFNominees.get(i).getId());
                }
                nominees.get(duplicateNomineeIndex).setNomineeType(NomineeType.BOTH);
            } else {
                Nominee nominee = new Nominee();
                if (i < originalFNominees.size()) {
                    nominee.setId(originalINominees.get(i).getId());
                }
                nominee.setName(nomineeIDto.getName());
                nominee.setAddress(nomineeIDto.getAddress());
                nominee.setRelationshipWithYou(nomineeIDto.getRelationshipWithYou());
                nominee.setAge(nomineeIDto.getAge());
                nominee.setNomineeType(NomineeType.FORM_I);
                nominees.add(nominee);
            }
        }
        employee.setNominees(nominees);
        return employee;
    }

    private int checkForDuplicate(List<Nominee> nominees, NomineeIDTO nominee) {
        for (int i = 0; i < nominees.size(); i++) {
            Nominee nom = nominees.get(i);
            if (nom.getName().equals(nominee.getName())
                    && nom.getAddress().equals(nominee.getAddress())
                    && nom.getRelationshipWithYou().equals(nominee.getRelationshipWithYou())
                    && nom.getAge() == nominee.getAge()) {
                return i;
            }
        }
        return -1;
    }

    /////////////// FOR DTO PURPOSE
    private CompleteFormDTO fillAllForms(CompleteFormDTO completeForm, Employee employee) {
        completeForm = fillBasicForm(completeForm, employee);
        completeForm = fillPersonalForm(completeForm, employee);
        completeForm = fillProvidentFundForm(completeForm, employee);
        completeForm = fillFormF(completeForm, employee);
        completeForm = fillFormI(completeForm, employee);
        completeForm = fillFormQ(completeForm, employee);
        return completeForm;
    }

    private CompleteFormDTO fillBasicForm(CompleteFormDTO completeForm, Employee employee) {
        AddressDTO address = new AddressDTO(
                employee.getPermanentAddress().getShortAddress(),
                employee.getPermanentAddress().getPincode());

        BasicFormDTO basicForm = new BasicFormDTO(
                employee.getFirstname(),
                employee.getLastname(),
                address,
                employee.getDateOfBirth(),
                employee.getEmployeeCode(),
                employee.getBloodGroup(),
                employee.getPhoto());
        completeForm.setBasicForm(basicForm);
        return completeForm;
    }

    private CompleteFormDTO fillPersonalForm(CompleteFormDTO completeForm, Employee employee) {
        AddressDTO presentAddress = new AddressDTO(
                employee.getPresentAddress().getShortAddress(),
                employee.getPresentAddress().getPincode());
        AddressDTO permanentAddress = new AddressDTO(
                employee.getPermanentAddress().getShortAddress(),
                employee.getPermanentAddress().getPincode());

        List<PhoneDTO> phonesDto = new ArrayList<>();
        List<Phone> phones = employee.getPhones();
        for (int i = 0; i < phones.size(); i++) {
            Phone phone = phones.get(i);
            PhoneDTO phoneDto = new PhoneDTO(
                    phone.getPhoneType(),
                    phone.getNumber());
            phonesDto.add(phoneDto);
        }

        List<DependentDTO> dependentsDto = new ArrayList<>();
        List<Dependent> dependents = employee.getDependents();
        for (int i = 0; i < dependents.size(); i++) {
            Dependent dependent = dependents.get(i);
            DependentDTO dependentDto = new DependentDTO(
                    dependent.getName(),
                    dependent.getRelationshipWithYou(),
                    dependent.getDateOfBirth(),
                    dependent.getAge());
            dependentsDto.add(dependentDto);
        }

        List<EmergencyContactDTO> emergencyContactsDto = new ArrayList<>();
        List<EmergencyContact> emergencyContacts = employee.getEmergencyContacts();
        for (int i = 0; i < emergencyContacts.size(); i++) {
            EmergencyContact emergencyContact = emergencyContacts.get(i);
            EmergencyContactDTO emergencyContactDto = new EmergencyContactDTO(
                    emergencyContact.getName(),
                    emergencyContact.getAddress(),
                    emergencyContact.getRelationshipWithYou(),
                    emergencyContact.getPhone());
            emergencyContactsDto.add(emergencyContactDto);
        }

        PersonalFormDTO personalForm = new PersonalFormDTO(
                employee.getTitle(),
                employee.getFirstname(),
                employee.getLastname(),
                presentAddress,
                permanentAddress,
                phonesDto,
                employee.getEmail(),
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getMaritalStatus(),
                employee.getNationality(),
                employee.getPassportNumber(),
                employee.getPlaceOfPassportIssue(),
                employee.getDateOfIssue(),
                employee.getDateOfExpiry(),
                employee.getPlaceOfBirth(),
                employee.getAadharNumber(),
                employee.getPanNumber(),
                dependentsDto,
                emergencyContactsDto);
        completeForm.setPersonalForm(personalForm);
        return completeForm;
    }

    private CompleteFormDTO fillProvidentFundForm(CompleteFormDTO completeForm, Employee employee) {
        ProvidentFund providentFund = employee.getProvidentFund();
        PreviousEmployment previousEmployment = providentFund.getPreviousEmployment();

        PreviousEmploymentDTO previousEmploymentDto = new PreviousEmploymentDTO(
                previousEmployment.getUniversalAccountNumber(),
                previousEmployment.getPfAccountNumber(),
                previousEmployment.getDateOfExit(),
                previousEmployment.getSchemeCertificateNumber(),
                previousEmployment.getPensionPaymentOrderNumber(),
                previousEmployment.isInternationalWorker(),
                previousEmployment.getCountry(),
                employee.getPassportNumber(),
                employee.getDateOfIssue(),
                employee.getDateOfExpiry());

        ProvidentFundFormDTO providentFundForm = new ProvidentFundFormDTO(
                employee.getFirstname(),
                employee.getLastname(),
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getMaritalStatus(),
                providentFund.getFatherOrSpouseName(),
                providentFund.getEmail(),
                providentFund.getPhone(),
                providentFund.isEarlierMemberOfPfScheme(),
                providentFund.isEarlierMemberOfPScheme(),
                previousEmploymentDto,
                providentFund.getAccountNumber(),
                providentFund.getIfscCode(),
                providentFund.getAadharNumber(),
                providentFund.getPanNumber()
        );
        completeForm.setProvidentFundForm(providentFundForm);
        return completeForm;
    }

    private CompleteFormDTO fillFormF(CompleteFormDTO completeForm, Employee employee) {
        AddressDTO permanentAddress = new AddressDTO(
                employee.getPermanentAddress().getShortAddress(),
                employee.getPermanentAddress().getPincode());

        List<NomineeFDTO> nomineesFDto = new ArrayList<>();
        employee.getNominees().forEach((nominee) -> {
            if (nominee.getNomineeType() == NomineeType.FORM_F
                    || nominee.getNomineeType() == NomineeType.BOTH) {
                NomineeFDTO nomineeFDto = new NomineeFDTO(
                        nominee.getName(),
                        nominee.getAddress(),
                        nominee.getRelationshipWithYou(),
                        nominee.getAge(),
                        nominee.getProportion());
                nomineesFDto.add(nomineeFDto);
            }
        });

        FormFDTO formF = new FormFDTO(
                employee.getFirstname(),
                employee.getLastname(),
                permanentAddress,
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getMaritalStatus(),
                employee.getExcludingHusbandDate(),
                employee.getReligion(),
                employee.getDepartment(),
                employee.getTicketNumber(),
                employee.getDateOfAppointment(),
                employee.getPostOffice(),
                employee.getDistrict(),
                employee.getState(),
                nomineesFDto
        );
        completeForm.setFormF(formF);
        return completeForm;
    }

    private CompleteFormDTO fillFormI(CompleteFormDTO completeForm, Employee employee) {
        AddressDTO presentAddress = new AddressDTO(
                employee.getPresentAddress().getShortAddress(),
                employee.getPresentAddress().getPincode());

        AddressDTO permanentAddress = new AddressDTO(
                employee.getPermanentAddress().getShortAddress(),
                employee.getPermanentAddress().getPincode());

        List<NomineeIDTO> nomineesIDto = new ArrayList<>();
        employee.getNominees().forEach((nominee) -> {
            if (nominee.getNomineeType() == NomineeType.FORM_I
                    || nominee.getNomineeType() == NomineeType.BOTH) {
                NomineeIDTO nomineeIDto = new NomineeIDTO(
                        nominee.getName(),
                        nominee.getAddress(),
                        nominee.getRelationshipWithYou(),
                        nominee.getAge());
                nomineesIDto.add(nomineeIDto);
            }
        });

        FormIDTO formI = new FormIDTO(
                employee.getFirstname(),
                employee.getLastname(),
                presentAddress,
                permanentAddress,
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getMaritalStatus(),
                employee.getReligion(),
                employee.getDepartment(),
                employee.getTicketNumber(),
                employee.getDateOfAppointment(),
                nomineesIDto
        );
        completeForm.setFormI(formI);
        return completeForm;
    }

    private CompleteFormDTO fillFormQ(CompleteFormDTO completeForm, Employee employee) {
        AddressDTO postalAddress = new AddressDTO(
                employee.getPostalAddress().getShortAddress(),
                employee.getPostalAddress().getPincode());

        AddressDTO permanentAddress = new AddressDTO(
                employee.getPermanentAddress().getShortAddress(),
                employee.getPermanentAddress().getPincode());

        FormQDTO formQ = new FormQDTO(
                establishmentRepository.findAll().get(0).getName(),
                establishmentRepository.findAll().get(0).getAddress(),
                establishmentRepository.findAll().get(0).getEmployerName(),
                establishmentRepository.findAll().get(0).getEmployerAddress(),
                employee.getFirstname() + " " + employee.getLastname(),
                employee.getDateOfBirth(),
                postalAddress,
                permanentAddress,
                employee.getProvidentFund().getFatherOrSpouseName(),
                employee.getDateOfAppointment(),
                employee.getDesignation(),
                employee.getNatureOfWorkEntrusted(),
                employee.getSerialNumber()
        );
        completeForm.setFormQ(formQ);
        return completeForm;
    }
}
