package uk.co.revsys.utils.http;

import java.net.HttpURLConnection;

public interface Credentials {
    
    public void applyCredentials(HttpURLConnection connection);
    
}
