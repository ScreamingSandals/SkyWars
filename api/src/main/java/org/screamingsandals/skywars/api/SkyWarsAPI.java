package org.screamingsandals.skywars.api;

import org.bukkit.Bukkit;

/**
 * @author ScreamingSandals team
 */
public interface SkyWarsAPI {


    /**
     * @return SkyWars instance
     */
    static SkyWarsAPI getInstance() {
        return Bukkit.getServicesManager().getRegistration(SkyWarsAPI.class).getProvider();
    }
}
