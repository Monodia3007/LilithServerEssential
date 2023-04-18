package eu.lilithmonodia.lilithserveressential.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SurvivalSpawnCommand implements CommandExecutor, TabCompleter {
    public SurvivalSpawnCommand() {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            sender.sendMessage("Cette commande n'est utilisable que par un joueur !");
            Bukkit.dispatchCommand(sender, "/execute in minecraft:overworld run tp @s 14 254 31");
            return true;
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
