package sv.edu.catolica.gabsshopapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import sv.edu.catolica.gabsshopapp.R;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
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
                Intent Home = new Intent(CategoriesActivity.this, Splash.class);
                startActivity(Home);
                break;

            case R.id.itAcerca:
                Intent About = new Intent(CategoriesActivity.this, Acerca_nosotros.class);
                startActivity(About);
                break;

            case R.id.itSalir:
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fnGoToBkinis(View view) {
        Intent Bikinis = new Intent(CategoriesActivity.this, BikinisActivity.class);
        startActivity(Bikinis);
    }

    public void fnGoToAccesorios(View view) {
        Intent Accesorios = new Intent(CategoriesActivity.this, AccesoriosActivity.class);
        startActivity(Accesorios);
    }

    public void fnGoToBlusas(View view) {
        Intent Blusas = new Intent(CategoriesActivity.this, BlusasActivity.class);
        startActivity(Blusas);
    }

    public void fnGoToDepo(View view) {
        Intent Depo = new Intent(CategoriesActivity.this, DepoActivity.class);
        startActivity(Depo);
    }
}