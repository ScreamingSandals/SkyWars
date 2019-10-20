package org.screamingsandals.skywars.game.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.screamingsandals.screamingcore.events.player.GamePlayerDiedEvent;
import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.player.GamePlayer;
import org.screamingsandals.skywars.game.Game;

/**
 * @author ScreamingSandals team
 */
public class GamePlayerListener implements Listener {

    @EventHandler
    public void onPlayerDied(GamePlayerDiedEvent event) {
        Game game = (Game) event.getGame();
        GameTasker gameTasker = game.getGameTasker();

        GamePlayer gamePlayer = event.getGameVictim();
    }
}
