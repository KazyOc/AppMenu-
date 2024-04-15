package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frm_home;
    BottomNavigationView btm_navigation;

    InicioFragment fragment1 = new InicioFragment();
    PerfilFragment fragment2 = new PerfilFragment();
    NotificacionesFragment fragment3 = new NotificacionesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frm_home = findViewById(R.id.frm_home);
        btm_navigation = findViewById(R.id.btm_navigation);
        btm_navigation.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.naf_inicio) {
                    LoadFragment(fragment1);
                    return true;
                } else if (item.getItemId() == R.id.naf_perfil){
                    LoadFragment(fragment2);
                    return true;
                } else if (item.getItemId() == R.id.naf_notif) {
                    LoadFragment(fragment3);
                    return true;
                }
                return false;
            }
        });
    }
    public void LoadFragment (Fragment fr){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frm_home, fr);
        transaction.commit();
    }
}