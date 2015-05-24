package com.mobintum.maincity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobintum.maincity.R;
import com.mobintum.maincity.models.City;
import com.squareup.picasso.Picasso;

public class CityDetailFragment extends Fragment {

    private static final String ARG_PARAM_CITY = "paramCity";
    private City city;
    private SupportMapFragment supportMapFragment;
    private GoogleMap gMap;



    public static CityDetailFragment newInstance(City city) {
        CityDetailFragment fragment = new CityDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    public CityDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.city = (City) getArguments().getSerializable(ARG_PARAM_CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_detail, container, false);
        FragmentManager fragmentManager = getChildFragmentManager();
        supportMapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        gMap = supportMapFragment.getMap();
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        ImageView imgCity = (ImageView) view.findViewById(R.id.imgCity);

        txtTitle.setText(city.getNameCity());

        Picasso.with(getActivity()).load(city.getPictureUrl()).into(imgCity);

        setLocation();
        return view;
    }

    public void setLocation(){
        gMap.addMarker((new MarkerOptions().position(new LatLng(city.getLatitude(),city.getLongitude()))).title(city.getNameCity()));
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(city.getLatitude(),city.getLongitude()),10));

    }




}
