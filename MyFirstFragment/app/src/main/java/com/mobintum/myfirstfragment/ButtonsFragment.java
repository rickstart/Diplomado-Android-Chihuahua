package com.mobintum.myfirstfragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ButtonsFragment extends Fragment implements View.OnClickListener {


    private OnFragmentInteractionListener mListener;
    private Button btnLion, btnLeopard;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);
        btnLion = (Button) view.findViewById(R.id.btnLion);
        btnLeopard = (Button) view.findViewById(R.id.btnLeopard);

        btnLion.setOnClickListener(this);
        btnLeopard.setOnClickListener(this);
        return view;
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnLion:
                if(mListener != null)
                    mListener.onAnimalSelected("lion");

                break;

            case R.id.btnLeopard:
                if(mListener != null)
                    mListener.onAnimalSelected("leopard");

                break;
        }

    }


    public interface OnFragmentInteractionListener {

        public void onAnimalSelected(String name);

    }

}
