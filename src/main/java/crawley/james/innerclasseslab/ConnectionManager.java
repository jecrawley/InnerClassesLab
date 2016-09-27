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

    void addConnection(int port, String IP, Protocol protocol) {

        Connection connection = new ManagedConnection(port, IP, protocol);
        String message = "Error: too many connections.";

        if (connections < maxConnections) {

            connectionList.add(connection);
            connections++;
            message = "Connection added.";

        }

        System.out.println(message);
    }

    void addConnection(int port, String IP) {

        Connection connection = new ManagedConnection(port, IP, Protocol.HTTP);
        String message = "Error: too many connections.";

        if (connections < maxConnections) {

            connectionList.add(connection);
            connections++;
            message = "Connection added.";

        }

        System.out.println(message);
    }

    Connection getConnection (int index) {

        try {

            return connectionList.get(index);

        } catch (IndexOutOfBoundsException e){

            return null;

        }
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

            if (port == -1) {
                System.out.println("Error: connection closed.");
            }

            return port;
        }

        public void setIP (String IP) {

            this.IP = IP;

        }

        public String getIP () {

            if (IP.equals("closed")) {
                System.out.println("Error: connection closed.");
            }

            return IP;

        }

        public void setProtocol (Protocol protocol) {


            this.protocol = protocol;

        }

        public Protocol getProtocol () {

            return protocol;

        }

        public String connect () {

            return (IP.equals("closed.")) ? "Error: connection closed." : "Connection successful.";
        }

    }
}
