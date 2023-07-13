package eu.lilithmonodia.lilithserveressential.command;

import eu.lilithmonodia.lilithserveressential.LilithServerEssential;

import java.util.List;

public class SurvivalWorldCommand extends TeleportCommand {
    public SurvivalWorldCommand(LilithServerEssential plugin) {
        super(plugin);
    }

    public String getConfigWorld() {
        return plugin.getConfiguration().survivalWorld();
    }

    public List<Double> getConfigCoords() {
        return plugin.getConfiguration().survivalCoords();
    }
}