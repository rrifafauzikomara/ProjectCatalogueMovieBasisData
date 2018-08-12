package com.rifafauzi.example.projectcataloguemoviebasisdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rifafauzi.example.projectcataloguemoviebasisdata.Category.FavoriteActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Category.MostPopularActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Category.NowPlayingActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Category.TopRatedActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Category.UpComingActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.most_popular) {
            Intent most = new Intent(getApplicationContext(), MostPopularActivity.class);
            startActivity(most);
            Toast.makeText(getApplicationContext(), "Show Most Popular Movies", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.top_rated) {
            Intent top = new Intent(getApplicationContext(), TopRatedActivity.class);
            startActivity(top);
            Toast.makeText(getApplicationContext(), "Show Top Rated Movies", Toast.LENGTH_SHORT);
        } else if (id == R.id.now_playing) {
            Intent now = new Intent(getApplicationContext(), NowPlayingActivity.class);
            startActivity(now);
            Toast.makeText(getApplicationContext(), "Show Now Playing Movies", Toast.LENGTH_SHORT);
        } else if (id == R.id.upcoming) {
            Intent up = new Intent(getApplicationContext(), UpComingActivity.class);
            startActivity(up);
            Toast.makeText(getApplicationContext(), "Show Up Coming Movies", Toast.LENGTH_SHORT);
        } else if (id == R.id.favorite) {
            Intent fav = new Intent(getApplicationContext(), FavoriteActivity.class);
            startActivity(fav);
            Toast.makeText(getApplicationContext(), "Show Up Coming Movies", Toast.LENGTH_SHORT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
