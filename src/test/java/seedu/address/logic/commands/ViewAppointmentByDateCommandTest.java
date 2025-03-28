package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class ViewAppointmentByDateCommandTest {
    @Test
    public void execute_validDate_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();
        LocalDate testDate = LocalDate.of(2025, 3, 23);

        ViewAppointmentByDateCommand command = new ViewAppointmentByDateCommand(testDate);
        String expectedMessage = String.format(
                ViewAppointmentByDateCommand.MESSAGE_SUCCESS, testDate
        );

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        LocalDate testDate = LocalDate.now();
        ViewAppointmentByDateCommand command = new ViewAppointmentByDateCommand(testDate);
        assertThrows(NullPointerException.class, () -> command.execute(null));
    }

    @Test
    public void execute_noAppointmentsOnDate_showsNoAppointmentsMessage() throws CommandException {
        Model model = new ModelManager();
        LocalDate testDate = LocalDate.of(2025, 3, 23);
        ViewAppointmentByDateCommand command = new ViewAppointmentByDateCommand(testDate);

        CommandResult result = command.execute(model);
        assertEquals(
                String.format(ViewAppointmentByDateCommand.MESSAGE_SUCCESS, testDate),
                result.getFeedbackToUser()
        );
    }
}
