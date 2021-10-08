package com.example.pawsupapplication.data;

import com.example.pawsupapplication.data.model.LoggedInUser;

import java.io.IOException;

import java.util.HashMap;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    HashMap<String, String> testData = new HashMap<>();

    public Result<LoggedInUser> login(String username, String password) {
        LoggedInUser currentUser;
        testData.put("Testbot1", "Aa1234567");
        testData.put("Testbot2", "1234567Aa");
        testData.put("Testbot3", "556677YYY");
        testData.put("Testbot4", "!aGoodTime1");
        testData.put("Testbot5", "YBHI567411!");
        boolean pass = false;
        try {
            // TODO: handle loggedInUser authentication
            if(testData.get(username) != null && testData.get(username).equals(password)) {
                pass = true;
            }
            if(pass) {
                currentUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                " " + username);
                return new Result.Success<>(currentUser);
            }
            return null;
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}