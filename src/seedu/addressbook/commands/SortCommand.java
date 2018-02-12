package seedu.addressbook.commands;

/**
 * Sort the people in address book.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all persons in the address book "
            + "by names in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been sorted!";

    public SortCommand() {}

    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
