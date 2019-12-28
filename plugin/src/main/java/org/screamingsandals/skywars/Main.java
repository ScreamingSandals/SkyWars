package org.screamingsandals.skywars;

import org.screamingsandals.screamingcore.ScreamingPlugin;
import org.screamingsandals.screamingcore.cores.flattening.FlatteningCore;
import org.screamingsandals.screamingcore.cores.flattening.FlatteningCoreUsableCheck;
import org.screamingsandals.screamingcore.game.Game;
import org.screamingsandals.skywars.game.SkyWarsGame;
import org.screamingsandals.skywars.game.listeners.GameListener;
import org.screamingsandals.skywars.game.listeners.GamePlayerListener;

/**
 * @author ScreamingSandals team
 */
public class Main extends ScreamingPlugin {
	private static Main main;

	public static Main getMain() {
		return main;
	}

	@Override
	protected void onScreamingEnabled() {
		// You must specify core! It'll register platform and version specific listeners and register services
		// You can use quick, if you have just one possible core or start if you have more possible cores
		quick(FlatteningCore.class, new FlatteningCoreUsableCheck())
			.register(new GameListener())
			.register(new GamePlayerListener())
			.initialGamesLoad("games");
	}

	@Override
	protected void onScreamingDisabled() {

	}

	@Override
	public Game createBlankInstance() {
		return new SkyWarsGame(this);
	}
}
