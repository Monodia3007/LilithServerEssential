package eu.lilithmonodia.lilithserveressential.configuration;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public record Configuration(String lobbyWorld, Double x, Double y, Double z) {
    public static Configuration fromConfig(FileConfiguration config) {
        return new Configuration(
                config.getString("lobby-world"),
                config.getDouble("coordinates.x"),
                config.getDouble("coordinates.y"),
                config.getDouble("coordinates.z")
        );
    }
}
