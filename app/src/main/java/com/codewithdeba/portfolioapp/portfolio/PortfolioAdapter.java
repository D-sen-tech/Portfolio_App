package com.codewithdeba.portfolioapp.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codewithdeba.portfolioapp.R;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder> {

    List<PortfolioItem> mdata;
    PortfolioCallback listener;

    public PortfolioAdapter(List<PortfolioItem> mdata,PortfolioCallback listener) {
        this.mdata = mdata;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PortfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_portfolio,parent,false);

        return new PortfolioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHolder holder, int position) {

//        holder.tvPosition.setText(String.valueOf(position));

        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getImg()).into(holder.imgport);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class PortfolioViewHolder extends RecyclerView.ViewHolder{


//        TextView tvPosition;

        /* 1*/
        ImageView imgport;

        public PortfolioViewHolder(@NonNull View itemView) {
            super(itemView);

//            tvPosition = itemView.findViewById(R.id.item_port_text);
            imgport = itemView.findViewById(R.id.item_portfolio_img);

            itemView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                    listener.onPortfolioItemClick(getAdapterPosition());
                }

            });

        }
    }

}
