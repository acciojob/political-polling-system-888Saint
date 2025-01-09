package com.driver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PoliticalPollingSystem {

    private static final String API_ENDPOINT = "https://example.com/api/vote";

    public void castVote(String party) {
    	//your code goes here
        HttpURLConnection connection = null;
        try{
            URL url = new URL(API_ENDPOINT);

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{\"party\": \"" + party + "\"}";

            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(jsonInputString);
                outputStream.flush();
            }

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Vote successfully recorded for party: " + party);
            } else {
                System.err.println("Failed to record vote. Server responded with code: " + responseCode);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while sending the vote: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Political Polling System!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PoliticalPollingSystem pollingSystem = new PoliticalPollingSystem();

        try {
            System.out.println("Please enter your preferred political party:");
            String party = reader.readLine();

            pollingSystem.castVote(party);
        } catch (IOException e) {
            System.err.println("Error while reading user input: " + e.getMessage());
        }
    }
}

