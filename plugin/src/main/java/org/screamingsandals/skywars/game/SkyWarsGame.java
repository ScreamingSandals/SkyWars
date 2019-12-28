package org.screamingsandals.skywars.game;

import org.screamingsandals.screamingcore.ScreamingPlugin;
import org.screamingsandals.screamingcore.game.Game;
import org.screamingsandals.screamingcore.game.tasks.GameWaitingTask;

public class SkyWarsGame extends Game implements org.screamingsandals.skywars.api.game.Game {

	public SkyWarsGame(ScreamingPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void startGame() {
		super.startGame();
		
		getGameTasker().registerTask(new GameWaitingTask(getPlugin(), getGameTasker()));
	}
}
