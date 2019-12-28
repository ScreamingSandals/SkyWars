package org.screamingsandals.skywars.game.tasks.game;

import org.screamingsandals.screamingcore.events.game.GamePreStartEvent;
import org.screamingsandals.screamingcore.game.Game;
import org.screamingsandals.screamingcore.game.GameState;
import org.screamingsandals.screamingcore.game.GameTasker;
import org.screamingsandals.screamingcore.game.tasks.BaseTask;
import org.screamingsandals.skywars.Main;

/**
 * @author ScreamingSandals team
 */
public class GameWaitingTask extends BaseTask {
    private Game game;

    private int lobbyTime;
    private int countdown;

    public GameWaitingTask(GameTasker gameTasker) {
        super(gameTasker);
        setRunLoop(true);

        game = (Game) getGameTasker().getGame();
        lobbyTime = game.getLobbyTime();
        resetCountdown();
    }

    @Override
    public void run() {
        if (countdown == 0 && game.isEnoughPlayersInGame()) {
            game.setGameState(GameState.RUNNING);

            GamePreStartEvent gamePreStartEvent = new GamePreStartEvent(game);
            Main.getMain().getCore().call(gamePreStartEvent);
            this.cancel();
            return;
        }

        if (game.isEnoughPlayersInGame()) {
            countdown--;
        }

        if (game.getGamePlayers().isEmpty()) {
            resetCountdown();
        }
    }

    private void resetCountdown() {
        countdown = lobbyTime;
    }

}
