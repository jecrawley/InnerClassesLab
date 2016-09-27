package crawley.james.innerclasseslab;

/**
 * Created by jamescrawley on 9/27/16.
 */
public interface Connection {

    void setPort (int port);
    int getPort ();
    void setIP (String IP);
    String getIP ();
    void setProtocol (Protocol protocol);
    Protocol getProtocol ();
    String connect ();
    String close ();

}
