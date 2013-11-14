package edu.wm.potato.dao;

import edu.wm.potato.model.Game;

public interface IGameDAO {
	public void createGame(Game game);
	public Game getGame();
	void removeGame();
}
