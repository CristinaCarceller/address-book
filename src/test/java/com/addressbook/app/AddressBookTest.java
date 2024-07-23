package com.addressbook.app;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Nested
    @DisplayName("AddressBook Constructor Test")
    class AddressBookConstructorTests {

        @Test
        @DisplayName("Constructor Sets Empty Array Contacts")
        public void testConstructorReturnsEmptyArray() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();

            //Act
            //Assert
            assertTrue(testAddressBook.getContacts().isEmpty());
        }
    }

    @Nested
    @DisplayName("AddressBook Add Method Test")
    class AddressBookAddMethodTests {

        @Test
        @DisplayName("Test Add Method Increment Contacts Array by 1")
        public void testAddIncrementContactsArray() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            //Act
            testAddressBook.addContact(testContact);
            //Assert
            assertEquals(1, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("Test Method Adds Contact to Array of Contacts")
        public void testAddMethodAddsContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            //Act
            testAddressBook.addContact(testContact);
            //Assert
            assertTrue(testAddressBook.getContacts().contains(testContact));
        }
    }

    @Nested
    @DisplayName("AddressBook Remove Method Test")
    class AddressBookRemoveMethodTests {

        @Test
        @DisplayName("Test Remove Method Decrement Contacts Array by 1")
        public void testAddIncrementContactsArray() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            testAddressBook.addContact(testContact);
            //Act
            testAddressBook.removeContact(testContact);
            //Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("Test Method Remove Contact to Array of Contacts")
        public void testRemoveMethodRemovesContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            testAddressBook.addContact(testContact);
            //Act
            testAddressBook.removeContact(testContact);
            //Assert
            assertFalse(testAddressBook.getContacts().contains(testContact));
        }
    }

    @Nested
    @DisplayName("AddressBook Search Method Test")
    class AddressBookSearchMethodTests {

        @Test
        @DisplayName("Test Search Method Return True Value")
        public void testSearchMethodReturnTrueValue() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            when(testContact.getContactName()).thenReturn("Tom");

            //Act
            testAddressBook.addContact(testContact);
            //Assert
            assertTrue(testAddressBook.searchContact("Tom"));
        }

        @Test
        @DisplayName("Test Search Method Return False Value")
        public void testSearchMethodReturnFalseValue() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            when(testContact.getContactName()).thenReturn("Tom");
            //Act
            //Assert
            assertFalse(testAddressBook.searchContact("Sarah"));
        }
    }

    @Nested
    @DisplayName("Contact Edit Method Test")
    class ContactEditMethodTest {

        @Test
        @DisplayName("Test Edit Method Find The Right Contact")
        public void testEditMethodFindTheRightContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = new Contact("Tom", "+012345678", "tom@email.com");
            testAddressBook.addContact(testContact);
            //Act

            //Assert
            assertTrue(testAddressBook.editContact(testContact.getContactId(), "Tom", "+012345678", "tom@email.com"));
        }

        @Test
        @DisplayName("Test Edit Method Cannot Find Non Existing Data")
        public void testEditMethodNoFindTheRightContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");

            testAddressBook.addContact(testContact1);
            //Act
            //Assert
            //Test not working unsure why - I cannot fix it.
            assertFalse(testAddressBook.editContact(2, "Tom", "+012345678", "tom@email.com"));
        }

        @Test
        @DisplayName("Test Edit Method Edits The Contact")
        public void testEditMethodEditsTheContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");
            testAddressBook.addContact(testContact1);

            //Act
            testAddressBook.editContact(testContact1.getContactId(), "Sarah", "+1111111111", "sarah@email.com");
            //Assert
            assertAll(
                    () -> assertEquals("Sarah", testContact1.getContactName()),
                    () -> assertEquals("+1111111111", testContact1.getPhoneNumber()),
                    () -> assertEquals("sarah@email.com", testContact1.getContactEmail())
            );

        }
    }

    @Nested
    @DisplayName("Contact Validation Method for Add Function Test")
    class ContactValidationForAddFunction {

        @Test
        @DisplayName("Test Validation Method Doesn't Allow Same Phone Number")
        public void testValidationMethodStopsToAddSameNumber() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");
            Contact testContact2 = new Contact("Sarah", "+012345678", "sarah@email.com");

            //Act
            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);
            //Assert

            assertEquals(1, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("Test Duplicate Number Method Adds the Contact ")
        public void testDuplicateNumberMethodStopsToAddCorrectContact() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");
            Contact testContact2 = new Contact("Sarah", "+012345678", "sarah@email.com");

            //Act
            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);
            //Assert
            assertEquals("+012345678", testContact1.getPhoneNumber());
            assertEquals("Tom", testContact1.getContactName());
        }

        @Test
        @DisplayName("Test Duplicate Email Method Doesn't Allow Same Email")
        public void testDuplicateEmailMethodStopsToAddSameEmail() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");
            Contact testContact2 = new Contact("Sarah", "+111111111100", "tom@email.com");

            //Act
            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);
            //Assert

            assertEquals(1, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("Test Duplicate Email Method Adds the Contact Email")
        public void testDuplicateEmailMethodStopsToAddCorrectContactEmail() {
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact1 = new Contact("Tom", "+012345678", "tom@email.com");
            Contact testContact2 = new Contact("Sarah", "+11111111100", "tom@email.com");

            //Act
            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);
            //Assert
            assertEquals("tom@email.com", testContact1.getContactEmail());
            assertEquals("Tom", testContact1.getContactName());
        }
    }

    @Nested
    @DisplayName("Display Contact In Search Function Tests")
    class displayContactInSearchFunctionTests{

        @Test
        @DisplayName("Display Contact Is Been Called In The Search Function")
        public void displayContactIsBeenCalled(){
            //The test passes by itself but not when the AddressBookTest runs. Not sure where is the problem.
            //Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact= new Contact("Tom", "+012345678", "tom@email.com");
            testAddressBook.addContact(testContact);
            Functions testFunctions = mock(Functions.class);

            //Act
            testAddressBook.searchContact("Tom");

            //Assert
            verify(testFunctions, times(1));
            Functions.displayContact(testContact);
        }
    }

}



