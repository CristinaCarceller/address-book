package com.addressbook.app;

public class Contact {

    private static int nextId = 1;
    private Integer id;
    private String contactName;
    private String phoneNumber;
    private String contactEmail;

    public Contact (String contactName, String phoneNumber, String contactEmail){
        this.id = nextId++;
        this.contactName = Functions.validateName(contactName);
        this.phoneNumber = Functions.validatePhoneNumber(phoneNumber);
        this.contactEmail = Functions.validateEmail(contactEmail);

    }

    public Integer getContactId(){
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
