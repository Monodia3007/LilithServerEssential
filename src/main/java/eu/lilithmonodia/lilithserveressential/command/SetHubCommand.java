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
import java.util.List;

public class SetHubCommand implements CommandExecutor, TabCompleter {
    LilithServerEssential plugin;

    public SetHubCommand (LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 1) {
            plugin.getConfig().set("lobby-world", args[1]);
        } else if (sender instanceof Player player) {
            plugin.getConfig().set("lobby-world", player.getWorld().getName());
        } else {
            sender.sendMessage("Please enter a valid argument");
            return false;
        }
        sender.sendMessage(""+args.length);
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        sender.sendMessage(plugin.getConfiguration().lobbyWorld());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> worlds = new ArrayList<>();
        for (World world:Bukkit.getWorlds()) {
            worlds.add(world.getName());
        }
        return worlds;
    }
}
