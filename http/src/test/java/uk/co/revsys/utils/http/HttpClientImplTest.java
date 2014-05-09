
package uk.co.revsys.utils.http;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HttpClientImplTest {

    public HttpClientImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

	@Test
	public void testInvoke_Get() throws Exception {
		String url = "http://httpbin.org/get";
		HttpRequest request = new HttpRequest(url);
		request.getHeaders().put("Testheader", "value1");
		HttpClientImpl httpClient = new HttpClientImpl();
		HttpResponse response = httpClient.invoke(request);
		assertEquals("application/json", response.getContentType());
		String responseBody = IOUtils.toString(response.getInputStream());
		JSONObject json = new JSONObject(responseBody);
		assertEquals(url, json.getString("url"));
		assertEquals("value1", json.getJSONObject("headers").getString("Testheader"));
	}
	
	@Test
	public void testInvoke_Post() throws Exception {
		String url = "http://httpbin.org/post";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("param1", "value1");
		HttpRequest request = HttpRequest.POST(url, parameters);
		request.getHeaders().put("Testheader", "value1");
		HttpClientImpl httpClient = new HttpClientImpl();
		HttpResponse response = httpClient.invoke(request);
		assertEquals("application/json", response.getContentType());
		String responseBody = IOUtils.toString(response.getInputStream());
		System.out.println("responseBody = " + responseBody);
		JSONObject json = new JSONObject(responseBody);
		assertEquals(url, json.getString("url"));
		assertEquals("value1", json.getJSONObject("headers").getString("Testheader"));
		assertEquals("value1", json.getJSONObject("form").getString("param1"));
	}

}