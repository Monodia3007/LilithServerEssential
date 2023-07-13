package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;
import eu.lilithmonodia.lilithserveressential.command.abstractCommands.SetCommand;

/**
 * Represents a command to set the survival world in the LilithServerEssential plugin.
 * Extends the SetCommand class.
 */

public class SetSurvivalWorldCommand extends SetCommand {
    /**
     * Constructs a new SetSurvivalWorldCommand with the specified plugin.
     *
     * @param plugin the LilithServerEssential plugin instance
     */
    public SetSurvivalWorldCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    public String getCommandName() {
        return "Survival";
    }

    /**
     * Returns the prefix path for the command.
     *
     * @return the prefix path for the command
     */
    public String getPathPrefix() {
        return "survival";
    }
}
