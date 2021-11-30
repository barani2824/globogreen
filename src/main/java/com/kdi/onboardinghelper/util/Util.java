/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.util;

import com.kdi.onboardinghelper.model.PhoneType;
import com.kdi.onboardinghelper.service.dto.PhoneDTO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subasb
 */
public class Util {

    public static String FormatDate(Date date) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return DateFor.format(date);
        } catch (Exception e) {
            return "N/A";
        }
    }

    public static String getMobileNumber(List<PhoneDTO> phones) {
        for (int i = 0; i < phones.size(); i++) {
            PhoneDTO phone = phones.get(i);
            if (phone.getPhoneType() == PhoneType.MOBILE) {
                return phone.getNumber();
            }
        }
        return "N/A";
    }

    public static String getHomeNumber(List<PhoneDTO> phones) {
        for (int i = 0; i < phones.size(); i++) {
            PhoneDTO phone = phones.get(i);
            if (phone.getPhoneType() == PhoneType.HOME) {
                return phone.getNumber();
            }
        }
        return "N/A";
    }

    public static String getWorkNumber(List<PhoneDTO> phones) {
        for (int i = 0; i < phones.size(); i++) {
            PhoneDTO phone = phones.get(i);
            if (phone.getPhoneType() == PhoneType.WORK) {
                return phone.getNumber();
            }
        }
        return "N/A";
    }

    public static String HandleNull(String value) {
        return value == null ? "" : value;
    }

    public static List<String> SplitTheString(String address, int maxChar) {
        String[] strArr = address.split(" ");
        List<String> finalArr = new ArrayList<>();
        finalArr.add("");

        for (int i = 0; i < strArr.length; i++) {
            int lastIndex = finalArr.size() - 1;
            if (finalArr.get(lastIndex).length() + strArr[i].length() > maxChar) {
                finalArr.set(lastIndex, finalArr.get(lastIndex).trim());
                finalArr.add(strArr[i]);
            } else {
                finalArr.set(lastIndex, (finalArr.get(lastIndex) + " " + strArr[i]));
                if (i == strArr.length - 1) {
                    finalArr.set(lastIndex, finalArr.get(lastIndex).trim());
                }
            }
        }
        return finalArr;
    }

    public static String HandleBoolean(boolean value) {
        return value == true ? "YES" : "NO";
    }
}
