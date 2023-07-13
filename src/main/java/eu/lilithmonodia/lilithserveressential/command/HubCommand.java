package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;

import java.util.List;

/**
 * The HubCommand class extends the TeleportCommand class.
 * It represents a command that teleports the player to the hub.
 */

public class HubCommand extends TeleportCommand {
    /**
     * Constructs a new instance of the HubCommand class.
     *
     * @param plugin the LilithServerEssential plugin
     */
    public HubCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    /**
     * Retrieves the lobby world configuration from the plugin configuration.
     *
     * @return The lobby world configuration as a String.
     */
    public String getConfigWorld() {
        return plugin.getConfiguration().lobbyWorld();
    }

    /**
     * Retrieves the coordinates of the lobby from the application configuration.
     *
     * @return A List of Double values representing the lobby coordinates.
     */
    public List<Double> getConfigCoords() {
        return plugin.getConfiguration().lobbyCoords();
    }
}