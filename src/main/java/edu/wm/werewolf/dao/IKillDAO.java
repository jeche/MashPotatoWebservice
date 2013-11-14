package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.exceptions.NoPlayerFoundException;
import edu.wm.werewolf.model.Kill;
import edu.wm.werewolf.model.Player;

public interface IKillDAO {
	void createKill(Player victim, Player killer) throws NoPlayerFoundException;
	List<Kill> getAllKills();
	List<Kill> getKillsByPlayerID(String id) throws NoPlayerFoundException;

}
