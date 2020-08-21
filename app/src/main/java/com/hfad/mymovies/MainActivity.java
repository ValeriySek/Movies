package com.hfad.mymovies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hfad.mymovies.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

        final BottomNavigationView navView = binding.bottomNavigationView;

        navController = Navigation.findNavController(this, R.id.nav_host);
        NavigationUI.setupWithNavController(navView, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                hideBottomAppBar(destination, navView);
            }
        });
    }

    private void hideBottomAppBar(NavDestination destination, BottomNavigationView navView){
        switch (destination.getId()){
            case R.id.main_fragment:
            case R.id.favourite_fragment:
            case R.id.search_fragment:
                navView.setVisibility(View.VISIBLE);
                break;
            default:
                navView.setVisibility(View.GONE);

        }
    }
}