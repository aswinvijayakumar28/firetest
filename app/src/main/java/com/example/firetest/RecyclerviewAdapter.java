package com.example.firetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder>{

    List<Listdata> listdata;

    public RecyclerviewAdapter(List<Listdata> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        Listdata data = listdata.get(position);
        holder.vname.setText(data.getName());
       holder.vcount.setText(data.getCount());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vcount;

        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.vname);
           vcount = (TextView) itemView.findViewById(R.id.vcount);


        }
    }


}