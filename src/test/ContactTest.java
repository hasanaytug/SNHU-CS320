/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import modules.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	// Test valid contact
    @Test
    void testContactCreation() {
        Contact contact = new Contact("1234567890", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Hasan", contact.getFirstName());
        assertEquals("Aytug", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("1423 E Pecos Rd", contact.getAddress());
    }

    // Test invalid contact ID
    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd"));
    }

    // Test invalid first name
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Aytug", "1234567890", "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasannnnnnnnnnnnnnnnnn", "Aytug", "1234567890", "1423 E Pecos Rd"));
    }

    // Test invalid last name
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", null, "1234567890", "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytugggggggggggggg", "1234567890", "1423 E Pecos Rd"));
    }

    // Test invalid phone number
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", null, "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", "12345", "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", "12345678901", "1423 E Pecos Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", "abcde12345", "1423 E Pecos Rd"));
    }

    // Test invalid address
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd Long Long Long Address, kaljsdlf alskdjad aljlaskdja alsjdalsjd alksjdlad asldk"));
    }
    
 // Test valid and invalid first name setter
    @Test
    void testFirstNameSetter() {
        Contact contact = new Contact("12345", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd");
        contact.setFirstName("Omer");
        assertEquals("Omer", contact.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Hasannnnnnnnn"));
    }

    // Test valid and invalid last name setter
    @Test
    void testLastNameSetter() {
        Contact contact = new Contact("12345", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd");
        contact.setLastName("Dali");
        assertEquals("Dali", contact.getLastName());

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Aytugggggggggg"));
    }

    // Test valid and invalid phone setter
    @Test
    void testPhoneSetter() {
        Contact contact = new Contact("12345", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    // Test valid and invalid address setter
    @Test
    void testAddressSetter() {
        Contact contact = new Contact("12345", "Hasan", "Aytug", "1234567890", "1423 E Pecos Rd");
        contact.setAddress("123 asdfa asdfasdf");
        assertEquals("123 asdfa asdfasdf", contact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("123 asldkfjalj asldkfjalsjdflasj alskdjflkasdglhasl;jga asldkjflasjdflaisjdf alskdjflajsdfl;kajdf oigjiajlsi;djgl;aj;sdg"));
    }

}

