package com.adam.mydatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<contact> {
    Context context;
    int resource;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent ,false  );

        TextView Name = (TextView) convertView.findViewById(R.id.Name);
        TextView nmabuer = (TextView) convertView.findViewById(R.id.nmabuer);

        contact currentcontact = getItem(position);
// TODO         contact currentcontact = (contact) getItem(position)
        Name.setText(currentcontact.getName());
        nmabuer.setText(String.valueOf(currentcontact.getPhone()));


        return  convertView;
//        return super.getView(position, convertView, parent);
    }
}
