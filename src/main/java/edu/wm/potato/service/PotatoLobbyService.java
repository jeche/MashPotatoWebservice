package edu.wm.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.wm.potato.dao.IGameDAO;
import edu.wm.potato.dao.IPlayerDAO;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;

public class PotatoLobbyService {
	@Autowired IGameDAO gameDAO;
	@Autowired IPlayerDAO playerDAO;
	double DEFAULT_GAME_RANGE = 10;

	public List<Game> getGamesNear(double lat, double lng) {
		GPSLocation location = new GPSLocation();
		location.setLat(lat);
		location.setLng(lng);
		return gameDAO.getGameByLocation(location, DEFAULT_GAME_RANGE);
	}

	public Game joinGame(String gameID, String playerID) {
		Game game = gameDAO.getGameById(gameID);
		Player player = playerDAO.getPlayerById(playerID);
		player.setGameID(gameID);
		playerDAO.update(player);
		game.getPlayers().add(player);
		gameDAO.updateGame(game);
		return game;
	}

}