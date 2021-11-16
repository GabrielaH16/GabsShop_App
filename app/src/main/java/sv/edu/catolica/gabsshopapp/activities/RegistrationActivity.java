package sv.edu.catolica.gabsshopapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import sv.edu.catolica.gabsshopapp.R;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, email, password;
    private FirebaseAuth mAuth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(RegistrationActivity.this, Splash.class));
            finish();

        }
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        sharedPreferences= getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime=sharedPreferences.getBoolean("firstTime",true);
        if (isFirstTime){
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();

            Intent intent= new Intent(RegistrationActivity.this,OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void singup(View view) {
        name.setError(null);
        password.setError(null);
        email.setError(null);
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (TextUtils.isEmpty(userName)) {

            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
            name.setError("Ingrese un valor en el campo");
            return;

        }

        if (TextUtils.isEmpty(userEmail)) {

            Toast.makeText(this, "Ingresa un Email", Toast.LENGTH_SHORT).show();
            email.setError("Ingrese un valor en el campo");
            return;
        }
        if (TextUtils.isEmpty(userPassword)) {

            Toast.makeText(this, "Ingresa un Password", Toast.LENGTH_SHORT).show();
            password.setError("Ingrese un valor en el campo");
            return;

        }
        if (password.length() < 6) {
            Toast.makeText(this, "Password muy corta ingrese al menos 7 digitos", Toast.LENGTH_SHORT).show();
            return;

        }
        mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this,Splash.class));
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Registro Fallido" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        //startActivity(new Intent(RegistrationActivity.this,MainActivity.class));

    }

    public void singin(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}