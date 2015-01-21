package uk.co.revsys.utils.http;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.MultiValueMap;

public class HttpRequest {

	private String url;
	private HttpMethod method = HttpMethod.GET;
	private Map<String, String> headers = new HashMap<String, String>();
	private MultiValueMap parameters = new MultiValueMap();
    private InputStream body;
    private Credentials credentials;
	
	public HttpRequest(String url) {
		this.url = url;
	}
	
	public static HttpRequest GET(String url){
		return new HttpRequest(url);
	}
	
	public static HttpRequest POST(String url, MultiValueMap parameters){
		HttpRequest request = new HttpRequest(url);
		request.setMethod(HttpMethod.POST);
		request.setParameters(parameters);
		return request;
	}
    
    public static HttpRequest POST(String url, String contentType, InputStream body){
        HttpRequest request = new HttpRequest(url);
		request.setMethod(HttpMethod.POST);
		request.setBody(body);
        request.getHeaders().put("Content-Type", contentType);
		return request;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public MultiValueMap getParameters() {
		return parameters;
	}
    
	public void setParameters(MultiValueMap parameters) {
		this.parameters = parameters;
	}

    public InputStream getBody() {
        return body;
    }

    public void setBody(InputStream body) {
        this.body = body;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
	
}
