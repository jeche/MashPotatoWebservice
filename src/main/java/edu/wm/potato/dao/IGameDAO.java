package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;

public interface IGameDAO {
	public void updateGame(Game game);
	public void addGame(Game game);
	public Game getGameById(String id);
	public List<Game> getGameByLocation(GPSLocation location, double distance);
	void removeGame(Game game);
}
