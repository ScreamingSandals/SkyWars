package org.screamingsandals.skywars.game.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.screamingsandals.screamingcore.ScreamingCore;
import org.screamingsandals.screamingcore.events.game.GamePreStartEvent;
import org.screamingsandals.screamingcore.events.game.GameStartEvent;
import org.screamingsandals.skywars.game.Game;

/**
 * @author ScreamingSandals team
 */
public class GameListener implements Listener {
    @EventHandler
    public void onGameWaiting() {

    }

    @EventHandler
    public void onPreGameStart(GamePreStartEvent event) {
        Game game = (Game) event.getGame();

        if (event.isCancelled()) {
            //TODO: teleport all players to the lobby with message
            return;
        }

        if (game.getGamePlayers().size() >= game.getMinimalPlayers()) {
            GameStartEvent gameStartEvent = new GameStartEvent(game);
            ScreamingCore.getPlugin().getServer().getPluginManager().callEvent(gameStartEvent);
        }
    }

    @EventHandler
    public void onGameStart(GameStartEvent event) {

    }
}
