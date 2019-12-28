package org.screamingsandals.skywars.game.tasks.player;

import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;
import org.screamingsandals.skywars.Main;

/**
 * @author ScreamingSandals team
 */
public class PlayerDiedTask extends BaseTask {

    public PlayerDiedTask(GameTasker gameTasker) {
        super(Main.getMain(), gameTasker);
    }

    @Override
    public void run() {
        // todo with GamePlayerDied event
    }
}
