package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.exceptions.PlayerAlreadyExistsException;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;

public interface IPlayerDAO {
	
	void createPlayer(Player player) throws PlayerAlreadyExistsException;
	List<Player> getPlayersByGame(Game game);
	void update(Player updated) throws NoPlayerFoundException;
	Player getPlayerByID(String id, Game game) throws NoPlayerFoundException;
	void remove(Player player) throws NoPlayerFoundException;
	Player getPlayerById(String id);
	void removePlayerById(String id);
	
}
