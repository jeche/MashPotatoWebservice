package edu.wm.potato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.wm.potato.dao.MongoGameDAO;
import edu.wm.potato.model.Game;

@Controller
public class PotatoController {
	@Autowired MongoTemplate mongoTemplate;
	@Autowired MongoGameDAO gameDAO;
	
	@RequestMapping(value = "/removePlayer", method = {RequestMethod.POST})
	public String removePlayer(@RequestParam("playerId") String playerID, Model model) {
		// sets gameID to invalid value, checks gameID status, if ready to end, ends Game, updates Game as appropriate
		// returns gameStatus
		Game game = new Game(playerID, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/updatePotatoInfo", method = {RequestMethod.POST})
	public String updatePotatoInfo(Model model) {
		// sends Potato info
		// returns gameStatus
		Game game = new Game(null, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/newGame", method = {RequestMethod.POST})
	public @ResponseBody String newGame(@RequestParam("lifeSpan") long maxRound, Model model) {
		// adds game to database as ready, but not started
		// returns gameStatus
		Game game = new Game(null, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/startGame", method = {RequestMethod.POST})
	public String startGame(Model model) {
		// flips state to started initialize potatoes
		// returns gameStatus
		Game game = new Game(null, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/joinGame", method = {RequestMethod.POST})
	public String joinGame(Model model) {
		// adds player to game
		// returns gameStatus
		Game game = new Game(null, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/gameStatus/{gameID}", method = {RequestMethod.GET})
	public String gameStatus(@PathVariable("gameID") String gameID, Model model) {
		// returns Game Object as JSON response
		Game game = new Game(gameID, 0, 0, 0, 0, 0, null, 0, null, null, null);
		gameDAO.addGame(game);
		return "home";
	}
	
	
}
