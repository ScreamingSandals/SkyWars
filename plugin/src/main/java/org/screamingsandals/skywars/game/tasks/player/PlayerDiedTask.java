package org.screamingsandals.skywars.game.tasks.player;

import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;

/**
 * @author ScreamingSandals team
 */
public class PlayerDiedTask extends BaseTask {

    public PlayerDiedTask(GameTasker gameTasker) {
        super(gameTasker);
    }

    @Override
    public void run() {
        // todo with GamePlayerDied event
    }
}
