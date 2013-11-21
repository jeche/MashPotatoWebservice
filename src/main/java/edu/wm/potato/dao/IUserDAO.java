package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.model.PotatoUser;

public interface IUserDAO {
	
	void createUser(PotatoUser user);
	PotatoUser getUserByUsername(String username);
	List<PotatoUser> getAllUsers();
	void update(PotatoUser user);
	void clearUsers();
}
