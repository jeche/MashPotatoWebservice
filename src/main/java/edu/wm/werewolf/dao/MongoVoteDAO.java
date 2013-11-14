package edu.wm.werewolf.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import edu.wm.werewolf.model.Player;
import edu.wm.werewolf.model.Vote;

public class MongoVoteDAO implements IVoteDAO {
//	@Autowired private MongoClient mongo;
	@Autowired private DB db;
	@Override
	public void addVote(Vote vote) {
//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Vote");
		BasicDBObject document = new BasicDBObject();
		document.put("player", vote.getName());
		document.put("day", vote.getCreatedDate());
		DBObject cursor = table.findOne(document);
		if(cursor == null) {
			document.put("votes", 1);
			table.insert(document);
		}
		else {
			int votes = (int)cursor.get("votes") + vote.getNumVotes();
			vote.setNumVotes(votes);
			cursor.put("votes", votes);
			table.save(cursor);
		}
	}
	
	public List<Vote> mostVotes(long day) {
//		db = mongo.getDB("werewolf");
		DBCollection table = db.getCollection("Vote");
		BasicDBObject document = new BasicDBObject();
		document.put("day", day);
		DBCursor cursor = table.find(document);
		System.out.println(cursor.toString());
		Vote voted;
		List<Vote> voteList = new ArrayList<>();
		try {
		while (cursor.hasNext()) {
			DBObject item = cursor.next();
			voted = new Vote((String) item.get("player"),(int) item.get("votes"), 1, 1);
			if(voted.getNumVotes() > voteList.size()) {
				voteList.add(voteList.size(), voted);
			}
			else {
				voteList.add((int)voted.getNumVotes(), voted);
			}
		}
		}
		finally {
			cursor.close();
		}
		System.out.println(voteList);
		int i = 0;
		while(i < voteList.size()) {
			if(voteList.get(i).getNumVotes()<voteList.get(voteList.size() - 1).getNumVotes()) {
				voteList.remove(i);
			}
			i++;
			System.out.println(voteList);
		}
		return voteList;
	}

	@Override
	public void clearVotes() {
		// TODO Auto-generated method stub
		DBCollection table = db.getCollection("Vote");
		table.drop();
	}
	
}
