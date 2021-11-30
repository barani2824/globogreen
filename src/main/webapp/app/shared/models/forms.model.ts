import { BloogGroup, Title, MaritialStatus, PhoneType } from './enums.models';

export class CommonDetails {
  firstname: string | undefined;
  lastname?: string | undefined;
  dateOfBirth: Date | null;
  gender: 'Male' | 'Female' | 'Other' | null;
  maritalStatus: MaritialStatus | null;

  constructor(commonDetails?: CommonDetails) {
    const { firstname: firstname = undefined, lastname = undefined, dateOfBirth = null, gender = null, maritalStatus = null } =
      commonDetails || {};

    this.firstname = firstname;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
  }
}

export class Address {
  shortAddress: string | null;
  pincode: string | null;

  constructor(address?: Address) {
    const { shortAddress = null, pincode = null } = address || {};

    this.shortAddress = shortAddress;
    this.pincode = pincode;
  }
}

export class Dependent {
  name: string | null;
  relationshipWithYou: string | null;
  dateOfBirth: Date | null;
  age: number | 0;

  constructor(dependent?: Dependent) {
    const { name = null, relationshipWithYou = null, dateOfBirth: dateOfBirth = null, age = 0 } = dependent || {};

    this.name = name;
    this.relationshipWithYou = relationshipWithYou;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
  }
}

export class Phone {
  phoneType: PhoneType | null;
  number: string | null;

  constructor(phone?: Phone) {
    const {
      phoneType = null,
      // tslint:disable-next-line: variable-name
      number = null,
    } = phone || {};

    this.phoneType = phoneType;
    this.number = number;
  }
}

export class EmergencyContact {
  name: string | null;
  address: string | null;
  relationshipWithYou: string | null;
  phone: string | null;

  constructor(emergencyContact?: EmergencyContact) {
    const { name = null, address = null, relationshipWithYou = null, phone = null } = emergencyContact || {};

    this.name = name;
    this.address = address;
    this.relationshipWithYou = relationshipWithYou;
    this.phone = phone;
  }
}

export class EmploymentDetails {
  universalAccountNumber: string | null;
  pFAccountNumber: string | null;
  dateOfExit: Date | null;
  schemeCertificateNumber?: string | null;
  pensionPaymentOrderNumber?: string | null;
  isInternationalWorker: boolean;
  country: string | null;
  passportNumber: string | null;
  dateOfIssue: Date | null;
  dateOfExpiry: Date | null;

  constructor(employmentDetails?: EmploymentDetails) {
    const {
      universalAccountNumber = null,
      pFAccountNumber = null,
      dateOfExit = null,
      schemeCertificateNumber = null,
      pensionPaymentOrderNumber = null,
      isInternationalWorker = false,
      country = null,
      passportNumber = null,
      dateOfIssue = null,
      dateOfExpiry = null,
    } = employmentDetails || {};

    this.universalAccountNumber = universalAccountNumber;
    this.pFAccountNumber = pFAccountNumber;
    this.dateOfExit = dateOfExit;
    this.schemeCertificateNumber = schemeCertificateNumber;
    this.pensionPaymentOrderNumber = pensionPaymentOrderNumber;
    this.isInternationalWorker = isInternationalWorker;
    this.country = country;
    this.passportNumber = passportNumber;
    this.dateOfIssue = dateOfIssue;
    this.dateOfExpiry = dateOfExpiry;
  }
}

export class RateOfWage {
  basic: number | 0;
  vda: number | 0;
  otherAllowances: number | 0;
  private Total: number | 0;

  constructor(rateOfWages?: RateOfWage) {
    const { basic = 0, vda = 0, otherAllowances = 0, total = 0 } = rateOfWages || {};

    this.basic = basic;
    this.vda = vda;
    this.otherAllowances = otherAllowances;
    this.Total = total;
  }

  get total(): number {
    return (this.Total = this.basic + this.vda + this.otherAllowances);
  }

  set total(value: number) {
    this.Total = value;
  }
}

export class Nominee {
  name: string | null;
  address: string | null;
  relationshipWithYou: string | null;
  age: number | 0;
  proportion?: number | 0;

  constructor(nominee?: Nominee) {
    const { name = null, address = null, relationshipWithYou = null, age = 0, proportion = 0 } = nominee || {};

    this.name = name;
    this.address = address;
    this.relationshipWithYou = relationshipWithYou;
    this.age = age;
    this.proportion = proportion;
  }
}

export interface FormValidity {
  basicForm: boolean;
  personalForm: boolean;
  pFForm: boolean;
  formF: boolean;
  formI: boolean;
  formQ: boolean;
}

// Actual Forms
export class BasicForm {
  firstname: string | undefined;
  lastname: string | undefined;
  address: Address;
  dateOfBirth: Date | null;
  employeeCode: string | null;
  bloodGroup: BloogGroup | null;
  photo: string | null;

