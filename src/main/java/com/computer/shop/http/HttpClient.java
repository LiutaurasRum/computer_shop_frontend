package com.computer.shop.http;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
    private String baseAddress;

    public HttpClient(final String address, final String port) {
        baseAddress = buildBaseAddress(address, port);
    }

    public String get(final String address) {
        String response = null;
        try {
            URL url = new URL( baseAddress + address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            response = br.readLine();
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
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
}
