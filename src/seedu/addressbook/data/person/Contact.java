package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * 
 */
public class Contact {
	public String value;
	public boolean isPrivate;
	
	public Contact(String contact, boolean isPrivate) throws IllegalValueException {
		this.value = contact;
		this.isPrivate = isPrivate;
	}
	
    public String toString() {
        return value;
    }


    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
	
}