  constructor(basicForm?: BasicForm) {
    const {
      firstname = undefined,
      lastname = undefined,
      address = new Address(),
      dateOfBirth = null,
      employeeCode = null,
      bloodGroup = null,
      photo = null,
    } = basicForm || {};

    this.lastname = lastname;
    this.firstname = firstname;
    this.address = new Address(address);
    this.dateOfBirth = dateOfBirth;
    this.employeeCode = employeeCode;
    this.bloodGroup = bloodGroup;
    this.photo = photo;
  }
}

export class PersonalForm extends CommonDetails {
  title: Title | null;
  nationality: string | null;
  passportNumber: string | null;
  placeOfPassportIssue: string | null;
  dateOfIssue: Date | null;
  dateOfExpiry: Date | null;
  placeOfBirth: string | null;
  aadharNumber: string | null;
  panNumber: string | null;
  presentAddress: Address;
  permanentAddress: Address;
  email: string | undefined;
  phones: Phone[];
  dependents: Dependent[];
  emergencyContacts: EmergencyContact[];

  constructor(personalForm?: PersonalForm) {
    const {
      firstname = undefined,
      lastname = undefined,
      dateOfBirth = null,
      gender = null,
      maritalStatus = null,
      phones = [] as Phone[],
      presentAddress = new Address(),
      permanentAddress = new Address(),
      dependents = [] as Dependent[],
      emergencyContacts = [] as EmergencyContact[],
      title = null,
      nationality = null,
      passportNumber = null,
      placeOfPassportIssue = null,
      dateOfIssue = null,
      dateOfExpiry = null,
      placeOfBirth = null,
      aadharNumber = null,
      panNumber = null,
      email = undefined,
    } = personalForm || {};
    super({
      firstname,
      lastname,
      dateOfBirth,
      gender,
      maritalStatus,
    } as CommonDetails);

    this.phones = this.copyPhones(phones);
    this.presentAddress = new Address(presentAddress);
    this.permanentAddress = new Address(permanentAddress);
    this.dependents = this.copyDependents(dependents);
    this.emergencyContacts = this.copyEmergencyContacts(emergencyContacts);
    this.title = title;
    this.nationality = nationality;
    this.passportNumber = passportNumber;
    this.placeOfPassportIssue = placeOfPassportIssue;
    this.dateOfIssue = dateOfIssue;
    this.dateOfExpiry = dateOfExpiry;
    this.placeOfBirth = placeOfBirth;
    this.aadharNumber = aadharNumber;
    this.panNumber = panNumber;
    this.email = email;
  }

  private copyPhones(phones: Phone[]): Phone[] {
    return phones.map(phone => {
      return new Phone(phone);
    });
  }

  private copyDependents(dependents: Dependent[]): Dependent[] {
    return dependents.map(dependent => {
      return new Dependent(dependent);
    });
  }

  private copyEmergencyContacts(emergencyContacts: EmergencyContact[]): EmergencyContact[] {
    return emergencyContacts.map(emergencyContact => {
      return new EmergencyContact(emergencyContact);
    });
  }
}

export class ProvidentFundForm extends CommonDetails {
  fatherOrSpouseName: string | null;
  email: string | undefined;
  phone: string | null | null;
  isEarlierMemberOfPFScheme: boolean;
  isEarlierMemberOfPScheme: boolean;
  previousEmployment: EmploymentDetails;
  accountNumber: string | null;
  ifscCode: string | null;
  aadharNumber: string | null;
  panNumber?: string | null;

  constructor(providentFundForm?: ProvidentFundForm) {
    const {
      firstname = undefined,
      lastname = undefined,
      dateOfBirth = null,
      gender = null,
      maritalStatus = null,
      fatherOrSpouseName = null,
      email = undefined,
      phone = null,
      isEarlierMemberOfPFScheme = false,
      isEarlierMemberOfPScheme = false,
      previousEmployment = new EmploymentDetails(),
      accountNumber = null,
      ifscCode = null,
      aadharNumber = null,
      panNumber = null,
    } = providentFundForm || {};

    super({
      firstname,
      lastname,
      dateOfBirth,
      gender,
      maritalStatus,
    } as CommonDetails);

    this.lastname = lastname;
    this.fatherOrSpouseName = fatherOrSpouseName;
    this.email = email;
    this.phone = phone;
    this.isEarlierMemberOfPFScheme = isEarlierMemberOfPFScheme;
    this.isEarlierMemberOfPScheme = isEarlierMemberOfPScheme;
    this.previousEmployment = new EmploymentDetails(previousEmployment);
    this.accountNumber = accountNumber;
    this.ifscCode = ifscCode;
    this.aadharNumber = aadharNumber;
    this.panNumber = panNumber;
  }
}

export class FormF extends CommonDetails {
  excludingHusbandDate: Date | null;
  nominees: Nominee[];
  religion: string | null;
  department: string | null;
  ticketNumber: string | null;
  dateOfAppointment: Date | null;
  permanentAddress: Address;
  postOffice: string | null;
  district: string | null;
  state: string | null;

