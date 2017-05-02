package basiccalc.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import basiccalc.myapp.helper.AlertDialogManager;
import basiccalc.myapp.helper.Session;

public class Login extends AppCompatActivity implements View.OnClickListener {
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private Session session;
    private Button log_in, sign_up;
    private EditText Email, Password;
    AlertDialogManager alertDialog;
    private String email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new Session(this);
        alertDialog = new AlertDialogManager();

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_SHORT).show();

        log_in = (Button) findViewById(R.id.log_in);
        sign_up = (Button) findViewById(R.id.sign_up);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);

        log_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);


        if (session.isLoggedIn()) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in:
                login();
                break;
            case R.id.sign_up:
                startActivity(new Intent(Login.this, Register.class));
                finish();
                break;
        }
    }

    private void login() {
        final String email = Email.getText().toString();
        final String password = Password.getText().toString();

        // Initialize  AsyncLogin() class with email and password
        new JSONTask().execute(email,password);

    }

    public class JSONTask extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(Login.this);
        HttpURLConnection connection;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;

            try {
                url = new URL("http://192.168.1.101/android/index.php");

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception";
            }

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.setRequestMethod("POST");

                connection.setDoInput(true);
                connection.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", params[0])
                        .appendQueryParameter("password", params[1]);

                String query = builder.build().getEncodedQuery();
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.close();
                writer.flush();
                os.close();
                connection.connect();
            } catch (IOException e1) {
                e1.printStackTrace();
                return "Exception";
            }

            try {
                int response_code = connection.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    if("true".equals(result.toString())){
                        session.createLogin(1,"Muhammad", params[0]);
                    }
                    return(result.toString());
                }else {
                    return("unsuccessful");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception";
            } finally {
                connection.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();
            if (result.equalsIgnoreCase("true")) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                Login.this.finish();

            } else if (result.equalsIgnoreCase("false")){

                Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("Exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(Login.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }
    }
}
