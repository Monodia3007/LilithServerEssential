package eu.lilithmonodia.lilithserveressential;

import eu.lilithmonodia.lilithserveressential.command.HubCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

public final class LilithServerEssential extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommand("hub", new HubCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private <T extends CommandExecutor & TabCompleter> void registerCommand(String name, T command) {
        PluginCommand pluginCommand = getCommand(name);
        pluginCommand.setExecutor(command);
        pluginCommand.setTabCompleter(command);
    }
}
