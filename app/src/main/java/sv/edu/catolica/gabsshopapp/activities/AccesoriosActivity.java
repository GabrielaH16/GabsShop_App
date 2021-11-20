package sv.edu.catolica.gabsshopapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import sv.edu.catolica.gabsshopapp.R;

public class AccesoriosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesorios);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itInicio:
                Intent Home = new Intent(AccesoriosActivity.this, Splash.class);
                startActivity(Home);
                break;

            case R.id.itAcerca:
                Intent About = new Intent(AccesoriosActivity.this, Acerca_nosotros.class);
                startActivity(About);
                break;

            case R.id.itCategorias:
                Intent Categories = new Intent(AccesoriosActivity.this, CategoriesActivity.class);
                startActivity(Categories);
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
}