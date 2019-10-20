package org.screamingsandals.skywars.game;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.screamingsandals.easydebug.Debug;
import org.screamingsandals.screamingcore.ScreamingCore;
import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.utilities.VariousUtilities;

import java.io.File;
import java.io.IOException;

/**
 * @author ScreamingSandals team
 */
public class GameUtilities {
    public static void loadGames(File file) {
        if (file.exists()) {
            File[] listOfFiles = file.listFiles();

            if (listOfFiles == null) {
                Debug.info("No games found!");
                return;
            }

            if (listOfFiles.length > 0) {
                for (File listOfFile : listOfFiles) {
                    if (listOfFile.isFile()) {
                        Game game = loadGame(listOfFile);
                        if (game != null) {
                            ScreamingCore.getScreamingCore().addGame(game);
                        }
                    }
                }
            }
        }
    }

    public static Game loadGame(File file) {
        FileConfiguration fileConfiguration = new YamlConfiguration();

        if (!file.exists()) {
            return null;
        }

        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }

        Game game = new Game();
        game.setGameName(fileConfiguration.getString("game-name"));
        game.setDisplayName(fileConfiguration.getString("display-name"));
        game.setGameTime(fileConfiguration.getInt("game-time"));
        game.setMinimalPlayers(fileConfiguration.getInt("minimal-players", 2));

        String worldName = fileConfiguration.getString("game-world");
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            Debug.warn("Arena " + worldName + " can't be loaded, because world " + worldName + " is missing!");
            return null;
        }

        game.setGameWorld(world);
        game.setGameLocation1(VariousUtilities.deserializeLocation(fileConfiguration.getString("game-location1")));
        game.setGameLocation2(VariousUtilities.deserializeLocation(fileConfiguration.getString("game-location2")));
        game.setLobbyLocation(VariousUtilities.deserializeLocation(fileConfiguration.getString("lobby-location")));
        game.setSpectatorLocation(VariousUtilities.deserializeLocation(fileConfiguration.getString("spectator-location")));

        game.setGameTasker(new GameTasker(game));

        return game;
    }
}
