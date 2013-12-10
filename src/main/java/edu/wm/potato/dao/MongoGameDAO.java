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
        return mongoTemplate.findById(id, Game.class);
	}

	@Override
	public List<Game> getGameByLocation(GPSLocation location, double distance) {
		// TODO Auto-generated method stub
		DBCollection table = mongoTemplate.getDb().getCollection(COLLECTION_NAME);
		BasicDBList v1 = new BasicDBList();
		v1.add(location.getLng());
		v1.add(location.getLat());
		BasicDBObject query = new BasicDBObject();
		query.put("loc", BasicDBObjectBuilder.start().append("$near",v1).append("$maxDistance", distance).get());
		DBObject index2d = BasicDBObjectBuilder.start("loc", "2d").get();
		table.ensureIndex(index2d);
		DBCursor cursor = table.find(query);
		Game alive;
		List<Game> players = new ArrayList<Game>();
		try {
		while (cursor.hasNext()) {
/*			DBObject item = cursor.next();
			alive = new Player((String)item.get("_id"), (boolean) item.get("isDead"),(double) ((BasicDBList)item.get("loc")).get(1), (double) ((BasicDBList)item.get("loc")).get(0), (String) item.get("userId"),(boolean) item.get("isWerewolf"), (boolean) item.get("hasUpdated"), (String) item.get("img"));
			if(!alive.isDead()) {
				players.add(alive);
			}*/
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
