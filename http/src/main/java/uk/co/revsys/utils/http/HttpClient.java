package uk.co.revsys.utils.http;

import java.io.IOException;

public interface HttpClient {

	public HttpResponse invoke(HttpRequest request) throws IOException;
	
}
