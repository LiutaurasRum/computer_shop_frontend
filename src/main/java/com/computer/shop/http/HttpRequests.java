package com.computer.shop.http;

import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequests {
    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String ACCEPT = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-type";

    private String baseAddress;

    public HttpRequests(final String address, final String port) {
        baseAddress = buildBaseAddress(address, port);
    }


//    public String get(final String address) {
//        String response = null;
//        try {
//            URL url = new URL( baseAddress + address);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod(GET);
//            conn.setRequestProperty(ACCEPT, APPLICATION_JSON);
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException(FAILED + conn.getResponseCode());
//            }
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//            response = br.readLine();
//            conn.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return response;
//    }

    public String post(final String address, final String body) {
        String response;

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(baseAddress + address);
        httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            response = getResponse(httpClient.execute(httpPost));
        } catch (Exception e) {
            handleConnectionError();
            throw new RuntimeException(e);
        }

        return response;
    }

    private String buildBaseAddress(final String address, final String port) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(address);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    private String getResponse(final HttpResponse response) {
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void handleConnectionError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Timed out");
        alert.setContentText("Error making request to server!");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
