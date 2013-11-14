package edu.wm.werewolf;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import de.flapdoodle.embedmongo.MongoDBRuntime;
import de.flapdoodle.embedmongo.MongodExecutable;
import de.flapdoodle.embedmongo.MongodProcess;
import de.flapdoodle.embedmongo.config.MongodConfig;
import de.flapdoodle.embedmongo.distribution.Version;
import de.flapdoodle.embedmongo.runtime.Network;
//import edu.wm.werewolf.dao.MongoPlayerDAO;
//import edu.wm.werewolf.exceptions.NoPlayerFoundException;
//import edu.wm.werewolf.exceptions.PlayerAlreadyExistsException;
//import edu.wm.werewolf.model.Player;

public class MongoPlayerDAOTest {
//	   private static final String DB_NAME = "werewolf";
//	   private MongodExecutable mongodExe;
//	   private MongodProcess mongod;
//	   private Mongo mongo;
//	   private DB dbo;
//	   private DBCollection collection;
//	   MongoPlayerDAO test = new MongoPlayerDAO();
//	   
//	   
//	@Before
//	public void setUp() throws Exception {
//        // Creating Mongodbruntime instance
//       MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
//        // Creating MongodbExecutable
//        mongodExe = runtime.prepare(new MongodConfig(Version.V2_1, 12345, Network.localhostIsIPv6()));
//        // Starting Mongodb
//        mongod = mongodExe.start();
//        
//        mongo = new MongoClient("localhost", 12345);
//        test.setMongo((MongoClient) mongo);
//        // Creating DB
//        dbo = mongo.getDB(DB_NAME);
//        test.setDb(dbo);
//       // Creating collection Object and adding values
//        collection = dbo.getCollection("Player");
//        Player testPlayer = new Player("test", false, 40.3, 38.2, "test", false);
//        test.createPlayer(testPlayer);
//        testPlayer.setId("test2");
//        test.createPlayer(testPlayer);
//        testPlayer.setId("test3");
//        test.createPlayer(testPlayer);
//        testPlayer.setId("test4");
//        test.createPlayer(testPlayer);
//        testPlayer.setId("test5");
//        test.createPlayer(testPlayer);
//	}
//	
//	@After
//	public void teardown() throws Exception 
//	{
//	   mongod.stop();
//	   mongodExe.cleanup();
//	}
//
//	@Test
//	public void CreatePlayerTest() throws UnknownHostException, PlayerAlreadyExistsException 
//	{
//		Player testPlayer = new Player("test6", false, 40.3, 38.2, "test6", false);
//		test.createPlayer(testPlayer);
//		// Inserting document
//		DBCursor cursorDoc = collection.find();
//		BasicDBObject contact1 = new BasicDBObject();
//		while(cursorDoc.hasNext()) {
//			contact1 = (BasicDBObject) cursorDoc.next();
//		}
//		assertEquals(contact1.get("userId"), "test6");
//		assertEquals(contact1.get("_id"), "test6");
//		assertEquals(contact1.get("loc"), new double[] {40.3, 38.2});
//		assertEquals(contact1.get("votedAgainst"), null);
//		assertEquals(contact1.get("isWerewolf"), false);
//		assertEquals(contact1.get("isDead"), false);
//	}	
//	
//	@Test(expected = MongoException.DuplicateKey.class)
//	public void createDuplicatePlayerTest() throws UnknownHostException, PlayerAlreadyExistsException 
//	{
//		Player testPlayer = new Player("test6", false, 40.3, 38.2, "test6", false);
//		test.createPlayer(testPlayer);
//		test.createPlayer(testPlayer);
//	}
//	
//	@Test
//	public void getByUserIdTest() throws NoPlayerFoundException
//	{
//		Player testPlayer = new Player("test6", false, 40.3, 38.2, "test6", false);
//		test.createPlayer(testPlayer);
//		assertEquals(test.getPlayerByID(testPlayer.getId()), testPlayer);
//	}
//	
//	@Test(expected = NoPlayerFoundException.class)
//	public void getByUserIdNotFoundTest() throws NoPlayerFoundException
//	{
//		Player testPlayer = new Player("test6", false, 40.3, 38.2, "test6", false);
//		test.getPlayerByID(testPlayer.getId());
//	}
//	
//	@Test
//	public void updatePlayerTest() throws NoPlayerFoundException
//	{
//		Player testPlayer = test.getPlayerByID("test");
//		testPlayer.setDead(true);
//		test.update(testPlayer);
//		assertEquals(testPlayer, test.getPlayerByID("test"));
//		
//	}
//	
//	@Test(expected = NoPlayerFoundException.class)
//	public void updatePlayerNotExistsTest() throws NoPlayerFoundException
//	{
//		Player testPlayer = new Player("test6", false, 40.3, 38.2, "test6", false);
//		test.update(testPlayer);
//	}
//	
//	@Test
//	public void getAllAliveTest() throws NoPlayerFoundException 
//	{
//		List<Player> aliveList =  test.getAllAlive();
//		assertEquals(aliveList.size(), 5);
//		Player tPlayer = test.getPlayerByID("test");
//		tPlayer.setDead(true);
//		test.update(tPlayer);
//		aliveList =  test.getAllAlive();
//		assertEquals(aliveList.size(), 4);
//	}
}
