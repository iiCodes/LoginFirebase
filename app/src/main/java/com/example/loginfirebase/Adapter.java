package com.example.loginfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.view>{

    Context context;
    ArrayList <userdata> list;

    public Adapter(Context context, ArrayList<userdata> list) {
        this.context = context;
        this.list = list;
    }

    public view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new view(v);
    }

    @Override
    public void onBindViewHolder(@NonNull view holder, int position) {

        userdata data=list.get(position);
        holder.name.setText(data.getName());
        holder.pass.setText(data.getPassword());
        holder.email.setText(data.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class view extends RecyclerView.ViewHolder{

        TextView name,pass,email;

    public view(@NonNull View itemView) {
        super(itemView);


        name=itemView.findViewById(R.id.username);
        pass=itemView.findViewById(R.id.password);
        email=itemView.findViewById(R.id.useremail);


    }
}
}
