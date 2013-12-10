package edu.wm.potato.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.bson.BSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;
import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.exceptions.PlayerAlreadyExistsException;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;

public class MongoPlayerDAO implements IPlayerDAO {
	@Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "Player";
     
    public void addPlayer(Player player) {
        if (!mongoTemplate.collectionExists(Player.class)) {
            mongoTemplate.createCollection(Player.class);
        }      
        player.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(player, COLLECTION_NAME);
    }
    
    public void createPersonCollection() {
        if (!mongoTemplate.collectionExists(Player.class)) {
            mongoTemplate.createCollection(Player.class);
        }
    }
     
    public List<Player> listPlayers() {
        return mongoTemplate.findAll(Player.class, COLLECTION_NAME);
    }
     
    public void deletePlayer(Player player) {
        mongoTemplate.remove(player, COLLECTION_NAME);
    }
     
    public void updatePlayer(Player player) {
        mongoTemplate.insert(player, COLLECTION_NAME);     
    }

	@Override
	public Player getPlayerById(String id) {
		Player result = mongoTemplate.findById(id, Player.class);
		return result;
	}

	@Override
	public void removePlayerById(String id) {
		Player result = mongoTemplate.findById(id,  Player.class);
		this.deletePlayer(result);
		
	}
	@Override
	public void createPlayer(Player player) throws PlayerAlreadyExistsException {
		this.addPlayer(player);
	}
	@Override
	public List<Player> getPlayersByGame(Game game) {
		List<Player> results = null;
		Query query = new Query();
		Criteria criteria = new Criteria();
        criteria = criteria.and("age").is(game.getId());
        query.addCriteria(criteria);
        results = mongoTemplate.find(query, Player.class);
		return results;
	}
	@Override
	public void update(Player updated) throws NoPlayerFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Player getPlayerByID(String id, Game game)
			throws NoPlayerFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void remove(Player player) throws NoPlayerFoundException {
		// TODO Auto-generated method stub
		
	}
}
