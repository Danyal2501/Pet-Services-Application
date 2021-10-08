package com.example.pawsupapplication.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 * @author Android Studio, Wader
 * @version 1.1
 * @since Oct 1st 2021
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}