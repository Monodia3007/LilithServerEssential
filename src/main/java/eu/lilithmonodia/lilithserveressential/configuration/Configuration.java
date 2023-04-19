package eu.lilithmonodia.lilithserveressential.configuration;

import org.bukkit.configuration.file.FileConfiguration;

public record Configuration(String lobbyWorld) {
    public static Configuration fromConfig(FileConfiguration config) {
        return new Configuration(config.getString("lobby-world"));
    }
}
