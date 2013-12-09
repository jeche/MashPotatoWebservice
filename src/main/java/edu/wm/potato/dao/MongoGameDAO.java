package edu.wm.potato.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.GPSRange;
import edu.wm.potato.model.Game;

@Repository
public class MongoGameDAO implements IGameDAO {
//	@Autowired private MongoClient mongo;
	@Autowired DB db;     
	@Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "Game";
     
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
     
    public void deletePerson(Game game) {
        mongoTemplate.remove(game, COLLECTION_NAME);
    }
     
    public void updatePerson(Game game) {
        mongoTemplate.insert(game, COLLECTION_NAME);     
    }
/*
@Override
public void addGame(Game game) {
	// TODO Auto-generated method stub
	DBCollection table = db.getCollection("Game");
	BasicDBObject document = new BasicDBObject();
	document.put(game);
	table.insert(document);
	
}

@Override
public Game getGameById(String id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Game getGameByLocation(GPSLocation location, GPSRange range) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void removeGameById(String id) {
	// TODO Auto-generated method stub
	
}
	*/

	@Override
	public Game getGameById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getGameByLocation(GPSLocation location, GPSRange range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGameById(String id) {
		// TODO Auto-generated method stub
		
	}
	
/*	@Override
	public void createGame(Game game) {
//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Game");
		BasicDBObject document = new BasicDBObject();
		document.put("create", game.getTimer());
		document.put("freq", game.getDayNightFreq());
		document.put("isrunning", game.isRunning());
		table.insert(document);
	}

	@Override
	public Game getGame() {
//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Game");
		BasicDBObject query = (BasicDBObject) table.findOne();
		Game game = new Game((long)query.get("freq"), (long)query.get("create"));
		game.setRunning((boolean)query.get("isrunning"));
		return game;
	}
	
	@Override
	public void removeGame() {
//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Game");
		table.drop();
	}*/

}
