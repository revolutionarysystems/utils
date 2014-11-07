
package uk.co.revsys.utils.mongodb;

import com.mongodb.ServerAddress;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MongoClientTest {

    public MongoClientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost");
        List<ServerAddress> hosts = mongoClient.getAllAddress();
        assertEquals(1, hosts.size());
        ServerAddress host = hosts.get(0);
        assertEquals("localhost", host.getHost());
        assertEquals(27017, host.getPort());
        mongoClient = new MongoClient("localhost:27018");
        hosts = mongoClient.getAllAddress();
        assertEquals(1, hosts.size());
        host = hosts.get(0);
        assertEquals("localhost", host.getHost());
        assertEquals(27018, host.getPort());
        mongoClient = new MongoClient("localhost:27018, www.example.com:27019");
        hosts = mongoClient.getAllAddress();
        assertEquals(2, hosts.size());
        host = hosts.get(0);
        assertEquals("localhost", host.getHost());
        assertEquals(27018, host.getPort());
        host = hosts.get(1);
        assertEquals("www.example.com", host.getHost());
        assertEquals(27019, host.getPort());
    }

}