package basiccalc.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private Button log_in, sing_up;
    private EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        log_in = (Button) findViewById(R.id.log_in);
        sing_up = (Button) findViewById(R.id.sign_up);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);

        log_in.setOnClickListener(this);
        sing_up.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_in:
                startActivity(new Intent(Register.this, Login.class));
                finish();
                break;
            case R.id.sign_up:
                registration();
                break;
            default:
                break;
        }
    }

    private void registration() {
        String _user = username.getText().toString();
        String _email = email.getText().toString();
        String _pass = password.getText().toString();
    }
}
