package org.screamingsandals.skywars.game.tasks.player;

import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;
import org.screamingsandals.screamingcore.player.GamePlayer;
import org.screamingsandals.skywars.Main;

/**
 * @author ScreamingSandals team
 */
public class PlayerRespawnTask extends BaseTask {
    private GamePlayer gamePlayer;

    public PlayerRespawnTask(GameTasker gameTasker, GamePlayer gamePlayer) {
        super(Main.getMain(), gameTasker);

        this.gamePlayer = gamePlayer;
    }
}
