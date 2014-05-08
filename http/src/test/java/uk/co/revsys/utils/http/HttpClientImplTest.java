
package uk.co.revsys.utils.http;

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

	/**
	 * Test of invoke method, of class HttpClientImpl.
	 */
	@Test
	public void testInvoke() throws Exception {
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

}