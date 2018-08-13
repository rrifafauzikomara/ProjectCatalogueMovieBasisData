package com.rifafauzi.example.projectcataloguemoviebasisdata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rifafauzi.example.projectcataloguemoviebasisdata.DetailMovieActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Entity.Favorite;
import com.rifafauzi.example.projectcataloguemoviebasisdata.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context context;
    private Cursor listFavorite;

    public FavoriteAdapter(Context context, Cursor listFavorite){
        this.context = context;
        this.listFavorite = listFavorite;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Favorite favorite = getItem(position);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185"+favorite.getPoster())
                .placeholder(R.drawable.img_default_bg)
                .into(holder.gmb);
        holder.judul.setText(favorite.getName());
        holder.desc.setText(favorite.getDescription());
        holder.tgl.setText(favorite.getDate());
        Log.e("DATE", ""+favorite.getDate());
    }

    @Override
    public int getItemCount() {
        if (listFavorite == null){
            return 0;
        }
        return listFavorite.getCount();
    }

    private Favorite getItem(int position){
        if (!listFavorite.moveToPosition(position)) {
            throw new IllegalStateException("Position invalid");
        }
        return new Favorite(listFavorite);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView gmb;
        private TextView judul, tgl, desc;

        public ViewHolder(View itemView) {
            super(itemView);

            gmb = itemView.findViewById(R.id.movie_poster);
            judul = itemView.findViewById(R.id.movie_name);
            desc = itemView.findViewById(R.id.movie_desc);
            tgl = itemView.findViewById(R.id.movie_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mPosition = getLayoutPosition();
                    Favorite favorite = getItem(mPosition);

                    Intent i = new Intent(context, DetailMovieActivity.class);
                    i.putExtra("title", favorite.getName());
                    i.putExtra("poster_path", favorite.getPoster());
                    i.putExtra("overview", favorite.getDescription());
                    i.putExtra("release_date", favorite.getDate());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });
        }
    }

}