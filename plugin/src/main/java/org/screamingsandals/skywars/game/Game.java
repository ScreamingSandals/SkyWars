package org.screamingsandals.skywars.game;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.screamingsandals.easydebug.Debug;
import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.player.GamePlayer;
import org.screamingsandals.screamingcore.utilities.VariousUtilities;
import org.screamingsandals.skywars.game.tasks.game.GameWaitingTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ScreamingSandals team
 */
public class Game extends org.screamingsandals.screamingcore.game.Game implements org.screamingsandals.skywars.api.game.Game {

    public Game() {
    }

    public void start() {
        getGameTasker().registerTask(new GameWaitingTask(getGameTasker()));
    }

    @Override
    public void saveToFile() {
        FileConfiguration fileConfiguration = new YamlConfiguration();

        fileConfiguration.set("game-name", getGameName());
        fileConfiguration.set("display-name", getDisplayName());
        fileConfiguration.set("game-time", getGameTime());
        fileConfiguration.set("minimal-players", getMinimalPlayers());
        fileConfiguration.set("game-world", getGameWorld());
        fileConfiguration.set("game-location1", VariousUtilities.serializeLocation(getGameLocation1()));
        fileConfiguration.set("game-location2", VariousUtilities.serializeLocation(getGameLocation2()));
        fileConfiguration.set("lobby-location", VariousUtilities.serializeLocation(getLobbyLocation()));
        fileConfiguration.set("spectator-location", VariousUtilities.serializeLocation(getSpectatorLocation()));

        if (!getGameTeams().isEmpty()) {
            List<Team> teamList = new ArrayList<>((Collection<? extends Team>) getGameTeams());

            for (Team team : teamList) {
                String teamName = team.getTeamName();

                fileConfiguration.set("teams." + teamName + ".color", team.getTeamColor().name());
                fileConfiguration.set("teams." + teamName + ".maximal-players", team.getMaximalPlayers());
                fileConfiguration.set("teams." + teamName + ".spawn-location", VariousUtilities.serializeLocation(team.getTeamSpawn()));
            }
        }
    }

    @Override
    public void joinToGame(GamePlayer gamePlayer) {
        super.joinToGame(gamePlayer);
    }

}
