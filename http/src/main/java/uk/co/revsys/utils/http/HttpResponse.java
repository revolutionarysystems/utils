package uk.co.revsys.utils.http;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int statusCode;
    private String contentType;
    private int contentLength;
    private Map<String, String> headers = new HashMap<String, String>();
    private Map<String, HttpCookie> cookies = new HashMap<String, HttpCookie>();
    private InputStream inputStream;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, HttpCookie> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, HttpCookie> cookies) {
        this.cookies = cookies;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}
