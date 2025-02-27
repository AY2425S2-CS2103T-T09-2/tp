package seedu.address.model.patient;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Represents a Patient in the address book.
 * Guarantees: details are present and not null, field values are validated,
 * immutable.
 */
public class Patient extends Person {

    /**
     * Every field must be present and not null.
     */
    public Patient(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
        requireAllNonNull(name, phone, email, address, tags);
    }

    /**
     * Returns true if both patients have the same name.
     * This defines a weaker notion of equality between two patients.
     */
    public boolean isSamePatient(Patient otherPatient) {
        if (otherPatient == this) {
            return true;
        }

        return super.isSamePerson(otherPatient);
    }

    /**
     * Returns true if both patients have the same identity and data fields.
     * This defines a stronger notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPatient = (Patient) other;
        return super.equals(otherPatient);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
