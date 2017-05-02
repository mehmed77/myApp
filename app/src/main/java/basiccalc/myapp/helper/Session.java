package basiccalc.myapp.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import basiccalc.myapp.Login;

/**
 * Created by Muxammad on 28.04.2017.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "myapp";

    private static final String IS_LOGIN = "IsLoggedIn";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_EMAIL = "email";

    public Session(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }


    public void createLogin(Integer id, String name, String email){
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(ctx, Login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(i);
        }
    }

    public User getUserDetails() {
        User user = new User();
        user.setId(prefs.getInt(KEY_ID, 0));
        user.setName(prefs.getString(KEY_NAME, null));
        user.setEmail(prefs.getString(KEY_EMAIL, null));
        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(ctx, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(i);
    }

    public boolean isLoggedIn(){
        return prefs.getBoolean(IS_LOGIN, false);
    }

}
