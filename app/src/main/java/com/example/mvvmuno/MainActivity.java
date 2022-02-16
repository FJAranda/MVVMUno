package com.example.mvvmuno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mvvmuno.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavController navController;
    AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Seteo de la toolbar cómo actionbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        //Obtención del navController para la navegacion(nav_host fragment_container debe ser un fragment)
        //navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
        //Obtención del navController para la navegacion(NO IMPORTA LA CLASE DE NAV_HOST_FRAGMENT_CONTAINER)
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        navController = navHostFragment.getNavController();

        //Creacion de elementos de nivel superior de la navegacion
        Set<Integer> topLevelDestination = new HashSet<>();
        topLevelDestination.add(R.id.itemListFragment);
        topLevelDestination.add(R.id.categoryListFragment);

        //Seteo el NavigationUI con el navController
        NavigationUI.setupWithNavController(binding.navView, navController);
        //Enlazo la appbar con el drawerlayout
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestination).setOpenableLayout(binding.drawerLayout).build();
        //Enlazo la actionbar con el navvontroller y el drawerlayout
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}