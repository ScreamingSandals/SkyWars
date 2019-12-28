package org.screamingsandals.skywars.game.tasks.game;

import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;
import org.screamingsandals.skywars.Main;

/**
 * @author ScreamingSandals team
 */
public class GameReadyTask extends BaseTask {
    public GameReadyTask(GameTasker gameTasker) {
        super(Main.getMain(), gameTasker);
    }

    @Override
    public void run() {

    }
}
