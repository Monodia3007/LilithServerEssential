package eu.lilithmonodia.lilithserveressential.configuration;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

public record Configuration(
        String lobbyWorld,
        String survivalWorld,
        ArrayList<Double> lobbyCoords,
        ArrayList<Double> survivalCoords, long teleportTimer
) {
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
                )),
                config.getLong("teleport-timer")
        );
    }
}
