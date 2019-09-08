package th.ac.su.sc.midterm07600613;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button loginButton = findViewById(R.id.button3);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailEditText = findViewById(R.id.editText);
                EditText passwordEditText = findViewById(R.id.editText4);

                String inputEmail = emailEditText.getText().toString();
                String inputPassword = passwordEditText.getText().toString();

                Auth auth = new Auth(inputEmail,inputPassword);

                if(auth.check() == 1){
                    Toast.makeText(login.this,getString(R.string.welcome)+" "+getString(R.string.name_t), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, profile.class);
                    startActivity(i);
                }
                else if(auth.check() == 2){
                    Toast.makeText(login.this,getString(R.string.welcome)+" "+getString(R.string.name_s), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, profile2.class);
                    startActivity(i);
                }
                else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(login.this);
                    dialog.setTitle("Error");
                    dialog.setMessage(getString(R.string.fail));
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                    //Toast.makeText(login.this,"Not ok",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public class Auth {
        private static final String tEMAIL = "aaa";
        private static final String tPASSWORD = "111";
        private static final String sEMAIL = "bbb";
        private static final String sPASSWORD = "222";

        private String mEmail;
        private String mPassword;

        public Auth(String Email, String Password) {
            this.mEmail = Email;
            this.mPassword = Password;
        }

        public int check(){
            if(mEmail.equals(tEMAIL) && mPassword.equals(tPASSWORD)){
                return 1;
            }
            else if(mEmail.equals(sEMAIL) && mPassword.equals(sPASSWORD)){
                return 2;
            }
            else{
                return 0;
            }
        }
    }
}

