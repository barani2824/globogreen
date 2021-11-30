/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service;

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
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;
import com.kdi.onboardinghelper.model.Employee;
import com.kdi.onboardinghelper.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author subasb
 */
@Service
public class PdfService {

    @Autowired
    private HelperService helperService;

    public File fillAndGetBasicForm(Long id) {
        BasicFormDTO basicForm = helperService.getBasicFormById(id);
        try {
            com.itextpdf.text.pdf.PdfReader reader = new com.itextpdf.text.pdf.PdfReader("src/main/resources/pdf/named/basic_form.pdf");
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("src/main/resources/pdf/output/basic_form.pdf"));
            AcroFields form = stamper.getAcroFields();
            java.util.List<AcroFields.FieldPosition> photo = form.getFieldPositions("photo");
            if (photo != null && photo.size() > 0) {
                Rectangle rect = photo.get(0).position;
                String photoString = basicForm.getPhoto().split(",")[1];
                byte[] photoBytes = Base64.getDecoder().decode(photoString);
                Image img = Image.getInstance(photoBytes);
                img.scaleAbsolute(rect);
                img.setAbsolutePosition(
                        rect.getLeft() + (rect.getWidth() - img.getScaledWidth()),
                        rect.getTop() - (rect.getHeight()));
                PdfContentByte cb = stamper.getOverContent((int) photo.get(0).page);
                cb.addImage(img);
            }
            form.setField("name", basicForm.getFirstname() + " " + Util.HandleNull(basicForm.getLastname()));
            form.setField("address", basicForm.getAddress().getShortAddress() + " " + basicForm.getAddress().getPincode());
            form.setField("bloodGroup", basicForm.getBloodGroup());
            form.setField("employeeCode", basicForm.getEmployeeCode());
            form.setField("dob", Util.FormatDate(basicForm.getDateOfBirth()));
            stamper.setFormFlattening(false);
            stamper.close();
            reader.close();
            return new File("src/main/resources/pdf/output/basic_form.pdf");
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (DocumentException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

    }

    public File fillAndGetPersonalForm(Long id) {
        File file = new File("src/main/resources/pdf/output/personal_form.pdf");
        PersonalFormDTO personalForm = helperService.getPersonalFormById(id);

        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(ResourceUtils.getFile("classpath:pdf/named/personal_form.pdf")),
                new PdfWriter(file))) {

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
            form.setGenerateAppearance(true);

            form.getField("title").setValue(personalForm.getTitle());
            form.getField("firstname").setValue(personalForm.getFirstname());
            form.getField("lastname").setValue(Util.HandleNull(personalForm.getLastname()));
            form.getField("gender").setValue(personalForm.getGender());
            form.getField("nationality").setValue(personalForm.getNationality());
            form.getField("passportNumber").setValue(personalForm.getPassportNumber());
            form.getField("placeOfPassportIssue").setValue(personalForm.getPlaceOfPassportIssue());
            form.getField("dateOfIssue").setValue(Util.FormatDate(personalForm.getDateOfIssue()));
            form.getField("dateOfExpiry").setValue(Util.FormatDate(personalForm.getDateOfExpiry()));
            form.getField("maritalStatus").setValue(personalForm.getMaritalStatus());
            form.getField("dob").setValue(Util.FormatDate(personalForm.getDateOfBirth()));
            form.getField("placeOfBirth").setValue(personalForm.getPlaceOfBirth());
            form.getField("aadharCard").setValue(personalForm.getAadharNumber());
            form.getField("panCard").setValue(Util.HandleNull(personalForm.getPanNumber()));

            List<String> presentAddressList = Util.SplitTheString(personalForm.getPresentAddress().getShortAddress(), 80);
            for (int i = 1; i <= Math.min(presentAddressList.size(), 3); i++)
                form.getField("presentAddress" + i).setValue(presentAddressList.get(i - 1));
            form.getField("presentAddressPincode").setValue(personalForm.getPresentAddress().getPincode());

            List<String> permanentAddressList = Util.SplitTheString(personalForm.getPermanentAddress().getShortAddress(), 80);
            for (int i = 1; i <= Math.min(permanentAddressList.size(), 3); i++)
                form.getField("permanentAddress" + i).setValue(permanentAddressList.get(i - 1));
            form.getField("permanentAddressPincode").setValue(personalForm.getPermanentAddress().getPincode());

            form.getField("email").setValue(personalForm.getEmail());
            form.getField("phoneMobile").setValue(Util.getMobileNumber(personalForm.getPhones()));
            form.getField("noOfDependents").setValue(String.valueOf(personalForm.getDependents().size()));

            List<DependentDTO> dependents = personalForm.getDependents();
            for (int i = 1; i <= Math.min(dependents.size(), 2); i++) {
                DependentDTO dependent = dependents.get(i - 1);
                form.getField("dep" + i + "Name").setValue(dependent.getName());
                form.getField("dep" + i + "Relationship").setValue(dependent.getRelationshipWithYou());
                form.getField("dep" + i + "Dob").setValue(Util.FormatDate(dependent.getDateOfBirth()));
                form.getField("dep" + i + "Age").setValue(String.valueOf(dependent.getAge()));
            }

            List<EmergencyContactDTO> emergencyContacts = personalForm.getEmergencyContacts();
            for (int i = 1; i <= Math.min(emergencyContacts.size(), 2); i++) {
                EmergencyContactDTO emergencyContact = emergencyContacts.get(i - 1);
                form.getField("emergencyName" + i).setValue(emergencyContact.getName());
                List<String> emergencyContactAddressList = Util.SplitTheString(emergencyContact.getAddress(), 80);
                form.getField("emergencyAddress" + i).setValue(emergencyContactAddressList.get(0));
                if (emergencyContactAddressList.size() > 1)
                    form.getField("emergencyPincode" + i).setValue(emergencyContactAddressList.get(1));
                form.getField("emergencyAddress" + i).setValue(emergencyContact.getAddress());
                form.getField("emergencyRelation" + i).setValue(emergencyContact.getRelationshipWithYou());
                form.getField("emergencyPhoneHome" + i).setValue("N/A");
                form.getField("emergencyPhoneMobile" + i).setValue(emergencyContact.getPhone());
                form.getField("emergencyPhoneWork" + i).setValue("N/A");
            }
            form.flattenFields();
            return file;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public File fillAndGetProvidentFundForm(Long id) {
        File file = new File("src/main/resources/pdf/output/pf_form.pdf");
        ProvidentFundFormDTO providentFundForm = helperService.getProvidentFormById(id);
        PreviousEmploymentDTO previousEmployment = providentFundForm.getPreviousEmployment();

        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(ResourceUtils.getFile("classpath:pdf/named/pf_form.pdf")),
                new PdfWriter(file))) {

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
            form.setGenerateAppearance(true);

            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
            form.getField("name").setValue(providentFundForm.getFirstname() + " " + Util.HandleNull(providentFundForm.getLastname()), font, 8f);
            form.getField("fatherOrSpouseName").setValue(providentFundForm.getFatherOrSpouseName(), font, 8f);
            form.getField("dob").setValue(Util.FormatDate(providentFundForm.getDateOfBirth()), font, 8f);
            form.getField("gender").setValue(providentFundForm.getGender(), font, 8f);
            form.getField("maritalStatus").setValue(providentFundForm.getMaritalStatus(), font, 8f);
            form.getField("email").setValue(providentFundForm.getEmail(), font, 8f);
            form.getField("phoneMobile").setValue(providentFundForm.getPhone(), font, 8f);
            form.getField("pfScheme").setValue(Util.HandleBoolean(providentFundForm.isEarlierMemberOfPfScheme()), font, 8f);
            form.getField("pensionScheme").setValue(Util.HandleBoolean(providentFundForm.isEarlierMemberOfPScheme()), font, 8f);
            form.getField("universalAccNumber").setValue(Util.HandleNull(previousEmployment.getUniversalAccountNumber()), font, 8f);
            form.getField("pfAccNumber").setValue(Util.HandleNull(previousEmployment.getPfAccountNumber()), font, 8f);
            form.getField("doe").setValue(Util.FormatDate(previousEmployment.getDateOfExit()), font, 8f);
            form.getField("schemeCertificateNo").setValue(Util.HandleNull(previousEmployment.getSchemeCertificateNumber()), font, 8f);
            form.getField("ppo").setValue(Util.HandleNull(previousEmployment.getPensionPaymentOrderNumber()), font, 8f);
            form.getField("internationalWorker").setValue(Util.HandleBoolean(previousEmployment.isInternationalWorker()), font, 8f);
            form.getField("countryOfOrigin").setValue(Util.HandleNull(previousEmployment.getCountry()), font, 8f);
            form.getField("passportNumber").setValue(previousEmployment.getPassportNumber(), font, 8f);
            form.getField("dateOfIssue").setValue(Util.FormatDate(providentFundForm.getPreviousEmployment().getDateOfIssue()), font, 8f);
            form.getField("dateOfExpiry").setValue(Util.FormatDate(providentFundForm.getPreviousEmployment().getDateOfExpiry()), font, 8f);
            form.getField("accountNumber").setValue(providentFundForm.getAadharNumber(), font, 8f);
            form.getField("aadharCard").setValue(providentFundForm.getAadharNumber(), font, 8f);
            form.getField("panCard").setValue(Util.HandleNull(providentFundForm.getPanNumber()), font, 8f);
            form.getField("declarationName").setValue(providentFundForm.getFirstname() + " " + Util.HandleNull(providentFundForm.getLastname()), font, 8f);
            form.flattenFields();
            return file;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public File fillAndGetFormF(Long id) {
        File file = new File("src/main/resources/pdf/output/form_f.pdf");
        FormFDTO formF = helperService.getFormFById(id);
        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(ResourceUtils.getFile("classpath:pdf/named/form_f.pdf")),
                new PdfWriter(file))) {

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
            form.setGenerateAppearance(true);

            form.getField("name").setValue(formF.getFirstname() + " " + Util.HandleNull(formF.getLastname()));
            form.getField("noticeDate").setValue(Util.FormatDate(formF.getExcludingHusbandDate()));
            List<NomineeFDTO> nominees = formF.getNominees();
            for (int i = 1; i <= Math.min(nominees.size(), 4); i++) {
                NomineeFDTO nominee = nominees.get(i - 1);
                form.getField("nomineeName" + i).setValue(nominee.getName() + " : " + nominee.getAddress());
                form.getField("nomineeRelation" + i).setValue(nominee.getRelationshipWithYou());
                form.getField("nomineeAge" + i).setValue(String.valueOf(nominee.getAge()));
                form.getField("nomineeProportion" + i).setValue(String.valueOf(nominee.getProportion()));
            }

            form.getField("fullName").setValue(formF.getFirstname() + " " + Util.HandleNull(formF.getLastname()));
            form.getField("sex").setValue(formF.getGender());
            form.getField("religion").setValue(formF.getReligion());
            form.getField("maritalStatus").setValue(formF.getMaritalStatus());
            form.getField("department").setValue(formF.getDepartment());
            form.getField("ticketNo").setValue(Util.HandleNull(formF.getTicketNumber()));
            form.getField("doa").setValue(Util.FormatDate(formF.getDateOfAppointment()));
            form.getField("permanentAddress").setValue(formF.getPermanentAddress().getShortAddress() + " " + formF.getPermanentAddress().getPincode());
            form.getField("postOffice").setValue(formF.getPostOffice());
            form.getField("district").setValue(formF.getDistrict());
            form.getField("state").setValue(formF.getState());
            form.flattenFields();
            return file;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public File fillAndGetFormI(Long id) {
        File file = new File("src/main/resources/pdf/output/form_i.pdf");
        FormIDTO formI = helperService.getFormIById(id);
        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(ResourceUtils.getFile("classpath:pdf/named/form_i.pdf")),
                new PdfWriter(file))) {

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
            form.setGenerateAppearance(true);

            form.getField("name").setValue(formI.getFirstname() + " " + Util.HandleNull(formI.getLastname()));
            List<NomineeIDTO> nominees = formI.getNominees();
            for (int i = 1; i <= Math.min(nominees.size(), 2); i++) {
                NomineeIDTO nominee = nominees.get(i - 1);
                form.getField("nomineeName" + i).setValue(nominee.getName() + " : " + nominee.getAddress());
                form.getField("nomineeRelation" + i).setValue(nominee.getRelationshipWithYou());
                form.getField("nomineeAge" + i).setValue(String.valueOf(nominee.getAge()));
            }
            form.getField("fullName").setValue(formI.getFirstname() + " " + Util.HandleNull(formI.getLastname()));
            form.getField("sex").setValue(formI.getGender());
            form.getField("religion").setValue(formI.getReligion());
            form.getField("maritalStatus").setValue(formI.getMaritalStatus());
            form.getField("department").setValue(formI.getDepartment());
            form.getField("ticketNo").setValue(Util.HandleNull(formI.getTicketNumber()));
            form.getField("doa").setValue(Util.FormatDate(formI.getDateOfAppointment()));
            form.getField("postalAddress").setValue(formI.getPresentAddress().getShortAddress() + " " + formI.getPresentAddress().getPincode());
            form.getField("permanentAddress").setValue(formI.getPermanentAddress().getShortAddress() + " " + formI.getPermanentAddress().getPincode());
            form.flattenFields();
            return file;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public File fillAndGetFormQ(Long id) {
        File file = new File("src/main/resources/pdf/output/form_q.pdf");
        FormQDTO formQ = helperService.getFormQById(id);
        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(ResourceUtils.getFile("classpath:pdf/named/form_q.pdf")),
                new PdfWriter(file))) {

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
            form.setGenerateAppearance(true);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

            form.getField("nameAndAddressOfEstablishment").setValue(formQ.getNameOfEstablishment() + " : " + formQ.getAddressOfEstablishment());
            form.getField("nameAndAddressOfEmployer").setValue(formQ.getNameOfEmployer() + " : " + formQ.getAddressOfEmployer());
            form.getField("name").setValue(formQ.getFullname());
            form.getField("postalAddress").setValue(formQ.getPostalAddress().getShortAddress() + " " + formQ.getPostalAddress().getPincode());
            form.getField("permanentAddress").setValue(formQ.getPermanentAddress().getShortAddress() + " " + formQ.getPermanentAddress().getPincode());
            form.getField("fatherOrSpouseName").setValue(formQ.getFatherOrSpouseName());
            form.getField("dob").setValue(Util.FormatDate(formQ.getDateOfBirth()));
            form.getField("doa").setValue(Util.FormatDate(formQ.getDateOfAppointment()));
            form.getField("designation").setValue(Util.HandleNull(formQ.getDesignation()));
            form.getField("natureOfWork").setValue(Util.HandleNull(formQ.getNatureOfWorkEntrusted()));
            form.getField("serialNo").setValue(Util.HandleNull(formQ.getSerialNumber()));

            form.getField("basic").setValue("", font, 8f);
            form.getField("vda").setValue("", font, 8f);
            form.getField("other").setValue("", font, 8f);
            form.getField("total").setValue("", font, 8f);
            form.flattenFields();
            return file;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public File mergeAllForms(String email) throws FileNotFoundException, IOException {

        Employee employee = helperService.getEmployeeByEmail(email);
        Long id = employee.getId();
        File file1 = fillAndGetBasicForm(id);
        File file2 = fillAndGetPersonalForm(id);
        File file3 = fillAndGetProvidentFundForm(id);
        File file4 = fillAndGetFormF(id);
        File file5 = fillAndGetFormI(id);
        File file6 = fillAndGetFormQ(id);

        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.addSource(file1);
        pdfMerger.addSource(file2);
        pdfMerger.addSource(file3);
        pdfMerger.addSource(file4);
        pdfMerger.addSource(file5);
        pdfMerger.addSource(file6);

        pdfMerger.setDestinationFileName("src/main/resources/pdf/output/allForms.pdf");
        pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        return new File("src/main/resources/pdf/output/allForms.pdf");
    }

    public File GetFile(String filename) {
        return new File(getClass().getClassLoader().getResource(filename).getFile());
    }

    public InputStream GetFileStream(String filename) {
        return getClass().getResourceAsStream(filename);
    }
}
