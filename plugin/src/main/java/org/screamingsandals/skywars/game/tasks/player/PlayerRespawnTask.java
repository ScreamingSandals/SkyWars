package org.screamingsandals.skywars.game.tasks.player;

import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;
import org.screamingsandals.screamingcore.player.GamePlayer;

/**
 * @author ScreamingSandals team
 */
public class PlayerRespawnTask extends BaseTask {
    private GamePlayer gamePlayer;

    public PlayerRespawnTask(GameTasker gameTasker, GamePlayer gamePlayer) {
        super(gameTasker);

        this.gamePlayer = gamePlayer;
    }
}
