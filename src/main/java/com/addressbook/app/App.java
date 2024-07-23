package com.addressbook.app;

public class App {
    public static void main (String[] args){

        //Create new contacts

        Contact newContact1= new Contact("Sarah","+3466666666","sarah@email.com");
        Contact newContact2 = new Contact("Tom","+00333454673436","tom@email.com");
        Contact newContact3 = new Contact("Sally","+0123456789","sally@email.com");

        //Add contact to the Address Book

        AddressBook addressBook= new AddressBook();
        addressBook.addContact(newContact1);
        addressBook.addContact(newContact2);
        addressBook.addContact(newContact3);


        //Print contact details
        System.out.println("Contact ID: " + newContact1.getContactId() +", " +
                "Contact Name: " + newContact1.getContactName() +", " +
                "Contact Phone Number: " + newContact1.getPhoneNumber() +", " +
                "Contact Email: " + newContact1.getContactEmail() );


        //Delete a contact

        addressBook.removeContact(newContact2);

        //Edit an existing contact

        addressBook.editContact(newContact1.getContactId(), "Sarah", "+22123456789","sarah@gmail.com");

        //Search contact by Name and print out the new details

       addressBook.searchContact("Sally");

       //Display all contacts in the Address Book

       addressBook.displayAll();


       //A contact cannot be added with the same number or email than other contact

        Contact sameContact= new Contact("Sally","+0123456789","sal@email.com");
        Contact sameContact2= new Contact("Sally","+01234924859","sally@email.com");

        addressBook.addContact(sameContact);
        addressBook.addContact(sameContact2);

       





    }
}
