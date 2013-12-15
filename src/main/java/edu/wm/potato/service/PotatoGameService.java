package edu.wm.potato.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.wm.potato.Constants;
import edu.wm.potato.dao.IGameDAO;
import edu.wm.potato.dao.IPlayerDAO;
import edu.wm.potato.dao.IPotatoDAO;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;
import edu.wm.potato.model.Potato;

public class PotatoGameService {
	@Autowired IPlayerDAO playerDAO;
	@Autowired IGameDAO gameDAO;
	@Autowired PotatoLobbyService lobbyService;
//	@Autowired IPotatoDAO potatoDAO;

	public Game remove(String playerID) {
		Player player = playerDAO.getPlayerById(playerID);
		Game game = gameDAO.getGameById(player.getGame());
		player.setGame("");
		game.getPlayers().remove(player);
		player.setHasString(false);
		player.setOut(true);
		if(player.isHasString()) {
			for(Player p : game.getPlayers()) {
				p.setScore(p.getScore() + 1 );
				playerDAO.update(p);
			}
		}
		gameDAO.updateGame(game);
		playerDAO.update(player);
		return game;
	}

	public Game startGame(String gameID, String ownerName) {
		Game game = gameDAO.getGameById(gameID);
		System.out.println("Owner is: " + ownerName + "and should be: " + game.getOwner());
		if(ownerName.equals(game.getOwner()) && game.getPlayers().size() > 2) {
			game.setState(Constants.STATE_PLAY);
			int numPotato = game.getPlayers().size();
//			numPotato = numPotato / 4 + 1;
			numPotato = 1;
			game.setCreationDate(new Date().getTime());
			game.setPotatoCount(numPotato);
			Collections.shuffle(game.getPlayers());
			double [] d = new double[2];
			d[0] = game.getPlayers().get(0).getLat();
			d[1] = game.getPlayers().get(0).getLng();
			Potato pot = new Potato("", 1, new Date().getTime(), game.getPlayers().get(0), game.getMaxRoundTime(), gameID, d);
			List<Potato> po = new ArrayList<Potato>();
			po.add(pot);
			game.setPotato(po);
			Player player = game.getPlayers().get(0);
			System.out.println("Chosen one is: " + player.getId());
			player.setHasString(true);
			player.setPotatoList(po);
			gameDAO.updateGame(game);
			playerDAO.update(player);	
/*			for(int i = 0; i < numPotato; i++) {
				game.getPlayers().get(i).setHasPotato(true);
			}*/
		}
		return game;
	}

	public Game addGame(long lifeSpan, GPSLocation location, String name) {
		// TODO Auto-generated method stub
		double[] loc = new double[2];
		loc[0] = location.getLat();
		loc[1] = location.getLng();
		System.out.println("Username: " + name + " attempted to create a game.");
		Game game = new Game("", lifeSpan, loc, name);
		
		gameDAO.addGame(game);
		lobbyService.joinGame(game.getId(), name);
		return game;
		
	}

}
