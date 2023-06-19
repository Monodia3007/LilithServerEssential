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

public class SurvivalWorldCommand implements CommandExecutor, TabCompleter {
    private final LilithServerEssential plugin;

    public SurvivalWorldCommand (LilithServerEssential plugin) {
        this.plugin = plugin;
    }
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

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return Collections.emptyList();
    }
}
