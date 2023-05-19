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

public class SetSurvivalWorldCommand implements CommandExecutor, TabCompleter {
    private LilithServerEssential plugin;

    public SetSurvivalWorldCommand(LilithServerEssential plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 4) {
            plugin.getConfig().set("lobby-world", args[0]);
            plugin.getConfig().set("coordinates.survival.x", Double.valueOf(args[1]));
            plugin.getConfig().set("coordinates.survival.y", Double.valueOf(args[2]));
            plugin.getConfig().set("coordinates.survival.z", Double.valueOf(args[3]));
        } else {
            sender.sendMessage("Please enter a valid argument");
            return false;
        }
        plugin.saveConfig();
        plugin.reload();
        return true;
    }

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
            return null;
        } else {
            List<String> worlds = new ArrayList<>();
            for (World world:Bukkit.getWorlds()) {
                worlds.add(world.getName());
            }
            return worlds;
        }
    }
}
