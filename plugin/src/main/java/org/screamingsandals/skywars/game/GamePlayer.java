package org.screamingsandals.skywars.game;

import org.bukkit.entity.Player;
import org.screamingsandals.screamingcore.game.Game;
import org.screamingsandals.screamingcore.team.Team;

/**
 * @author ScreamingSandals team
 */
public class GamePlayer extends org.screamingsandals.screamingcore.player.GamePlayer {

    public GamePlayer(Player player, Team team, Game game) {
        super(player, team, game);
    }
}
