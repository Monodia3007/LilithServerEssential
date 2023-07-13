package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;

import java.util.List;

public class HubCommand extends TeleportCommand {
    public HubCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    public String getConfigWorld() {
        return plugin.getConfiguration().lobbyWorld();
    }

    public List<Double> getConfigCoords() {
        return plugin.getConfiguration().lobbyCoords();
    }
}