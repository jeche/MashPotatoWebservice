package edu.wm.potato.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import edu.wm.potato.Constants;
import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;

@Repository
public class MongoGameDAO implements IGameDAO {
	@Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "Game";
     
    @Override
    public void addGame(Game game) {
        if (!mongoTemplate.collectionExists(Game.class)) {
            mongoTemplate.createCollection(Game.class);
        }      
        game.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(game, COLLECTION_NAME);
    }
     
    public List<Game> listGames() {
        return mongoTemplate.findAll(Game.class, COLLECTION_NAME);
    }
    
    @Override
    public void updateGame(Game game) {
        mongoTemplate.insert(game, COLLECTION_NAME);     
    }

	@Override
	public Game getGameById(String id) {
		List<Game>games =  mongoTemplate.findAll(Game.class, COLLECTION_NAME);
		System.out.println("LIST OF GAMES: " + games);
        return games.get(0);
	}

	@Override
	public List<Game> getGameByLocation(GPSLocation location, double distance) {
		DBCollection table = mongoTemplate.getDb().getCollection(COLLECTION_NAME);
		BasicDBList v1 = new BasicDBList();
		v1.add(location.getLng());
		v1.add(location.getLat());
		BasicDBObject query = new BasicDBObject();
		query.put("loc", BasicDBObjectBuilder.start().append("$near",v1).append("$maxDistance", distance).get());
		DBObject index2d = BasicDBObjectBuilder.start("loc", "2d").get();
		table.ensureIndex(index2d);
		DBCursor cursor = table.find(query);
		Game alive = null;
		List<Game> players = new ArrayList<Game>();
		try {
		while (cursor.hasNext()) {
			DBObject item = cursor.next();
			//= new Game(id, dayNightFreq, creationDate, maxRoundTime, roundCount, state, originalLocation, potatoCount, players, potato, outOrder)
			if(alive.getState() == Constants.STATE_READY) {
				players.add(alive);
			}
		}
		}
		finally {
			cursor.close();
		}
		return players;
		
	}

	@Override
	public void removeGame(Game game) {
		mongoTemplate.remove(game, COLLECTION_NAME);
	}

}
