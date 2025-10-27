/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    	//Validation
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID can't be empty and must be maximum 10 characters");
        }                                                  
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name can't be empty and must be maximum 10 characters");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name can't be empty and must be maximum 10 characters");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number can't be empty and must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address can't be empty and must be maximum 30 characters.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
    	//Validation
        if (firstName == null || firstName.length() > 10) {
        	throw new IllegalArgumentException("First name can't be empty and must be maximum 10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
    	//Validation
        if (lastName == null || lastName.length() > 10) {
        	throw new IllegalArgumentException("Last name can't be empty and must be maximum 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
    	//Validation
        if (phone == null || !phone.matches("\\d{10}")) {
        	throw new IllegalArgumentException("Phone number can't be empty and must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
    	//Validation
        if (address == null || address.length() > 30) {
        	throw new IllegalArgumentException("Address can't be empty and must be maximum 30 characters");
        }
        this.address = address;
    }
}
