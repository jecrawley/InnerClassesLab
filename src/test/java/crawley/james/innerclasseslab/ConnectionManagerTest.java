package crawley.james.innerclasseslab;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/27/16.
 */
public class ConnectionManagerTest {

    ConnectionManager connectionManager = new ConnectionManager(1);

    @Test
    public void getProtocolTest () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        assertEquals("The protocol should be \"HTTP\".", Protocol.HTTP, connection.getProtocol());

    }

    @Test
    public void getIPTest () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        assertEquals("The IP should be \"12.0.124.203\".", "12.0.124.203", connection.getIP());

    }

    @Test
    public void getPortTest () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        assertEquals("The port should be 8888.", 8888, connection.getPort());

    }

    @Test
    public void requestingTooManyConnectionsTest () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        connectionManager.addConnection(8888, "106.34.24.50", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(1);
        assertEquals("The protocol should be \"Null\".", null, connection);

    }

    @Test
    public void connectToOpenConnection() {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        assertEquals("The connection should connect sucessfully.", "Connection successful.", connection.connect());

    }

    @Test
    public void connectToClosedConnection () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        connection.close();
        assertEquals("The connection should fail to connect.", "Error: connection closed.", connection.connect());

    }

    @Test
    public void getFromClosedConnectionTest () {

        connectionManager.addConnection(8888, "12.0.124.203", Protocol.HTTP);
        Connection connection = connectionManager.getConnection(0);
        connection.close();
        assertEquals("The connection is closed, cannot get port.", -1, connection.getPort());

    }

}
