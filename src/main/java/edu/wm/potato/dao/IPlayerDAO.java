package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.exceptions.PlayerAlreadyExistsException;
import edu.wm.potato.model.Player;

public interface IPlayerDAO {
	
	void createPlayer(Player player) throws PlayerAlreadyExistsException;
	List<Player> getAllAlive();
	void update(Player updated) throws NoPlayerFoundException;
	Player getPlayerByID(String id) throws NoPlayerFoundException;
	List<Player> getAllPlayers();
	List<Player> nearPlayers(Player player, double distance);
	void clearPlayers();
	int numWolves();
	int numTown();
	
}
