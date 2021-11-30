import { PhoneType } from '../models/enums.models';
import { Phone } from '../models/forms.model';

function checkforAllNull(object: any): boolean {
  const values = Object.values(object);
  for (const value of values) {
    if (value) {
      if (typeof value === 'object') {
        return checkforAllNull(value);
      } else {
        return false;
      }
    }
  }
  return true;
}

export function isEmpty(object: any): boolean {
  return object ? (Object.keys(object).length === 0 ? true : checkforAllNull(object)) : true;
}

export function getMobilePhone(): Phone {
  const phone = new Phone();
  phone.phoneType = PhoneType.MOBILE;
  return phone;
}

export function getHomePhone(): Phone {
  const phone = new Phone();
  phone.phoneType = PhoneType.HOME;
  return phone;
}

export function getWorkPhone(): Phone {
  const phone = new Phone();
  phone.phoneType = PhoneType.WORK;
  return phone;
}
