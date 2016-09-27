package crawley.james.innerclasseslab;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/27/16.
 */
public class ConnectionManagerTest {

    ConnectionManager connectionManager = new ConnectionManager(10);
    Connection connection = connectionManager.getConnection(8888, "12.0.124.203", Protocol.HTTP);

    @Test
    public void getProtocolTest () {

        assertEquals("The protocol should be \"HTTP\".", Protocol.HTTP, connection.getProtocol());

    }

    @Test
    public void getIPTest () {

        assertEquals("The IP should be \"12.0.124.203\".", "12.0.124.203", connection.getIP());

    }

    @Test
    public void getPortTest () {

        assertEquals("The protocol should be 8888.", 8888, connection.getPort());

    }
/*
    @Test
    public void requestingTooManyConnectionsTest () {

    }

    @Test
    public void getFromClosedConnectionTest () {

    }
    */


}
