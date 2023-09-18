package eu.lilithmonodia.lilithserveressential;

import eu.lilithmonodia.lilithserveressential.command.HubCommand;
import eu.lilithmonodia.lilithserveressential.command.SetHubCommand;
import eu.lilithmonodia.lilithserveressential.command.SetSurvivalWorldCommand;
import eu.lilithmonodia.lilithserveressential.command.SurvivalWorldCommand;
import eu.lilithmonodia.lilithserveressential.configuration.Configuration;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Main class for the LilithServerEssential plugin.
 * <p>
 * This plugin allows configuration and use of a lobby world and a survival world in a Minecraft server.
 * The plugin features commands for setting and teleporting to these worlds.
 */
public final class LilithServerEssential extends JavaPlugin {
    Configuration configuration;

    /**
     * Called on plugin startup. Initializes and saves default config,
     * then registers command executors and tab completers for plugin's commands.
     */
    @Override
    public void onEnable() {

        // Get the server's version
        String version = this.getServer().getBukkitVersion().split("-")[0];

        // Define the minimum and maximum version numbers
        double minVersion = 1.19;
        double maxVersion = 1.20;

        // Check if the server is running a supported version
        try {
            double runningVersion = Double.parseDouble(version);

            if (runningVersion < minVersion || runningVersion > maxVersion) {
                this.getLogger().severe("This server is running version " + version +
                        ", but this plugin only supports versions " + minVersion + " to " + maxVersion + ".");
                this.getServer().getPluginManager().disablePlugin(this);
                return;
            }

        } catch (NumberFormatException ex) {
            Logger logger = this.getLogger();
            logger.severe("Failed to get the server version! Error: " + ex.getMessage());
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Plugin startup logic
        this.saveDefaultConfig();
        configuration = Configuration.fromConfig(getConfig());

        registerCommand("hub", new HubCommand(this));
        registerCommand("sethub", new SetHubCommand(this));
        registerCommand("survivalworld", new SurvivalWorldCommand(this));
        registerCommand("setsurvivalworld", new SetSurvivalWorldCommand(this));
    }
    /**
     * Reloads the configuration for this plugin.
     */
    public void reload() {
        reloadConfig();
        configuration = Configuration.fromConfig(getConfig());
    }

    /**
     * Returns the current Configuration instance held by the plugin.
     *
     * @return Configuration instance containing world and coordinates data.
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Called on plugin shutdown.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Register a command handler that is both a CommandExecutor and a TabCompleter.
     *
     * @param name    The name of the command to be registered
     * @param command The command handler, which is both a CommandExecutor and a TabCompleter.
     */
    private <T extends CommandExecutor & TabCompleter> void registerCommand(String name, T command) {
        PluginCommand pluginCommand = getCommand(name);
        pluginCommand.setExecutor(command);
        pluginCommand.setTabCompleter(command);
    }
}
