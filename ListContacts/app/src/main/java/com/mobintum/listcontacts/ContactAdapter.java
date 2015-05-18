package com.mobintum.listcontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * Created by Rick on 18/05/15.
 *
 */
public class ContactAdapter extends ArrayAdapter {

    private ArrayList<Contact> contacts;
    private Context context;
    private LayoutInflater inflater;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.context = context;
        this.contacts = contacts;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_list_contact, parent,false);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.imgProfile = (RoundedImageView) convertView.findViewById(R.id.imgProfile);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contacts.get(position);
        holder.txtName.setText(contact.getName());
        holder.imgProfile.setImageDrawable(context.getResources().getDrawable(contact.getPhoto()));
        return convertView;
    }

    private class ViewHolder{
        TextView txtName;
        RoundedImageView imgProfile;

    }
}
