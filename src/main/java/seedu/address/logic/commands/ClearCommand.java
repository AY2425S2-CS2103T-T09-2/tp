package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Klinix;
import seedu.address.model.Model;

/**
 * Clears all data in the the klinix.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Klinix has been cleared";

    /**
     * Creates a ClearCommand.
     */
    public ClearCommand() {
        super();
        super.setShowConfirmation(true);
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setKlinix(new Klinix());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
