package eu.lilithmonodia.lilith_server_essential.command.abstract_commands;

import eu.lilithmonodia.lilith_server_essential.LilithServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The SetCommand class is an abstract class that implements the CommandExecutor and TabCompleter interfaces.
 * It provides a base implementation for setting the world and coordinates of a specific location in the configuration file.
 *
 * @see CommandExecutor
 * @see TabCompleter
 */

public abstract class SetCommand implements CommandExecutor, TabCompleter {
    public static final String COORDINATES = "coordinates.";
    /**
     * Represents a protected final variable 'plugin' of type LilithServerEssential.
     * This variable is used in the code to reference the instance of the plugin.
     */
    protected final LilithServerEssential plugin;

    /**
     * Initializes a new instance of the SetCommand class.
     *
     * @param plugin the LilithServerEssential plugin
     */
    protected SetCommand(LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    /**
     * Gets the command name associated with this command.
     *
     * @return the command name
     */
    public abstract String getCommandName();

    /**
     * Gets the path prefix associated with this command.
     *
     * @return the path prefix
     */
    public abstract String getPathPrefix();

    /**
     * Executes the onCommand method for the given command.
     *
     * @param sender  the command sender
     * @param command the command being executed
     * @param label   the command label
     * @param args    the command arguments
     *
     * @return true if the command executed successfully, false otherwise
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 4) {
            plugin.getConfig().set(getPathPrefix() + "-world", args[0]);
            plugin.getConfig().set(COORDINATES + getPathPrefix() + ".x", Double.valueOf(args[1]));
            plugin.getConfig().set(COORDINATES + getPathPrefix() + ".y", Double.valueOf(args[2]));
            plugin.getConfig().set(COORDINATES + getPathPrefix() + ".z", Double.valueOf(args[3]));
        } else {
            sender.sendMessage("Please enter a valid argument");
            return false;
        }
        plugin.saveConfig();
        plugin.reload();
        sender.sendMessage(getCommandName() + " world changed");
        return true;
    }

    /**
     * Provides tab completion options for the onCommand method.
     *
     * @param sender  the command sender
     * @param command the command being executed
     * @param label   the command label
     * @param args    the command arguments
     *
     * @return a list of tab completion options for the command arguments
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            switch (args.length) {
                case 1 -> {
                    List<String> worlds = new ArrayList<>();
                    for (World world : Bukkit.getWorlds()) {
                        worlds.add(world.getName());
                    }
                    return worlds;
                }
                case 2 -> {
                    return Collections.singletonList(String.valueOf(player.getLocation().x()));
                }
                case 3 -> {
                    return Collections.singletonList(String.valueOf(player.getLocation().y()));
                }
                case 4 -> {
                    return Collections.singletonList(String.valueOf(player.getLocation().z()));
                }
                default -> {
                    return Collections.emptyList();
                }
            }
        } else {
            List<String> worlds = new ArrayList<>();
            for (World world : Bukkit.getWorlds()) {
                worlds.add(world.getName());
            }
            return worlds;
        }
    }
}
