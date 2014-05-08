package uk.co.revsys.utils.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientImpl implements HttpClient{

	@Override
	public HttpResponse invoke(HttpRequest request) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(request.getUrl()).openConnection();
		connection.setRequestMethod(request.getMethod().name());
		for(Entry<String, String> header: request.getHeaders().entrySet()){
			connection.setRequestProperty(header.getKey(), header.getValue());
		}
		HttpResponse response = new HttpResponse();
		response.setStatusCode(connection.getResponseCode());
		response.setContentLength(connection.getContentLength());
		response.setContentType(connection.getContentType());
		Map<String, List<String>> headerFields = connection.getHeaderFields();
		for (String headerKey : headerFields.keySet()) {
			if (headerKey != null) {
				for (String headerValue : headerFields.get(headerKey)) {
					response.getHeaders().put(headerKey, headerValue);
				}
			}
		}
		InputStream inputStream;
		if(connection.getResponseCode() == 200){
			inputStream = connection.getInputStream();
		}else{
			inputStream = connection.getErrorStream();
		}
		response.setInputStream(inputStream);
		return response;
	}

}
