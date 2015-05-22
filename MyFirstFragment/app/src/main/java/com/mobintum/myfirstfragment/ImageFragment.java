package com.mobintum.myfirstfragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class ImageFragment extends Fragment {

    private static final String ARG_ANIMAL = "paramAninal";
    private String animal;

    public static ImageFragment newInstance(String animal) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ANIMAL,animal);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.animal = getArguments().getString(ARG_ANIMAL);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ImageView imgAnimal = (ImageView) view.findViewById(R.id.imgAnimal);
        Toast.makeText(getActivity(),animal,Toast.LENGTH_SHORT).show();

        if(animal.equals("lion"))
            imgAnimal.setImageResource(R.mipmap.pic_lion);

        if(animal.equals("leopard"))
            imgAnimal.setImageResource(R.mipmap.pic_leopard);

        return view;
    }



}
