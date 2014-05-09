package uk.co.revsys.utils.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
		if(request.getMethod().equals(HttpMethod.POST)){
			connection.setDoOutput(true);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
			for(Entry<String, String> parameter: request.getParameters().entrySet()){
				outputStreamWriter.write(parameter.getKey() + "=" + URLEncoder.encode(parameter.getValue(), "UTF-8") + "&");
			}
			outputStreamWriter.flush();
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
