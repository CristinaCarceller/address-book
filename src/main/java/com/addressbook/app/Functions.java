package com.addressbook.app;

import java.util.ArrayList;

public abstract class Functions {

    private static final String phoneNumberRegEx = "^\\+[0-9]{2}\\d{7,14}$";
    private static final String emailRegEx ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


    public static String validateName(String nameToValidate){
        if(nameToValidate==null || nameToValidate.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        return nameToValidate;
    };

    public static String validatePhoneNumber(String phoneToValidate){
        if(phoneToValidate==null || phoneToValidate.trim().isEmpty()) throw new IllegalArgumentException();
        if(!phoneToValidate.matches(phoneNumberRegEx)) throw new IllegalArgumentException();
        return phoneToValidate;
    };
    public static String validateEmail(String emailToValidate){
        if(emailToValidate==null || emailToValidate.trim().isEmpty()) throw new IllegalArgumentException();
        if(!emailToValidate.matches(emailRegEx)) throw new IllegalArgumentException() ;
        return emailToValidate;
    };

    public static boolean duplicateNumber (Contact contact, ArrayList<Contact>contacts){
        for (Contact currentContact: contacts){
            if (currentContact.getPhoneNumber().equals(contact.getPhoneNumber())) {
                return true;
            }
        }
            return false;
        };

    public static boolean duplicateEmail (Contact contact, ArrayList<Contact>contacts){
        for (Contact currentContact: contacts){
            if (currentContact.getContactEmail().equals(contact.getContactEmail())) {
                return true;
            }
        }
        return false;
    }

    public static void displayContact(Contact contact){
        System.out.println("Contact ID: " + contact.getContactId());
        System.out.println("Contact Name: " + contact.getContactName());
        System.out.println("Contact Phone Number: " + contact.getPhoneNumber());
        System.out.println("Contact Email: " + contact.getContactEmail());
    }




}

