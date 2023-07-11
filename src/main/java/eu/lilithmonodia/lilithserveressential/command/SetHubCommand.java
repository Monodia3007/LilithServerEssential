package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;
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
 * Command executor and tab completer for the 'sethub' command in the Minecraft server.
 * <p>
 * This command allows an administrator to set the location of the hub in the Minecraft server
 * by using the /sethub command in the Minecraft chat followed by the world name and x, y, z coordinates.
 */
public class SetHubCommand implements CommandExecutor, TabCompleter {
    private final LilithServerEssential plugin;

    /**
     * Instantiates a new SetHubCommand.
     *
     * @param plugin The LilithServerEssential plugin instance associated with this command.
     */
    public SetHubCommand(LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    /**
     * Executed when a player issues the 'sethub' command. This method checks if the usage is correct and,
     * if it is, sets the new hub parameters in the plugin's config before reloading the plugin.
     *
     * @param sender  Source of the command.
     * @param command Executed command.
     * @param label   Alias of the command which was used.
     * @param args    Passed command arguments - expected to be name of the world and x, y, z coordinates for the hub.
     * @return true if the executor was able to set the hub, false if not.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 4) {
            plugin.getConfig().set("lobby-world", args[0]);
            plugin.getConfig().set("coordinates.lobby.x", Double.valueOf(args[1]));
            plugin.getConfig().set("coordinates.lobby.y", Double.valueOf(args[2]));
            plugin.getConfig().set("coordinates.lobby.z", Double.valueOf(args[3]));
        } else {
            sender.sendMessage("Please enter a valid argument");
            return false;
        }
        plugin.saveConfig();
        plugin.reload();
        sender.sendMessage("Hub world changed");
        return true;
    }

    /**
     * Invoked when the player presses the 'tab' key while writing a command.
     * Displays available worlds and fills in the player's current coordinates as suggestions.
     *
     * @param sender  Source of the command.
     * @param command Executed command.
     * @param label   Alias of the command which was used.
     * @param args    Passed command arguments.
     * @return a List of possible completions for the command, based on the current argument index.
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
            }
            return Collections.emptyList();
        } else {
            List<String> worlds = new ArrayList<>();
            for (World world : Bukkit.getWorlds()) {
                worlds.add(world.getName());
            }
            return worlds;
        }
    }
}
