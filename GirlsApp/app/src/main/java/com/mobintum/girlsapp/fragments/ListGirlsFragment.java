package com.mobintum.girlsapp.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.mobintum.girlsapp.R;
import com.mobintum.girlsapp.adapters.GirlsAdapter;
import com.mobintum.girlsapp.models.Girl;

import java.util.ArrayList;

public class ListGirlsFragment extends Fragment {

    private static final String ARG_PARAM_ARRAY = "paramArray";

    private ArrayList<Girl> girlsArray;

    private OnFragmentInteractionListener mListener;

    public static ListGirlsFragment newInstance(ArrayList<Girl> girlsArray) {
        ListGirlsFragment fragment = new ListGirlsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_ARRAY,girlsArray);
        fragment.setArguments(args);
        return fragment;
    }

    public ListGirlsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.girlsArray = (ArrayList<Girl>) getArguments().getSerializable(ARG_PARAM_ARRAY);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_girls, container, false);
        ListView listGirls = (ListView) view.findViewById(R.id.listGirls);
        GirlsAdapter adapter = new GirlsAdapter(getActivity(),android.R.layout.simple_list_item_1,girlsArray);
        listGirls.setAdapter(adapter);
        listGirls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mListener.onGirlSelected(girlsArray.get(position));
            }
        });

        return view;
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
        public void onGirlSelected(Girl girl);

    }

}
