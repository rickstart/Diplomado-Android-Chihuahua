package com.mobintum.girlsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mobintum.girlsapp.models.Girl;

import java.util.ArrayList;

/**
 * Created by Rick on 22/05/15.
 */
public class GirlsAdapter extends ArrayAdapter {

    private ArrayList<Girl> girlsArray;
    private Context context;
    private LayoutInflater inflater;

    public GirlsAdapter(Context context, int resource, ArrayList<Girl> girlsArray) {
        super(context, resource, girlsArray);
        this.girlsArray = girlsArray;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else{

            holder = (ViewHolder) convertView.getTag();
        }

        Girl girl = girlsArray.get(position);
        holder.text1.setText(girl.getName());
        holder.text1.setTextColor(context.getResources().getColor(android.R.color.holo_blue_bright));

        return convertView;
    }

    class ViewHolder{

        TextView text1;
    }

}
