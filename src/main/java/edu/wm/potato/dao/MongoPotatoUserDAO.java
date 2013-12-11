package edu.wm.potato.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import edu.wm.potato.exceptions.NoPlayerFoundException;
import edu.wm.potato.model.Player;
import edu.wm.potato.model.PotatoUser;

public class MongoPotatoUserDAO implements IPotatoUserDAO {
	@Autowired MongoTemplate mongoTemplate;
	@Autowired IPlayerDAO playerDAO;
	public static final String COLLECTION_NAME = "User";
	
	@Override
	public void createUser(PotatoUser user) {
        if (!mongoTemplate.collectionExists(PotatoUser.class)) {
            mongoTemplate.createCollection(PotatoUser.class);
        }      
//        player.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(user, COLLECTION_NAME);
//        Player player = new Player(user.getuId(), true, 0, 0, user.getuId(), false, 0, null, null, null);
//        playerDAO.createPlayer(player);
	}

	@Override
	public PotatoUser getUserByUsername(String username) {
		MongoOperations mongoOperations = mongoTemplate;
		Criteria criteria = new Criteria();
		criteria.and("uId").is(username);
		Query query = new Query();
		query.addCriteria(criteria);
		PotatoUser result = mongoTemplate.findOne(query, PotatoUser.class);
		System.out.println("Result " + result);
		System.out.println("Why.");
		
		System.out.println(mongoOperations.getCollection(COLLECTION_NAME).findOne());
		System.out.println("All results: " + mongoOperations.findAll(PotatoUser.class, COLLECTION_NAME).toString());
		System.out.println("fohohoho");
		return result;
	}

	@Override
	public List<PotatoUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PotatoUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearUsers() {
		// TODO Auto-generated method stub
		
	}

}
