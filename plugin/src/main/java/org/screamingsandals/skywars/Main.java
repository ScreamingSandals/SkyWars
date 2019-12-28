package org.screamingsandals.skywars;

import org.screamingsandals.screamingcore.ScreamingPlugin;
import org.screamingsandals.screamingcore.cores.flattening.FlatteningCore;
import org.screamingsandals.screamingcore.cores.flattening.FlatteningCoreUsableCheck;
import org.screamingsandals.screamingcore.game.Game;
import org.screamingsandals.screamingcore.game.GameUtilities;
import org.screamingsandals.skywars.game.SkyWarsGame;

import java.io.File;

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
		quick(FlatteningCore.class, new FlatteningCoreUsableCheck());

		GameUtilities.loadGames(this, new File(getDataFolder(), "games"));
	}

	@Override
	protected void onScreamingDisabled() {

	}

	@Override
	public Game createBlankInstance() {
		return new SkyWarsGame(this);
	}
}
