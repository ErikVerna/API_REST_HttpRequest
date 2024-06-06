package com.rest.test;

import com.rest.base.TestBase;
import com.rest.client.HTTPClient;
import com.rest.utils.TestUtils;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;

public class TestGetCall extends TestBase {

    TestBase testBase;
    HTTPClient driver;
    String apiURI;
    CloseableHttpResponse apiResponse;


    @BeforeTest
    public void setUp() {
        testBase = new TestBase();
        String URL = prop.getProperty("URI");
        String pathParm = prop.getProperty("ServiceURI");

        apiURI = URL + pathParm;
    }

    @Test
    public void testGetCall() throws IOException, ParseException {
        driver = new HTTPClient();
        apiResponse = driver.getCall(apiURI);
        Assert.assertEquals(apiResponse.getCode(), ResponseCode_200);
    }

    @Test
    public void testGetCallResponse() throws IOException, ParseException {
        driver = new HTTPClient();
        apiResponse = driver.getCall(apiURI);
        String responseString = EntityUtils.toString(apiResponse.getEntity(), "UTF-8");
        JSONObject responseJSON = new JSONObject(responseString);
        String responseValue = TestUtils.getValueByJPath(responseJSON, "/per_page");
        Assert.assertEquals(responseValue, "6");

        Assert.assertEquals(TestUtils.getValueByJPath(responseJSON, "/data[0]/first_name"),"George");
        Assert.assertEquals(TestUtils.getValueByJPath(responseJSON, "/data[1]/first_name"),"Janet");
        Assert.assertEquals(TestUtils.getValueByJPath(responseJSON, "/data[2]/id"),"3");
        Assert.assertEquals(TestUtils.getValueByJPath(responseJSON, "/data[3]/email"),"eve.holt@reqres.in");
    }

}
