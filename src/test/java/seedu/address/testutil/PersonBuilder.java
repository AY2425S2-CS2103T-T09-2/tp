package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.appointment.AppointmentList;
import seedu.address.model.person.Address;
import seedu.address.model.person.BirthDate;
import seedu.address.model.person.Email;
import seedu.address.model.person.MedicalReport;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nric;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_NRIC = "T1234567A";
    public static final String DEFAULT_BIRTHDATE = "01-01-1999";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Nric nric;
    private BirthDate birthDate;
    private Address address;
    private Set<Tag> tags;
    private MedicalReport medicalReport;
    private AppointmentList appointmentList;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        nric = new Nric(DEFAULT_NRIC);
        birthDate = new BirthDate(DEFAULT_BIRTHDATE);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        medicalReport = new MedicalReport("None", "None", "None", "None");
        appointmentList = new AppointmentList();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        nric = personToCopy.getNric();
        birthDate = personToCopy.getBirthDate();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        medicalReport = personToCopy.getMedicalReport();
        appointmentList = personToCopy.getAppointmentList();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Nric} of the {@code Person} that we are building.
     */
    public PersonBuilder withNric(String nric) {
        this.nric = new Nric(nric);
        return this;
    }

    /**
     * Sets the {@code BirthDate} of the {@code Person} that we are building.
     */
    public PersonBuilder withBirthDate(String birthDate) {
        this.birthDate = new BirthDate(birthDate);
        return this;
    }

    /**
     * Sets the {@code MedicalReport} of the {@code Person} that we are building.
     */
    public PersonBuilder withMedicalReport(MedicalReport medicalReport) {
        this.medicalReport = medicalReport;
        return this;
    }

    /**
     * Sets the {@code AppointmentList} of the {@code Person} that we are building.
     */
    public PersonBuilder withAppointmentList(AppointmentList appointmentList) {
        this.appointmentList = appointmentList;
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, nric, birthDate, address, tags, medicalReport, appointmentList);
    }

}
