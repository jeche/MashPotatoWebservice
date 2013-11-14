package edu.wm.werewolf;

import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//
//import de.flapdoodle.embedmongo.MongoDBRuntime;
//import de.flapdoodle.embedmongo.MongodExecutable;
//import de.flapdoodle.embedmongo.MongodProcess;
//import de.flapdoodle.embedmongo.config.MongodConfig;
//import de.flapdoodle.embedmongo.distribution.Version;
//import de.flapdoodle.embedmongo.runtime.Network;
//import edu.wm.werewolf.dao.MongoKillDAO;
//import edu.wm.werewolf.dao.MongoPlayerDAO;
//import edu.wm.werewolf.exceptions.NoPlayerFoundException;
//import edu.wm.werewolf.model.Kill;
//import edu.wm.werewolf.model.Player;

public class MongoKillDAOTest {
//
//	   private static final String DB_NAME = "werewolf";
//	   private MongodExecutable mongodExe;
//	   private MongodProcess mongod;
//	   private Mongo mongo;
//	   private DB dbo;
//	   private DBCollection collection;
//	   MongoKillDAO testKill = new MongoKillDAO();
//	   MongoPlayerDAO test = new MongoPlayerDAO();
	   
//	   
//	@Before
//	public void setUp() throws Exception {
//     // Creating Mongodbruntime instance
//    MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
//     // Creating MongodbExecutable
//     mongodExe = runtime.prepare(new MongodConfig(Version.V2_1, 12345, Network.localhostIsIPv6()));
//     // Starting Mongodb
//     mongod = mongodExe.start();
//     
//     mongo = new MongoClient("localhost", 12345);
//     test.setMongo((MongoClient) mongo);
//     // Creating DB
//     dbo = mongo.getDB(DB_NAME);
//     test.setDb(dbo);
//     testKill.setMongo((MongoClient) mongo);
//     testKill.setDb(dbo);
//    // Creating collection Object and adding values
//     collection = dbo.getCollection("Player");
//     Player testPlayer = new Player("test", false, 40.3, 38.2, "test", false);
//     test.createPlayer(testPlayer);
//     testPlayer.setId("test2");
//     test.createPlayer(testPlayer);
//     testPlayer.setId("test3");
//     test.createPlayer(testPlayer);
//     testPlayer.setId("test4");
//     test.createPlayer(testPlayer);
//     testPlayer.setId("test5");
//     test.createPlayer(testPlayer);
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
//	public void test() throws NoPlayerFoundException {
//		Player testPlayer = new Player("test", false, 40.3, 38.2, "test", false);
//		testKill.createKill(testPlayer, testPlayer);
//		testKill.createKill(testPlayer, testPlayer);
//		testPlayer = new Player("test2", false, 40.3, 38.2, "test", false);
//		testKill.createKill(testPlayer, testPlayer);
//		
//	}

}
