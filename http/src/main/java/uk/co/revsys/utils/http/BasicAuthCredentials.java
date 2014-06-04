package uk.co.revsys.utils.http;

import java.net.HttpURLConnection;
import org.apache.commons.codec.binary.Base64;

public class BasicAuthCredentials implements Credentials {

    private String username;
    private String password;
    private Base64 base64 = new Base64();

    public BasicAuthCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void applyCredentials(HttpURLConnection connection) {
        String encoded = base64.encodeAsString((username + ":" + password).getBytes());
        connection.setRequestProperty("Authorization", "Basic " + encoded);
    }

}
