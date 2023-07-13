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
 * The TeleportCommand class is an abstract class that represents a teleportation command.
 * It implements the CommandExecutor and TabCompleter interfaces.
 *
 * @see CommandExecutor
 * @see TabCompleter
 */

// Language: Java
abstract public class TeleportCommand implements CommandExecutor, TabCompleter {
    /**
     * The plugin variable represents the instance of LilithServerEssential plugin.
     * It is declared as final, meaning that its reference cannot be changed once initialized.
     * This variable is protected, allowing subclasses to access it.
     */
    protected final LilithServerEssential plugin;

    /**
     * Creates a new TeleportCommand instance with the given LilithServerEssential plugin.
     *
     * @param plugin the LilithServerEssential plugin instance to associate with the command
     */
    public TeleportCommand(LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    /**
     * Retrieves the configuration world.
     *
     * @return The configuration world as a String.
     */
    abstract public String getConfigWorld();
    /**
     * Get the coordinates of the configuration.
     *
     * @return a list of double values representing the coordinates of the configuration
     */
    abstract public List<Double> getConfigCoords();

    /**
     * Executes the command when triggered by a player.
     *
     * @param sender  The sender of the command.
     * @param command The command being executed.
     * @param label   The label used to trigger the command.
     * @param args    The arguments provided with the command.
     * @return True if the command was executed successfully, false otherwise.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (Bukkit.getWorld(getConfigWorld()) != null) {
                player.teleport(new Location(
                        Bukkit.getWorld(getConfigWorld()),
                        getConfigCoords().get(0),
                        getConfigCoords().get(1),
                        getConfigCoords().get(2)
                ));
                return true;
            } else {
                sender.sendMessage("Aucun monde nommé " + getConfigWorld() + " existe sur ce serveur");
                return false;
            }
        } else {
            sender.sendMessage("Cette commande n'est utilisable que par un joueur !");
            return false;
        }
    }

    /**
     * This method is called when a tab completion is requested for a command.
     *
     * @param sender the command sender that requested the tab completion
     * @param command the command object being tab completed
     * @param label the label of the command being tab completed
     * @param args the arguments provided for the command being tab completed
     * @return a list of possible tab completions for the command
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return Collections.emptyList();
    }
}