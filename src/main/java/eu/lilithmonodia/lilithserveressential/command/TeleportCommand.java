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

// Language: Java
abstract public class TeleportCommand implements CommandExecutor, TabCompleter {
    protected final LilithServerEssential plugin;

    public TeleportCommand(LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    abstract public String getConfigWorld();
    abstract public List<Double> getConfigCoords();

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

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return Collections.emptyList();
    }
}