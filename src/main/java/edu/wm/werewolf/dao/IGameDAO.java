package edu.wm.werewolf.dao;

import edu.wm.werewolf.model.Game;

public interface IGameDAO {
	public void createGame(Game game);
	public Game getGame();
	void removeGame();
}
