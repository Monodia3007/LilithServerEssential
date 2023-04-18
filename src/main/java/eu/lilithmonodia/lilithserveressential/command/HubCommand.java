package eu.lilithmonodia.lilithserveressential.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HubCommand implements CommandExecutor, TabCompleter {

    public HubCommand () {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            World lobby = null;
            for (World world:Bukkit.getWorlds()) {
                if (world.getName().equals("lobby")) lobby = world;
            }
            if (lobby != null) {
                player.teleport(lobby.getSpawnLocation());
                return true;
            } else {
                sender.sendMessage("There is no world named lobby on the server");
                return false;
            }
        } else {
            sender.sendMessage("Cette commande n'est utilisable que par un joueur !");
            return false;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }
}