  constructor(formF?: FormF) {
    const {
      firstname = undefined,
      lastname = undefined,
      dateOfBirth = null,
      gender = null,
      maritalStatus = null,
      excludingHusbandDate = null,
      nominees = [] as Nominee[],
      religion = null,
      department = null,
      ticketNumber = null,
      dateOfAppointment = null,
      permanentAddress = new Address(),
      postOffice = null,
      district = null,
      state = null,
    } = formF || {};

    super({
      firstname,
      lastname,
      dateOfBirth,
      gender,
      maritalStatus,
    } as CommonDetails);

    this.excludingHusbandDate = excludingHusbandDate;
    this.nominees = this.copyNominees(nominees);
    this.religion = religion;
    this.department = department;
    this.ticketNumber = ticketNumber;
    this.dateOfAppointment = dateOfAppointment;
    this.permanentAddress = new Address(permanentAddress);
    this.postOffice = postOffice;
    this.district = district;
    this.state = state;
  }

  private copyNominees(nominees: Nominee[]): Nominee[] {
    return nominees.map(nominee => {
      return new Nominee(nominee);
    });
  }
}

export class FormI extends CommonDetails {
  nominees: Nominee[];
  religion: string | null;
  department: string | null;
  ticketNumber: string | null;
  dateOfAppointment: Date | null;
  presentAddress: Address;
  permanentAddress: Address;

  constructor(formI?: FormI) {
    const {
      firstname = undefined,
      lastname = undefined,
      dateOfBirth = null,
      gender = null,
      maritalStatus = null,
      nominees = [] as Nominee[],
      religion = null,
      department = null,
      ticketNumber = null,
      dateOfAppointment = null,
      presentAddress = new Address(),
      permanentAddress = new Address(),
    } = formI || {};

    super({
      firstname,
      lastname,
      dateOfBirth,
      gender,
      maritalStatus,
    } as CommonDetails);

    this.nominees = this.copyNominees(nominees);
    this.religion = religion;
    this.department = department;
    this.ticketNumber = ticketNumber;
    this.dateOfAppointment = dateOfAppointment;
    this.presentAddress = new Address(presentAddress);
    this.permanentAddress = new Address(permanentAddress);
  }

  private copyNominees(nominees: Nominee[]): Nominee[] {
    return nominees.map(nominee => {
      return new Nominee(nominee);
    });
  }
}

export class FormQ {
  nameOfEstablishment: string | null;
  addressOfEstablishment: string | null;
  nameOfEmployer: string | null;
  addressOfEmployer: string | null;
  fullname: string | null;
  postalAddress: Address;
  permanentAddress: Address;
  fatherOrSpouseName: string | null;
  dateOfBirth: Date | null;
  dateOfAppointment: Date | null;
  designation: string | null;
  natureOfWorkEntrusted: string | null;
  serialNumber: string | null;
  rateOfWage: RateOfWage;

  constructor(formQ?: FormQ) {
    const {
      nameOfEstablishment = null,
      addressOfEstablishment = null,
      nameOfEmployer = null,
      addressOfEmployer = null,
      fullname = null,
      postalAddress = new Address(),
      permanentAddress = new Address(),
      fatherOrSpouseName = null,
      dateOfBirth = null,
      dateOfAppointment = null,
      designation = null,
      natureOfWorkEntrusted = null,
      serialNumber = null,
      rateOfWage = new RateOfWage(),
    } = formQ || {};

    this.nameOfEstablishment = nameOfEstablishment;
    this.addressOfEstablishment = addressOfEstablishment;
    this.nameOfEmployer = nameOfEmployer;
    this.addressOfEmployer = addressOfEmployer;
    this.fullname = fullname;
    this.postalAddress = postalAddress;
    this.permanentAddress = permanentAddress;
    this.fatherOrSpouseName = fatherOrSpouseName;
    this.dateOfBirth = dateOfBirth;
    this.dateOfAppointment = dateOfAppointment;
    this.designation = designation;
    this.natureOfWorkEntrusted = natureOfWorkEntrusted;
    this.serialNumber = serialNumber;
    this.rateOfWage = new RateOfWage(rateOfWage);
  }
}

export class CompleteForm {
  employeeId: number | null;
  basicForm: BasicForm;
  personalForm: PersonalForm;
  providentFundForm: ProvidentFundForm;
  formF: FormF;
  formI: FormI;
  formQ: FormQ;

  constructor(completeForm?: CompleteForm) {
    const {
      employeeId = null,
      basicForm = new BasicForm(),
      personalForm = new PersonalForm(),
      providentFundForm = new ProvidentFundForm(),
      formF = new FormF(),
      formI = new FormI(),
      formQ = new FormQ(),
    } = completeForm || {};

    this.employeeId = employeeId;
    this.basicForm = new BasicForm(basicForm);
    this.personalForm = new PersonalForm(personalForm);
    this.providentFundForm = new ProvidentFundForm(providentFundForm);
    this.formF = new FormF(formF);
    this.formI = new FormI(formI);
    this.formQ = new FormQ(formQ);
  }
}
