package com.mobintum.girlsapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobintum.girlsapp.R;
import com.mobintum.girlsapp.models.Girl;


public class GirlDetailFragment extends Fragment {

    private static final String ARG_PARAM_GIRL = "paramGirl";
    private Girl girl;
    private OnFragmentInteractionListener mListener;



    public static GirlDetailFragment newInstance(Girl girl) {
        GirlDetailFragment fragment = new GirlDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_GIRL,girl);
        fragment.setArguments(args);
        return fragment;
    }

    public GirlDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.girl = (Girl) getArguments().getSerializable(ARG_PARAM_GIRL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girl_detail, container, false);

        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        ImageButton btnSite = (ImageButton) view.findViewById(R.id.btnSite);

        btnSite.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoPage(girl.getUrlWeb());
            }
        });

        imgPhoto.setImageResource(girl.getPhoto());
        txtName.setText(girl.getName());

        return  view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        public void gotoPage(String url);

    }
}
