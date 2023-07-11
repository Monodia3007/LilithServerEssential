package eu.lilithmonodia.lilithserveressential.configuration;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A record class encapsulating the configuration data relevant for a game world in the Minecraft server.
 * <p>
 * The Configuration record holds four pieces of information:
 * <ul>
 *     <li>lobbyWorld: The name of the lobby world in the Minecraft server.</li>
 *     <li>survivalWorld: The name of the survival world in the Minecraft server.</li>
 *     <li>lobbyCoords: The x, y, and z coordinates of the lobby world.</li>
 *     <li>survivalCoords: The x, y, and z coordinates of the survival world.</li>
 * </ul>
 */
public record Configuration(String lobbyWorld, String survivalWorld, ArrayList<Double> lobbyCoords,
                            ArrayList<Double> survivalCoords) {
    /**
     * This method converts the configurations received from a FileConfiguration object into a Configuration record.
     *
     * @param config The FileConfiguration object from which we get the configuration details.
     * @return Configuration object with values extracted from the passed FileConfiguration object.
     */
    public static Configuration fromConfig(FileConfiguration config) {
        return new Configuration(
                config.getString("lobby-world"),
                config.getString("survival-world"),
                new ArrayList<>(Arrays.asList(
                        config.getDouble("coordinates.lobby.x"),
                        config.getDouble("coordinates.lobby.y"),
                        config.getDouble("coordinates.lobby.z")
                )),
                new ArrayList<>(Arrays.asList(
                        config.getDouble("coordinates.survival.x"),
                        config.getDouble("coordinates.survival.y"),
                        config.getDouble("coordinates.survival.z")
                ))
        );
    }
}