package edu.wm.potato.dao;

import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.GPSRange;
import edu.wm.potato.model.Game;

public interface IGameDAO {
	public void addGame(Game game);
	public Game getGameById(String id);
	public Game getGameByLocation(GPSLocation location, GPSRange range);
	void removeGameById(String id);
}
