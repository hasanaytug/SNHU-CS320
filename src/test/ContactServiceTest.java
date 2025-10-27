/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modules.Contact;
import modules.ContactService;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // Test adding a valid contact
    @Test
    void testAddContact() {
        Contact contact = new Contact("1", "Hasan", "Aytug", "1234567890", "1234 Pecos Rd No 1423");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    // Test adding a contact with and existed ID
    @Test
    void testAddDuplicateContact() {
        Contact contact1 = new Contact("1", "Hasan", "Aytug", "1234567890", "234 Pecos Rd No 1423");
        Contact contact2 = new Contact("1", "Katie", "Aytug", "0987654321", "111 Val Vista Rd");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // Test deleting a contact
    @Test
    void testDeleteContact() {
    	Contact contact = new Contact("2", "Katie", "Aytug", "0987654321", "111 Val Vista Rd");
        service.addContact(contact);
        service.deleteContact("2");
        assertNull(service.getContact("2"));
    }

    // Test deleting a contact not exist
    @Test
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("3"));
    }

    // Test updating first name
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("4", "Magic", "Johnson", "1112223333", "555 Los Angeles Lakers");
        service.addContact(contact);
        service.updateFirstName("4", "Earvin");
        assertEquals("Earvin", service.getContact("4").getFirstName());
    }

    // Test updating last name
    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("5", "Kobe", "Bryant", "2223334444", "2002 LA 3 Pt Rd");
        service.addContact(contact);
        service.updateLastName("5", "Wilkins");
        assertEquals("Wilkins", service.getContact("5").getLastName());
    }

    // Test updating phone number
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("6", "Vince", "Carter", "3334445555", "3043 Gilbert AZ");
        service.addContact(contact);
        service.updatePhone("6", "8944356734");
        assertEquals("8944356734", service.getContact("6").getPhone());
    }

    // Test updating address
    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("7", "Omer", "Aytug", "4445556666", "1657 sk no 37 Istanbul");
        service.addContact(contact);
        service.updateAddress("7", "404 Cedar St");
        assertEquals("404 Cedar St", service.getContact("7").getAddress());
    }

    // Test updating a contact not exist
    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("12", "KLlaksdflakj"));
    }
}
