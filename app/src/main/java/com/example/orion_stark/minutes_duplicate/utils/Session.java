package com.example.orion_stark.minutes_duplicate.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.orion_stark.minutes_duplicate.models.User;
import com.google.gson.Gson;

/**
 * Created by orionstark on 1/14/18.
 */

public class Session {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static Session session;
    private Context context;

    private final String PREFERENCE_NAME = "user_session";
    private final String LOGIN_KEY = "user.login";
    private final String USER_DATA_KEY = "user.get.data";

    private Session( Context context ) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public static Session getInstance( Context context ) {
        if ( session == null ) {
            session = new Session(context);
        }

        return session;
    }

    public void createSession( User user ) {
        editor.putBoolean(LOGIN_KEY, true);
        editor.putString(USER_DATA_KEY, new Gson().toJson(user));
        editor.commit();
    }

    public User getUserData() {
        return ( new Gson().fromJson(sharedPreferences.getString(USER_DATA_KEY, ""), User.class) );
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public void reCreateSession( User user ) {
        clearSession();
        createSession(user);
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(LOGIN_KEY, false);
    }

}
