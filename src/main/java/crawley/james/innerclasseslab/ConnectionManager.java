package crawley.james.innerclasseslab;

import java.util.*;

/**
 * Created by jamescrawley on 9/27/16.
 */
public class ConnectionManager {

    private final int maxConnections;
    private int connections = 0;
    List<Connection> connectionList = new ArrayList<Connection>();

    ConnectionManager (int maxConnections) {

        this.maxConnections = maxConnections;

    }

    Connection getConnection (int port, String IP, Protocol protocol) {

        Connection connection = new ManagedConnection(port, IP, protocol);;

        if (connection.connect().equals("Success")) {
            connectionList.add(connection);
        } else {
            connection = new ManagedConnection(0, null, null);
        }

        return connection;

    }

    private class ManagedConnection implements Connection {

        private int port;
        private String IP;
        private Protocol protocol;

        ManagedConnection (int port, String IP, Protocol protocol) {

            this.port = port;
            this.IP = IP;
            this.protocol = protocol;

        }

        public void setPort (int port) {

            this.port = port;

        }

        public int getPort () {

            return port;
        }

        public void setIP (String IP) {

            this.IP = IP;

        }

        public String getIP () {

            return IP;

        }

        public void setProtocol (Protocol protocol) {


            this.protocol = protocol;

        }

        public Protocol getProtocol () {

            return protocol;

        }
        /*
        public int getConnections () {

            return 0;

        }
        */

        public String connect () {

            if (connections < maxConnections) {
                connections++;
                return "Success";
            } else {
                return "Error: Too many connections";
            }
        }

    }
}
