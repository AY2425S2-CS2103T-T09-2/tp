package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCTOR_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FROM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TO;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Nric;
import seedu.address.model.person.Person;

/**
 * Adds an appointment to a person by NRIC.
 */
public class AddAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "addappt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds an appointment to a person identified by NRIC.\n"
            + "Parameters: \n"
            + PREFIX_NRIC + "<NRIC> "
            + PREFIX_DOCTOR_NRIC + "<doctorNRIC> "
            + PREFIX_APPOINTMENT_DESCRIPTION + "<appointmentType> "
            + PREFIX_FROM + "<date> "
            + PREFIX_TO + "<date> \n"
            + "Date is of the following format: dd-MM-yyyy HH:mm \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NRIC + "S1234567A "
            + PREFIX_DOCTOR_NRIC + "S9876543A "
            + PREFIX_APPOINTMENT_DESCRIPTION + "Check-Up "
            + PREFIX_FROM + "22-02-2025 11:00 "
            + PREFIX_TO + "22-02-2025 11:30\n";

    public static final String MESSAGE_SUCCESS = "Appointment successfully added to %s";
    public static final String MESSAGE_PERSON_NOT_FOUND = "Person with NRIC %s not found";

    private final Nric nric;
    private final Appointment appointment;

    /**
     * Creates an AddAppointmentCommand to add the specified {@code Appointment}
     * to the person identified by {@code Nric}.
     */
    public AddAppointmentCommand(Nric nric, Appointment appointment) {
        requireNonNull(nric);
        requireNonNull(appointment);
        this.nric = nric;
        this.appointment = appointment;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Person person = model.findPersonByNric(nric);
        if (person == null) {
            throw new CommandException(String.format(MESSAGE_PERSON_NOT_FOUND, nric));
        }

        model.addAppointment(person, appointment);
        return new CommandResult(String.format(MESSAGE_SUCCESS, nric));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof AddAppointmentCommand
                && nric.equals(((AddAppointmentCommand) other).nric)
                && appointment.equals(((AddAppointmentCommand) other).appointment));
    }
}

