package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ALLERGY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ILLNESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IMMUNIZATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SURGERY;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddMedicalReportCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.MedicalReport;
import seedu.address.model.person.Nric;

/**
 * Parses input arguments and creates a new AddMedicalReportCommand object
 */
public class AddMedicalReportCommandParser implements Parser<AddMedicalReportCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddMedicalReportCommand
     * and returns an AddMedicalReportCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddMedicalReportCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NRIC, PREFIX_ALLERGY, PREFIX_ILLNESS, PREFIX_SURGERY,
                        PREFIX_IMMUNIZATION);

        if (!arePrefixesPresent(argMultimap, PREFIX_NRIC)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddMedicalReportCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NRIC, PREFIX_ALLERGY, PREFIX_ILLNESS,
                PREFIX_SURGERY, PREFIX_IMMUNIZATION);

        Nric nric = ParserUtil.parseNric(argMultimap.getValue(PREFIX_NRIC).get());
        String allergy = ParserUtil.parseMedicalField(argMultimap.getValue(PREFIX_ALLERGY).orElse("None"));
        String illness = ParserUtil.parseMedicalField(argMultimap.getValue(PREFIX_ILLNESS).orElse("None"));
        String surgery = ParserUtil.parseMedicalField(argMultimap.getValue(PREFIX_SURGERY).orElse("None"));
        String immunization = ParserUtil.parseMedicalField(argMultimap.getValue(PREFIX_IMMUNIZATION).orElse("None"));

        MedicalReport medicalReport = new MedicalReport(allergy, illness, surgery, immunization);

        return new AddMedicalReportCommand(nric, medicalReport);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    @Override
    public boolean equals(Object other) {
        return other == this || other instanceof AddMedicalReportCommandParser;
    }
}
