package com.rest.client;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class HTTPClient {

    //1st: GET call
    public CloseableHttpResponse getCall(String url) throws ClientProtocolException, IOException, ParseException {
        CloseableHttpClient httpClients = HttpClients.createDefault();
        HttpGet getCall = new HttpGet(url); // REST get Call
        CloseableHttpResponse response = httpClients.execute(getCall);
//
//        //A. Extracting the response
//        int statusCode = response.getCode();
//        System.out.println("Status Code is: " + statusCode);
//
//        //B. Getting the response JSON
//        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//        JSONObject responseJSON = new JSONObject(responseString);
//        System.out.println("API Response JSON: " + responseJSON);
//
//        //C. Getting Response Headers
//        Header[] responseHeaders = response.getHeaders();
//
//        HashMap<String, String> allHeaders = new HashMap<String, String>();
//
//        for (Header header : responseHeaders) {
//            allHeaders.put(header.getName(), header.getValue());
//        }
//        System.out.println("All headers are: " + allHeaders);
        return response;
    }

}
