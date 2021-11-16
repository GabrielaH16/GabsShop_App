package sv.edu.catolica.gabsshopapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import sv.edu.catolica.gabsshopapp.R;
import sv.edu.catolica.gabsshopapp.fragments.HomeFragment;

public class Splash extends AppCompatActivity {

    Fragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        homeFragment = new HomeFragment();
        loadFragment(homeFragment);

    }

    private void loadFragment(Fragment homefragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homefragment);
        transaction.commit();
    }
}