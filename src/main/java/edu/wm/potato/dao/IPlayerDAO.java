package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.exceptions.PlayerAlreadyExistsException;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;

public interface IPlayerDAO {
	
	void createPlayer(Player player) throws PlayerAlreadyExistsException;
	List<Player> getAllInGame(Game game);
	void update(Player updated, Game game) throws NoPlayerFoundException;
	Player getPlayerByID(String id, Game game) throws NoPlayerFoundException;
	List<Player> getAllPlayers();
	List<Player> nearPlayers(Player player, double distance);
	void clearPlayers();
	int numWolves();
	int numTown();
	
}
