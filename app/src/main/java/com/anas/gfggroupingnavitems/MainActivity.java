package com.anas.gfggroupingnavitems;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout layDL;
    NavigationView vNV;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layDL = findViewById(R.id.layDL);
        vNV = findViewById(R.id.vNV);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, layDL, toolbar, R.string.open_drawer, R.string.close_drawer);

        layDL.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            vNV.setCheckedItem(R.id.row_home);
        }
        NavClick();
    }

    private void NavClick() {
        vNV.setNavigationItemSelectedListener(item -> {
            Fragment frag = null;
            switch (item.getItemId()) {

                case R.id.row_home:
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_profile:
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_fav:
                    Toast.makeText(this, "Favourites", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_settings:
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_share:
                    Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_bugfix:
                    Toast.makeText(this, "Bug fix", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_suggestions:
                    Toast.makeText(this, "Suggestions", Toast.LENGTH_SHORT).show();
                    break;
            }
            layDL.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        Fragment currFrag = getSupportFragmentManager().findFragmentById(R.id.layFL);
        if (layDL.isDrawerOpen(GravityCompat.START)){
            layDL.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}