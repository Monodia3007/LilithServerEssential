package eu.lilithmonodia.lilithserveressential;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;

public class TimedTeleport {
    public static boolean timer (Player player, long cooldown) {
        Location playerStartLocation = player.getLocation();
        LocalDateTime start = LocalDateTime.now();
        player.sendMessage("Please do not move for 3 seconds");
        while (start.plusNanos(cooldown).isAfter(LocalDateTime.now())) {
            if(!playerStartLocation.equals(player.getLocation())) {
                player.sendMessage("Teleportation cancelled");
                return false;
            }
        }
        return true;
    }
}
