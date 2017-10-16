package com.massive.popmovie;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.massive.popmovie.Interfaces.ResponseCallBack;
import com.massive.popmovie.Utlis.Constant;
import com.massive.popmovie.Views.Fragments.GridFragment;
import com.massive.popmovie.model.Movie;

import java.util.ArrayList;


public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private ArrayList<Movie> mMovie;
    private ResponseCallBack callBack;
    private Context mContext;

    public GridAdapter(Context mcontext, ArrayList<Movie> arrayList, ResponseCallBack callBack) {
        this.mContext = mcontext;
        this.mMovie = arrayList;
        this.callBack = callBack;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridAdapter.ViewHolder holder, final int position) {
        GridFragment gridFragment = new GridFragment();
        if (gridFragment.scrollPosition != -1 || gridFragment.scrollPosition != 0)
            gridFragment.mRecyclerView.scrollToPosition(gridFragment.scrollPosition - 1);

        Glide.with(mContext)
                .load(Constant.POSTER_URL + mMovie.get(position).getPoster_path())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.OnSuccess(mMovie.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    private Movie getItem(int adapterPosition) {
        return mMovie.get(adapterPosition);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivMoviePoster);

        }
    }


}
