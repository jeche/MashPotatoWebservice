package edu.wm.potato;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.wm.potato.dao.MongoGameDAO;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.JsonResponse;
import edu.wm.potato.service.PotatoGameService;
import edu.wm.potato.service.PotatoLobbyService;

@Controller
public class PotatoController {
	@Autowired MongoTemplate mongoTemplate;
	@Autowired MongoGameDAO gameDAO;
	@Autowired PotatoGameService gameService;
	@Autowired PotatoLobbyService lobbyService;
	
	@RequestMapping(value = "/removePlayer", method = {RequestMethod.POST})
	public @ResponseBody JsonResponse removePlayer(@RequestParam("playerId") String playerID, Model model) {
		// sets gameID to invalid value, checks gameID status, if ready to end, ends Game, updates Game as appropriate
		// returns gameStatus
		Game game = gameService.remove(playerID);
		JsonResponse response = new JsonResponse(Constants.success);
		response.setGame(game);
		return response;
	}
	
	@RequestMapping(value = "/lobby", method = {RequestMethod.GET})
	public @ResponseBody JsonResponse lobby(@RequestParam("lng") double lng, @RequestParam("lat") double lat, Model model) {
		// sets gameID to invalid value, checks gameID status, if ready to end, ends Game, updates Game as appropriate
		// returns gameStatus
		List<Game> lobby = lobbyService.getGamesNear(lat, lng);
		JsonResponse response = new JsonResponse(Constants.success);
		response.setLobby(lobby);
		return response;
	}
	
	@RequestMapping(value = "/updatePotatoInfo", method = {RequestMethod.POST})
	public String updatePotatoInfo(Principal principal, Model model) {
		// sends Potato info
		// returns gameStatus
//		gameDAO.addGame(game);
		return "home";
	}
	
	@RequestMapping(value = "/newGame", method = {RequestMethod.POST})
	public @ResponseBody JsonResponse newGame(@RequestParam(Constants.lifeSpan) long lifeSpan, @RequestParam(Constants.lat) double lat, @RequestParam(Constants.lng) double lng, Principal principal,  Model model) {
		// adds game to database as ready, but not started
		// returns gameStatus
		JsonResponse response = new JsonResponse(Constants.success);
		GPSLocation location = new GPSLocation();
		location.setLat(lat);
		location.setLng(lng);
		Game game = gameService.addGame(lifeSpan, location, principal.getName());
		response.setGame(game);
		return response;
	}
	
	@RequestMapping(value = "/startGame", method = {RequestMethod.POST})
	public @ResponseBody JsonResponse startGame(@RequestParam("gameID") String gameID, Principal principal, Model model) {
		// flips state to started initialize potatoes
		// returns gameStatus
		JsonResponse response = new JsonResponse(Constants.success);
		Game game = gameService.startGame(gameID, principal.getName());
		response.setGame(game);
		return response;
	}
	
	@RequestMapping(value = "/joinGame", method = {RequestMethod.POST})
	public String joinGame(@RequestParam("gameID") String gameID, Principal principal, Model model) {
		// adds player to game
		// returns gameStatus
		lobbyService.joinGame(gameID, principal.getName());
		
		return "home";
	}
	
	@RequestMapping(value = "/gameStatus/{gameID}", method = {RequestMethod.GET})
	public @ResponseBody JsonResponse gameStatus(@PathVariable("gameID") String gameID, Model model) {
		// returns Game Object as JSON response
		Game game = gameDAO.getGameById(gameID);
		JsonResponse response = new JsonResponse(Constants.success);
		response.setGame(game);
		return response;
	}
	
	
}
