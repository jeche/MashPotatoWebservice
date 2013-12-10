package edu.wm.potato.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.wm.potato.model.GPSLocation;
import edu.wm.potato.model.Game;
import edu.wm.potato.model.Player;
import edu.wm.potato.model.Potato;

public class MongoPotatoDAO implements IPotatoDAO{
	@Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "Potato";
     
    @Override
    public void addPotato(Potato potato) {
        if (!mongoTemplate.collectionExists(Potato.class)) {
            mongoTemplate.createCollection(Potato.class);
        }      
        potato.setpId(UUID.randomUUID().toString());
        mongoTemplate.insert(potato, COLLECTION_NAME);
    }
     
    public List<Potato> listPotatos() {
        return mongoTemplate.findAll(Potato.class, COLLECTION_NAME);
    }
     
    @Override
    public void updatePotato(Potato Potato) {
        mongoTemplate.insert(Potato, COLLECTION_NAME);     
    }
    
	@Override
	public Potato getPotatoById(String id) {
        Potato result = mongoTemplate.findById(id, Potato.class);
		return result;
	}

	@Override
	public void removePotatoById(Potato potato) {
		mongoTemplate.remove(potato, COLLECTION_NAME);
	}

	@Override
	public List<Potato> getPotatosByGame(Game game) {
    	List<Potato> results = null;
		Query query = new Query();
		Criteria criteria = new Criteria();
        criteria = criteria.and("gameId").is(game.getId());
        query.addCriteria(criteria);
        results = mongoTemplate.find(query, Potato.class);
    	return results;
	}

	@Override
	public void removePotatosByGame(Game game) {
		// TODO Auto-generated method stub
		
	}
}
