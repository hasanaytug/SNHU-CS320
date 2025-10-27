/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contactList = new HashMap<>();

    public void addContact(Contact contact) {
    	//Validation
        if (contact == null || contactList.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid contact or contact ID exists.");
        }
        //Add contact to the list
        contactList.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
    	//Validation
        if (contactId == null || !contactList.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found.");
        }
        //Remove contact from the list
        contactList.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contactList.get(contactId);
        //Validation
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        //Update firstName
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact contact = contactList.get(contactId);
        //Validation
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        //Update lastName
        contact.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact contact = contactList.get(contactId);
        //Validation
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        //Update phone
        contact.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact contact = contactList.get(contactId);
        //Validation
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        //Update Address
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contactList.get(contactId);
    }
}
