package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses is in the format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    public final String value;
    private boolean isPrivate;

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressComponents = trimmedAddress.split(", ", 4);
        this.block = new Block(addressComponents[0]);
        this.street = new Street(addressComponents[1]);
        this.unit = new Unit(addressComponents[2]);
        this.postalCode = new PostalCode(addressComponents[3]);
        this.value = this.block.toString() + ", " + this.street.toString() + ", "
                     + this.unit.toString() + ", " + this.postalCode.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
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

class Block {
    private String block;

    public Block(String block) {
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return block;
    }
}

class Street {
    private String street;

    public Street(String street) {
        this.street = street;
    }

    @Override
    public Street getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return street;
    }
}

class Unit {
    private String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return unit;
    }
}

class PostalCode {
    private String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public PostalCode getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return postalCode;
    }
}