package edu.wm.potato;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.wm.potato.dao.IPotatoUserDAO;
import edu.wm.potato.dao.MongoGameDAO;
import edu.wm.potato.dao.MongoPlayerDAO;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.JsonResponse;
import edu.wm.potato.model.Player;
import edu.wm.potato.model.Potato;
import edu.wm.potato.model.PotatoUser;
import edu.wm.potato.service.PotatoGameService;
import edu.wm.potato.service.PotatoLobbyService;

@Controller
public class PotatoController {
	@Autowired MongoTemplate mongoTemplate;
	@Autowired MongoGameDAO gameDAO;
	@Autowired MongoPlayerDAO playerDAO;
	@Autowired PotatoGameService gameService;
	@Autowired PotatoLobbyService lobbyService;
	@Autowired IPotatoUserDAO userDAO;
	
	@RequestMapping(value = "/addUser", method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(@RequestParam("userName")String username, @RequestParam("id")String id,
			@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName,
			@RequestParam("hashedPassword")String hashedPassword, Principal principal)
	{
		JsonResponse response = new JsonResponse("success");
		try {
		BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
		Collection<GrantedAuthorityImpl> auth = new ArrayList<GrantedAuthorityImpl>();
		auth.add(new GrantedAuthorityImpl("ROLE_USER"));
		PotatoUser user = new PotatoUser(id, firstName, lastName, username, encoded.encode(hashedPassword), 0, false, 0, 0, 0, 0);// new PotatoUser(id, firstName, lastName, username, encoded.encode(hashedPassword), img);
		userDAO.createUser(user);
		} catch (Exception e) {
			System.out.println("WHYYYY343434");
			response.setStatus("failure);" + e.getMessage().toString());
		}
	
		return response;
	}
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public @ResponseBody JsonResponse fixer( Principal principal, Model model)
	{
		JsonResponse response = new JsonResponse("success");

		BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
		Collection<GrantedAuthorityImpl> auth = new ArrayList<GrantedAuthorityImpl>();
		auth.add(new GrantedAuthorityImpl("ROLE_USER"));
		
		PotatoUser user = new PotatoUser("jlchen", "jlchen", "jlchen", "jlchen", encoded.encode("test1"), 0, false, 0, 0, 0, 0);// new PotatoUser(id, firstName, lastName, username, encoded.encode(hashedPassword), img);
		userDAO.createUser(user);
		double[] loc = new double[] {1, 2};
		Game game = new Game("a", 0, loc, "");
		game.getPlayers().add(playerDAO.getPlayerById("jlchen"));
		System.out.println("game post add: " + game);
		gameDAO.addGame(game);
		game = lobbyService.joinGame(game.getId(), "jlchen");
		System.out.println(playerDAO.getPlayersByGame(game));
		
		System.out.println("Game: " + game);
		response.setGame(game);
		List<Game>lobby = new ArrayList<Game>();
		lobby.add(game);
		response.setLobby(lobby);
		response.setLobby(lobbyService.getGamesNear(5, 5));
		return response;
	}
	
	
	
	@RequestMapping(value = "/removePlayer", method = {RequestMethod.POST})
	public @ResponseBody JsonResponse removePlayer(@RequestParam("playerId") String playerID, Model model) {
		// sets gameID to invalid value, checks gameID status, if ready to end, ends Game, updates Game as appropriate
		// returns gameStatus
		Game game = gameService.remove(playerID);
		JsonResponse response = new JsonResponse(Constants.success);
		response.setGame(game);
		return response;
	}
	
	@RequestMapping(value = "/lobby", method = {RequestMethod.POST})
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
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public @ResponseBody JsonResponse loginStats(Principal principal) {
		JsonResponse response = new JsonResponse(Constants.success);
		Player player = playerDAO.getPlayerById(principal.getName());
		List<Game> gamesList= new ArrayList<Game>(); 
		if(!player.getGame().equals("")) {
			Game g = gameDAO.getGameById(player.getGame());
			gamesList.add(g);
			
		}else {
			List<Player> players = new ArrayList<Player>();
			players.add(player);
			double [] d = new double[2];
			d[0] = 0;
			d[1] = 0;
			Game g= new Game("", "", new Date().getTime(), 0, 0, 0, d, 0, players, new ArrayList<Potato>());
			gamesList.add(g);
		}
		response.setLobby(gamesList);
		return response;
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
