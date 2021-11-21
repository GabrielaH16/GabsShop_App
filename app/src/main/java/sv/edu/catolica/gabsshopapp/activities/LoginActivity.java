package sv.edu.catolica.gabsshopapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();

        mAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

    }

    public void singIn(View view) {
        password.setError(null);
        email.setError(null);
        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

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
        mAuth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Logueo exitoso",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,Splash.class));
                        }else{
                            Toast.makeText(LoginActivity.this,"Logueo Fallido"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void singUp(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }
}