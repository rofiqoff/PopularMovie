package apps.popularmovie.rofiqoff.com.popularmovie.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import apps.popularmovie.rofiqoff.com.popularmovie.R;
import apps.popularmovie.rofiqoff.com.popularmovie.adapter.SpinAdapter;
import apps.popularmovie.rofiqoff.com.popularmovie.fragment.PopularMovieFragment;
import apps.popularmovie.rofiqoff.com.popularmovie.fragment.TopRatedFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.spinner) Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        spinner.setAdapter(new SpinAdapter(
                toolbar.getContext(),
                new String[]{
                        "Most Popular",
                        "Most Rated"
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                Class fragmentClass = null;

//                fragment = new PopularMovieFragment();

                switch (position){
                    case 0:
                        fragment = new PopularMovieFragment();
//                        Intent intent0 = new Intent(MainActivity.this, fragment.getFragmentManager().getClass());
//                        Bundle bundle = new Bundle();
//                        bundle.putString("movie_kind", "popular");
//                        startActivity(intent0);
                        break;
                    case 1:
                        fragment = new TopRatedFragment();
//                        fragment = new PopularMovieFragment();
//                        Intent intent1 = new Intent(MainActivity.this, fragment.getFragmentManager().getClass());
//                        intent1.putExtra("movie_kind", "top_rated");
//                        startActivity(intent1);
                        break;
                    default:
                        fragment = new PopularMovieFragment();
//                        Intent intent = new Intent(MainActivity.this, fragment.getFragmentManager().getClass());
//                        intent.putExtra("movie_kind", "popular");
//                        startActivity(intent);
                        break;
                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
