package sv.edu.catolica.gabsshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText name,email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void singIn(View view) {
        name.setError(null);
        password.setError(null);
        email.setError(null);
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

        if (TextUtils.isEmpty(userName)){

            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
            name.setError("Ingrese un valor en el campo");
            return;

        }

        if (TextUtils.isEmpty(userEmail)){

            Toast.makeText(this, "Ingresa un Email", Toast.LENGTH_SHORT).show();
            email.setError("Ingrese un valor en el campo");
            return;
        }
        if (TextUtils.isEmpty(userPassword)){

            Toast.makeText(this, "Ingresa un Password", Toast.LENGTH_SHORT).show();
            password.setError("Ingrese un valor en el campo");
            return;

        }
        if (password.length()<6){
            Toast.makeText(this, "Password muy corta ingrese al menos 7 digitos", Toast.LENGTH_SHORT).show();
            return;

        }
    }

    public void singUp(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }
}