package com.example.v_lihang01.mydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<String> mList;
    private String[] mArName;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public MyAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<String>();
        mArName = context.getResources().getStringArray(R.array.ar_name);
        for (String str : mArName) {
            mList.add(str);
        }
    }

    public void setOnItemClickListener (OnItemClickListener l) {
        mOnItemClickListener = l;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_view, parent,false);
        MyHolder myHolder = new MyHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, (int)v.getTag());
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyHolder)holder).tv.setText(mList.get(position));
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static interface OnItemClickListener {

        void onItemClick(View view, int position);
    }


    class MyHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public MyHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.tv);

        }
    }
}

