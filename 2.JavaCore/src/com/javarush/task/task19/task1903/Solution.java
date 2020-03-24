package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import com.sun.org.apache.bcel.internal.Constants;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            String name = this.data.getContactLastName() + ", " + this.data.getContactFirstName();
            return name;
        }

        @Override
        public String getPhoneNumber() {
            String getPhone = String.valueOf(this.data.getPhoneNumber());
            String prefix = "";
            if (getPhone.length() < 10) {
                for (int i = 0; i < 10 - getPhone.length(); i++) {
                    prefix = prefix + "0";
                }
            }
            getPhone = prefix + getPhone;
            String result = "+" + this.data.getCountryPhoneCode() + "(" + getPhone.substring(0, 3) + ")" +
                    getPhone.substring(3, 6) + "-" + getPhone.substring(6, 8) + "-" + getPhone.substring(8, 10);
            return result;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}