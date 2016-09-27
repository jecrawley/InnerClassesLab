package crawley.james.innerclasseslab;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/27/16.
 */
public class ConnectionManagerTest {

    ConnectionManager connectionManager = new ConnectionManager(1);
    Connection connection0 = connectionManager.getConnection(8888, "12.0.124.203", Protocol.HTTP);
    Connection connection1 = connectionManager.getConnection(8888, "106.34.24.50", Protocol.HTTP);

    @Test
    public void getProtocolTest () {

        assertEquals("The protocol should be \"HTTP\".", Protocol.HTTP, connection0.getProtocol());

    }

    @Test
    public void getIPTest () {

        assertEquals("The IP should be \"12.0.124.203\".", "12.0.124.203", connection0.getIP());

    }

    @Test
    public void getPortTest () {

        assertEquals("The protocol should be 8888.", 8888, connection0.getPort());

    }

    @Test
    public void requestingTooManyConnectionsTest () {

        assertEquals("The protocol should be \"Null\".", null, connection1.getProtocol());

    }
/*
    @Test
    public void getFromClosedConnectionTest () {

    }
*/

}
