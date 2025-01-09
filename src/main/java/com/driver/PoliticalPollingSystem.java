package com.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PoliticalPollingSystem {

    private static final String API_ENDPOINT = "https://example.com/api/vote";

    public void castVote(String party) {
    	//your code goes here
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

