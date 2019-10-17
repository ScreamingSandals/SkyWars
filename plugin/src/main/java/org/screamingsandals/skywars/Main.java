package org.screamingsandals.skywars;

import org.bukkit.plugin.java.JavaPlugin;
import org.screamingsandals.screamingcore.ScreamingCore;

/**
 * @author ScreamingSandals team
 */
public class Main extends JavaPlugin {
    private static Main main;
    private ScreamingCore screamingCore;

    @Override
    public void onEnable() {
        main = this;
        screamingCore = new ScreamingCore(this);
    }

    @Override
    public void onDisable() {

    }

    public static Main getMain() {
        return main;
    }

    public ScreamingCore getScreamingCore() {
        return screamingCore;
    }
}
