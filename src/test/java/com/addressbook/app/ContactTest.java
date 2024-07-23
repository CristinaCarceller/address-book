package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Nested
    @DisplayName("Contact Constructor Test")
    class ContactConstructorTest {


        @Test
        @DisplayName("Test Constructor Return Expected Value")
        public void testConstructorReturnsExpectedValue() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = "+1123456789";
            String testEmail = "tom@email.com";
            //Act
            Contact testContact = new Contact (testName, testPhoneNumber, testEmail);
            //Assert
            assertAll(
                    () -> assertEquals(testName, testContact.getContactName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getContactEmail())

            );

        }
        @Test
        @DisplayName("Test Constructor ID Return Expected Value")
        public void testConstructorIDReturnsExpectedValue() {
                //Arrange
                Contact testContact1 = new Contact("Tom", "+112345678", "tom@email.com");
                Contact testContact2 = new Contact("Sarah", "+1330000000", "sarah@email.com");
                //Act
                //Assert
                assertEquals(15, testContact1.getContactId());
                assertEquals(16, testContact2.getContactId());
            }
    }
    @Nested
    @DisplayName("Contact Set Test")
    class ContactSetTest {
        @Test
        @DisplayName("Test Set Name Return Expected Values")
        public void testSetNameReturnExpectedValues() {
            //Arrange
            Contact testContact = new Contact("Tom","+112345678","tom@email.com");

            //Act
            testContact.setContactName("Sarah");
            //Assert
            assertTrue(testContact.getContactName().contains("Sarah"));

        }
        @Test
        @DisplayName("Test Set Phone Number Return Expected Values")
        public void testSetPhoneReturnExpectedValues() {
            //Arrange
            Contact testContact = new Contact("Tom","+012345678","tom@email.com");

            //Act
            testContact.setPhoneNumber("+015555555");
            //Assert
            assertTrue(testContact.getPhoneNumber().contains("+015555555"));

        }
        @Test
        @DisplayName("Test Set Email Return Expected Values")
        public void testSetEmailReturnExpectedValues() {
            //Arrange
            Contact testContact = new Contact("Tom","+012345678","tom@email.com");

            //Act
            testContact.setContactEmail("sarah@mail.com");
            //Assert
            assertTrue(testContact.getContactEmail().contains("sarah@mail.com"));

        }

    }
    @Nested
    @DisplayName("Contact Validation Tests")
    class ContactValidationTests {


        @Test
        @DisplayName("Test Name Null Value Cannot Be Added")
        public void testNameValueNullCannotBeAdded() {
            //Arrange
            String testName = null;
            String testPhoneNumber = "+1123456789";
            String testEmail = "tom@email.com";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Name Empty Value Cannot Be Added")
        public void testNameEmptyValueCannotBeAdded() {
            //Arrange
            String testName = "";
            String testPhoneNumber = "+1123456789";
            String testEmail = "tom@email.com";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Phone Empty Value Cannot Be Added")
        public void testPhoneEmptyValueCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = "";
            String testEmail = "tom@email.com";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Phone Null Value Cannot Be Added")
        public void testPhoneValueNullCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = null;
            String testEmail = "tom@email.com";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Phone Format")
        public void testWrongPhoneFormatCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = "02345";
            String testPhoneNumber1="+123456789";
            String testEmail = "tom@email.com";
            //Act
            Contact testContact1= new Contact(testName,testPhoneNumber1,testEmail);
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );
            assertEquals(testPhoneNumber1,testContact1.getPhoneNumber());
        }
        @Test
        @DisplayName("Test Email Empty Value Cannot Be Added")
        public void testEmailEmptyValueCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = "+123456789";
            String testEmail = "";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Email Null Value Cannot Be Added")
        public void testEmailValueNullCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber = "+123456789";
            String testEmail = null;
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail) );

        }
        @Test
        @DisplayName("Test Email Format")
        public void testWrongEmailFormatCannotBeAdded() {
            //Arrange
            String testName = "Tom";
            String testPhoneNumber="+123456789";
            String testEmail1 = "tom@email.com";
            String testEmail2 = "tom@email";
            String testEmail3 = "tomemail.com";
            //Act
            Contact testContact1= new Contact(testName,testPhoneNumber,testEmail1);
            //Assert
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail2) );
            assertThrows(IllegalArgumentException.class,()-> new Contact (testName, testPhoneNumber, testEmail3) );
            assertEquals(testEmail1,testContact1.getContactEmail());
        }
    }
}
