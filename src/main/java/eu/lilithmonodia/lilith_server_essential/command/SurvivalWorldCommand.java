package eu.lilithmonodia.lilith_server_essential.command;

import eu.lilithmonodia.lilith_server_essential.LilithServerEssential;
import eu.lilithmonodia.lilith_server_essential.command.abstract_commands.TeleportCommand;

import java.util.List;

/**
 * SurvivalWorldCommand is a class that extends the TeleportCommand class
 * and represents a command related to the survival world.
 */

public class SurvivalWorldCommand extends TeleportCommand {
    /**
     * Creates a new instance of the SurvivalWorldCommand class.
     *
     * @param plugin The LilithServerEssential plugin instance.
     */
    public SurvivalWorldCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    /**
     * Retrieves the configuration world set for the plugin.
     *
     * @return The name of the survival world specified in the configuration.
     */
    public String getConfigWorld() {
        return plugin.getConfiguration().survivalWorld();
    }

    /**
     * Retrieves the configuration coordinates for the plugin.
     *
     * @return a {@link List} of {@link Double} representing the configuration coordinates
     */
    public List<Double> getConfigCoords() {
        return plugin.getConfiguration().survivalCoords();
    }
}