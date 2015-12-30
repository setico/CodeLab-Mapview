package org.gdg_lome.codelab_mapview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by setico on 23/12/15.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.map_container, new MapFragment()).commit();
    }


}


