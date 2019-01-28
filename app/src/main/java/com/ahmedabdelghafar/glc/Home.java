package com.ahmedabdelghafar.glc;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Home extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().hide();

        toolbar = (Toolbar) findViewById(R.id.toolbarss);
        setSupportActionBar(toolbar);


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mtoggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mtoggle);

        mDrawerLayout.addDrawerListener(mtoggle);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mtoggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_xx);
        View headerView = navigationView.inflateHeaderView(R.layout.header_toolbar);
        //navigationView.getMenu().findItem(menu1).setTextColor(Color.BLUE);
        Menu menu = navigationView.getMenu();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                if (item.isChecked()) {
                    item.setChecked(false);
                    //Toast.makeText(menu_m.this, "محاولة 1", Toast.LENGTH_LONG).show();

                } else {
                    item.setChecked(true);
                    //Toast.makeText(menu_m.this, "محاولة 2", Toast.LENGTH_LONG).show();
                }

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

            return true;
        }


    });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        assert drawer != null;
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        assert navigationView != null;
//        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
