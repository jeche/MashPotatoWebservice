package edu.wm.werewolf.dao;

import java.util.List;
import edu.wm.werewolf.exceptions.NoPlayerFoundException;
import edu.wm.werewolf.exceptions.PlayerAlreadyExistsException;
import edu.wm.werewolf.model.Player;

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
