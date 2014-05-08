package uk.co.revsys.utils.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

	private String url;
	private HttpMethod method = HttpMethod.GET;
	private Map<String, String> headers = new HashMap<String, String>();
	
	public HttpRequest(String url) {
		this.url = url;
	}
	
	public static HttpRequest GET(String url){
		return new HttpRequest(url);
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
	
}
