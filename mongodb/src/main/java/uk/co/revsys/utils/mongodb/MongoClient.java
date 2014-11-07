package uk.co.revsys.utils.mongodb;

import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class MongoClient extends com.mongodb.MongoClient {

    public MongoClient(final String hostsString) throws UnknownHostException {
        super(new LinkedList<ServerAddress>() {
            {
                String[] hosts = hostsString.split(",");
                for (String host : hosts) {
                    host = host.trim();
                    int port = ServerAddress.defaultPort();
                    int index = host.indexOf(":");
                    if (index > -1) {
                        port = Integer.parseInt(host.substring(index+1));
                        host = host.substring(0, index);
                    }
                    add(new ServerAddress(host, port));
                }
            }
        });
    }

}
