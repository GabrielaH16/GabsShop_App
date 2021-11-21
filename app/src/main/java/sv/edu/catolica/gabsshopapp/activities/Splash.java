package sv.edu.catolica.gabsshopapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import sv.edu.catolica.gabsshopapp.R;
import sv.edu.catolica.gabsshopapp.fragments.HomeFragment;

public class Splash extends AppCompatActivity {

    Fragment homeFragment;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        homeFragment = new HomeFragment();
        loadFragment(homeFragment);

    }

    private void loadFragment(Fragment homefragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container, homefragment);
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itInicio:
                Intent Home = new Intent(Splash.this, Splash.class);
                startActivity(Home);
                break;

            case R.id.itAcerca:
                Intent About = new Intent(Splash.this, Acerca_nosotros.class);
                startActivity(About);
                break;

            case R.id.itCategorias:
                Intent Categories = new Intent(Splash.this, CategoriesActivity.class);
                startActivity(Categories);
                break;

            case R.id.itSalir:
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                startActivity(intent);
                break;

            case R.id.menu_my_cart:
                Intent Carrito = new Intent(Splash.this, CartActivity.class);
                startActivity(Carrito);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}