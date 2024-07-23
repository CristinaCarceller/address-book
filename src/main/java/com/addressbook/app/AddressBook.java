package com.addressbook.app;

import java.util.ArrayList;


public class AddressBook {


    private final ArrayList<Contact> contacts;

    public AddressBook (){

        this.contacts = new ArrayList<>();
    }


    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact){
        if(Functions.duplicateNumber(contact,contacts)|| Functions.duplicateEmail(contact, contacts)){
            System.out.println("Phone number "+contact.getPhoneNumber()+" or email address "+ contact.getContactEmail()+ " already exist for another contact.");
           return;
        }
        contacts.add(contact);
        System.out.println("Contact " + contact.getContactName() + " was added.");
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
        System.out.println("Contact " + contact.getContactName() + " was deleted.");
    }

    public boolean searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equals(name)) {
                Functions.displayContact(contact);
                return true;
            }
        }
            return false;
    }

    public boolean editContact(Integer contactId, String contactName, String phoneNumber, String email){
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setContactName(contactName);
                contact.setPhoneNumber(phoneNumber);
                contact.setContactEmail(email);
                System.out.println("Contact "+ contact.getContactName()+" was updated.");
                return true;
            }
        }
        return false;
    }

    public void displayAll(){
        for (Contact i: contacts) {
            Functions.displayContact(i);
        }
    }



     }


