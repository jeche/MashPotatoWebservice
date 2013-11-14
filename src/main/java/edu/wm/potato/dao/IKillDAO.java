package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.model.Kill;
import edu.wm.potato.model.Player;

public interface IKillDAO {
	void createKill(Player victim, Player killer) throws NoPlayerFoundException;
	List<Kill> getAllKills();
	List<Kill> getKillsByPlayerID(String id) throws NoPlayerFoundException;

}
