package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
    		"Person addresses should be entered in the following format: a/BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_INDEX = 3;
    
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;    
        this.value = trimmedAddress;
        
        //split the address into block, street, unit and postal code 
        String[] addressArr = trimmedAddress.split(","); 
        if (!isValidAddress(addressArr)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.block = new Block(addressArr[BLOCK_INDEX]);
        this.street = new Street(addressArr[STREET_INDEX]);
        this.unit = new Unit(addressArr[UNIT_INDEX]);
        this.postalCode = new PostalCode(addressArr[POSTAL_INDEX]);
        
    }
    
    /**
     * Represents block number in the person's address.
     */
    public class Block {
    	private String blockNumber;
    	
    	public Block(String block) {
    		this.blockNumber = block;
    	}
    	
    	/**
    	 *@return block number
    	 */
    	public String returnBlockNumber() {
    		return blockNumber;
    	}
    	
    }
    
    /**
     * Represents street in the person's address.
     */
    public class Street {
    	private String streetName;
    	
    	public Street(String street) {
    		this.streetName = street;
    	}
    	
    	/**
    	 *@return street name
    	 */
    	public String returnStreetName() {
    		return streetName;
    	}
    }
    
    /**
     * Represents unit in the person's address.
     */
    public class Unit {
    	private String unitNumber;
    	
    	public Unit(String unit) {
    		this.unitNumber = unit;
    	}
    	
    	/**
    	 *@return unit number
    	 */
    	public String returnUnitNumber() {
    		return unitNumber;
    	}	
    }
    
    /**
     * Represents postal code in the person's address.
     */
    public class PostalCode {
        private String postalCodeNumber;
    	
    	public PostalCode(String postalCode) {
    		this.postalCodeNumber = postalCode;
    	}
    	
    	/**
    	 *@return postal code number
    	 */
    	public String returnPostalCodeNumber() {
    		return postalCodeNumber;
    	}
    	
    }
    
    
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String[] test) {
    	boolean hasAllElements, isMatchRegex;
    	int elementNumber = test.length;
    	hasAllElements = (elementNumber == 4 );
    	isMatchRegex = test.toString().matches(ADDRESS_VALIDATION_REGEX);
        return  (isMatchRegex && hasAllElements);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instance of handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
