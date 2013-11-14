package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.model.WerewolfUser;

public interface IUserDAO {
	
	void createUser(WerewolfUser user);
	WerewolfUser getUserByUsername(String username);
	List<WerewolfUser> getAllUsers();
	void update(WerewolfUser user);
	void clearUsers();
}
