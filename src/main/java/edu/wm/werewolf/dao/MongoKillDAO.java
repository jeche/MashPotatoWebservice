package edu.wm.werewolf.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.bson.NewBSONDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import edu.wm.werewolf.exceptions.NoPlayerFoundException;
import edu.wm.werewolf.model.Kill;
import edu.wm.werewolf.model.Player;

public class MongoKillDAO implements IKillDAO {
//	@Autowired private MongoClient mongo;
	@Autowired private DB db;
	@Autowired private IPlayerDAO playerDAO;
	static DateFormat dateFormat = new SimpleDateFormat();
	
	@Override
	public void createKill(Player victim, Player killer) throws NoPlayerFoundException {
		// TODO Auto-generated method stub
		//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Player");
		// If werewolf kills a player
		BasicDBObject document = new BasicDBObject();
		document.put("_id", killer.getId());
		DBObject doc = table.findOne(document);
		BasicDBObject kill = new BasicDBObject();
		kill.put("victim", victim.getId());
		kill.put("time", new java.util.Date().toString());
		kill.put("loc", new double[] {victim.getLng(), victim.getLat()});
		if(doc.get("kills") == null)
		{
			List<BasicDBObject> killList = new ArrayList<BasicDBObject>();
			killList.add(kill);
			doc.put("kills", killList);
		}
		else 
		{
			List<BasicDBObject> killList = (List<BasicDBObject>) doc.get("kills");
			killList.add(kill);
			doc.put("kills", killList);
		}
		table.save(doc);
	}

	@Override
	public List<Kill> getAllKills() {
		// TODO Auto-generated method stub
		//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Player");
		DBCursor cursor = table.find();
		Kill kill;
		List<Kill> kills = new ArrayList<>();
		while (cursor.hasNext()) {
			DBObject item = cursor.next();
			if(item.get("kills") != null)
			{
				List<BasicDBObject> killList = (List<BasicDBObject>) item.get("kills");
				for (int i = 0; i < killList.size(); i++) {
					String dString = (String) killList.get(i).get("time");
					Date date = new Date();
					try {
						date = dateFormat.parse(dString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					kill = new Kill((String) item.get("_id"),(String) killList.get(i).get("victim"), date, (double) ((BasicDBList)killList.get(i).get("loc")).get(1), (double) ((BasicDBList)killList.get(i).get("loc")).get(0));
					kills.add(kill);
				}
			}
		}
		return kills;
	}

	@Override
	public List<Kill> getKillsByPlayerID(String id)
			throws NoPlayerFoundException {
		//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Player");
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the mongo
	 */
	public MongoClient getMongo() {
//		return mongo;
		return null;
	}

	/**
	 * @param mongo the mongo to set
	 */
	public void setMongo(MongoClient mongo) {
//		this.mongo = mongo;
	}

	/**
	 * @return the db
	 */
	public DB getDb() {
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(DB db) {
		this.db = db;
	}
	
}
