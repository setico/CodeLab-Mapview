package org.gdg_lome.codelab_mapview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by setico on 15/12/15.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

        public MapFragment() {
        }


    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootView;
        }



    private void setUpMap(GoogleMap map) {
     if (map != null) {

         try {
             map.setMyLocationEnabled(true);
             map.getUiSettings().setMyLocationButtonEnabled(true);
         }catch (SecurityException e){
             e.printStackTrace();
         }
         //Ajout d'un point sur le map
         map.addMarker(new MarkerOptions()
                         .title("Université de Lomé")
                                 .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                         //.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                         .position(new LatLng(new Double(6.175590), new Double(1.215105)))
         );

         //Ajout d'un clickListener sur map
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
                    @Override
                    public void onInfoWindowClick(final Marker marker){
                        if(marker.isVisible()){
                            Toast.makeText(getContext(),"Clique sur <université de lomé>",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        setUpMap(googleMap);
    }
}
