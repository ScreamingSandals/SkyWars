package org.screamingsandals.skywars;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.screamingsandals.screamingcore.ScreamingCore;
import org.screamingsandals.screamingcore.player.GamePlayer;
import org.screamingsandals.screamingcore.player.GamePlayerManagement;
import org.screamingsandals.skywars.game.Game;
import org.screamingsandals.skywars.game.GameUtilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ScreamingSandals team
 */
public class Main extends JavaPlugin {
    private static Main main;
    private ScreamingCore screamingCore;
    private GamePlayerManagement gamePlayerManagement;

    private boolean isPaper;

    @Override
    public void onEnable() {
        main = this;
        screamingCore = new ScreamingCore(this);

        try {
            Class.forName("com.destroytokyo.paper.Title");
            isPaper = true;
        } catch (Throwable tr) {
            isPaper = false;
        }

        gamePlayerManagement = screamingCore.getGamePlayerManagement();

        File gameFile = new File(ScreamingCore.getPlugin().getDataFolder().toString(), "games");
        GameUtilities.loadGames(gameFile);
    }

    @Override
    public void onDisable() {

    }

    public static Main getMain() {
        return main;
    }

    public boolean isPaper() {
        return isPaper;
    }

    public ScreamingCore getScreamingCore() {
        return screamingCore;
    }

    public GamePlayerManagement getGamePlayerManagement() {
        return gamePlayerManagement;
    }

    public void addGame(Game game) {
        screamingCore.addGame(game);
    }

    public void removeGame(Game game) {
        screamingCore.removeGame(game);
    }

    public void leaveAllPlayersFromGame(Game game) {
        screamingCore.leaveAllPlayersFromGame(game);
    }

    public Game getGameByName(String gameName) {
        List<Game> gameList = new ArrayList<>((Collection<? extends Game>) screamingCore.getGames());
        for (Game game : gameList) {
            if (game.getGameName().equals(gameName)) {
                return game;
            }
        }
        return null;
    }

    public boolean isPlayerInAnyGame(GamePlayer gamePlayer) {
        return screamingCore.isPlayerInAnyGame(gamePlayer);
    }

    public GamePlayer getRegisteredPlayer(Player player) {
        return screamingCore.getGamePlayerManagement().getRegisteredPlayer(player);
    }
}
