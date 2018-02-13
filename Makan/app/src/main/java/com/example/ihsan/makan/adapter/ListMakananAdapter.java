package com.example.ihsan.makan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ihsan.makan.R;
import com.example.ihsan.makan.helper.MyConstant;
import com.example.ihsan.makan.model.DataMakanan;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Blackswan on 12/6/2017.
 */

public class ListMakananAdapter extends RecyclerView.Adapter
        <ListMakananAdapter.MyViewHolder>{
Context c;
OnItemClicked clicked;

List<DataMakanan> dataMakananItems;
    public ListMakananAdapter(Context c, List<DataMakanan> listdatamakanan) {
        this.c=c;
        dataMakananItems=listdatamakanan;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(c).inflate(R.layout.tampilanlistmakanan,parent,false);
      MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txtnamamakanan.setText(dataMakananItems.get(position).getMakanan());
        Picasso.with(c).load(MyConstant.IMAGE_URL+dataMakananItems.get(position).getFotoMakanan().toString()).error(
                R.drawable.noimage
        ).placeholder(R.drawable.noimage).into(holder.imgmakanan);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataMakananItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imgmakanan;
    TextView txtnamamakanan;
        public MyViewHolder(View itemView) {
            super(itemView);
            imgmakanan = (ImageView)itemView.findViewById(R.id.imgmakanan);
            txtnamamakanan = (TextView) itemView.findViewById(R.id.txtmakanan);
        }
    }
    public interface OnItemClicked{
        void onItemClick(int position);
    }
    public void setOnClick(OnItemClicked onClick){
        clicked=onClick;
    }
}
