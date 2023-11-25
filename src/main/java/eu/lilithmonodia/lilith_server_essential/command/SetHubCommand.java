package eu.lilithmonodia.lilith_server_essential.command;

import eu.lilithmonodia.lilith_server_essential.LilithServerEssential;
import eu.lilithmonodia.lilith_server_essential.command.abstract_commands.SetCommand;

/**
 * This class represents a command to set the hub location in a server plugin.
 * It extends the SetCommand class.
 */

public class SetHubCommand extends SetCommand {
    /**
     * Initializes a new instance of the SetHubCommand class.
     *
     * @param plugin the LilithServerEssential plugin instance.
     */
    public SetHubCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    /**
     * Retrieves the name of the command.
     *
     * @return The name of the command as a {@code String}.
     */
    public String getCommandName() {
        return "Hub";
    }

    /**
     * Retrieves the path prefix for the current instance.
     *
     * @return The path prefix as a string.
     */
    public String getPathPrefix() {
        return "lobby";
    }
}