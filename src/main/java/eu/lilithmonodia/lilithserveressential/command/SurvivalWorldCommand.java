package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Command executor and tab completer for the 'survivalworld' command in the Minecraft server.
 * <p>
 * This command allows a player to instantly teleport to the defined survival world,
 * by using the /survivalworld command in the Minecraft chat.
 */
public class SurvivalWorldCommand implements CommandExecutor, TabCompleter {
    private final LilithServerEssential plugin;

    /**
     * Instantiates a new SurvivalWorldCommand.
     *
     * @param plugin The LilithServerEssential plugin instance associated with this command.
     */
    public SurvivalWorldCommand (LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    /**
     * Executed when a player issues the 'survivalworld' command. This method checks if the issuer of
     * the command is a player and if the survival world exists. If those conditions are met, it teleports
     * the player to the coordinates specified in the survival world.
     *
     * @param sender Source of the command.
     * @param command Executed command.
     * @param label Alias of the command which was used.
     * @param args Passed command arguments.
     * @return true if the executor was able to execute the command, false if not.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (Bukkit.getWorld(plugin.getConfiguration().survivalWorld()) != null) {
                player.teleport(new Location(Bukkit.getWorld(
                        plugin.getConfiguration().survivalWorld()),
                        this.plugin.getConfiguration().survivalCoords().get(0),
                        this.plugin.getConfiguration().survivalCoords().get(1),
                        this.plugin.getConfiguration().survivalCoords().get(2)
                ));
                return true;
            } else {
                sender.sendMessage("Aucun monde nommé " + plugin.getConfiguration().survivalWorld() + " existe sur ce serveur");
                return false;
            }
        } else {
            sender.sendMessage("Cette commande n'est utilisable que par un joueur !");
            return false;
        }
    }

    /**
     * Invoked when the player presses the 'tab' key while writing a command. In this case, it does
     * not offer any suggestions.
     *
     * @param sender Source of the command.
     * @param command Executed command.
     * @param label Alias of the command which was used.
     * @param args Passed command arguments.
     * @return a List of possible completions for the command.
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return Collections.emptyList();
    }
}
