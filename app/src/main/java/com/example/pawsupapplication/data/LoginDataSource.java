package com.example.pawsupapplication.data;

import com.example.pawsupapplication.data.model.LoggedInUser;

import java.io.IOException;

import java.util.HashMap;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 * @author Android Studio, Wader
 * @version 1.1
 * @since Oct 1st 2021
 */
public class LoginDataSource {

    HashMap<String, String> testData = new HashMap<>();

    public Result<LoggedInUser> login(String username, String password) {
        LoggedInUser currentUser;
        /**
         * Currently employs a hashmap to store mock data for authentication purposes.
         */
        testData.put("Testbot1@inbox.com", "Aa12345!");
        testData.put("Testbot2@mail.ca", "12345Aa!");
        testData.put("Testbot3@gmail.com", "yY!12345");
        testData.put("Testbot4@mail.ca", "!aGoodTime1");
        testData.put("Testbot5@inbox.com", "Yb567411!");
        // Mock Data ends here.
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