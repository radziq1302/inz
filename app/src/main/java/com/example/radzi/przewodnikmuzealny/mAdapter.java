package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

/**
 * Created by radzi on 2017-05-30.
 */

public class mAdapter extends RecyclerView.Adapter<mAdapter.NumberViewHolder> {
    private static final String TAG = mAdapter.class.getSimpleName();

    private int mNumberItems; // ile widokow jest dozwolone
    final private listItemClickListener mOnClickListener;
    private ArrayList<postLogExChoice.placowka> karmie_recyclerview = new ArrayList<>();
    public interface listItemClickListener {
        void onListItemClick (int clickedItemIndex);
    }

    // konstruktor !!!!!!!!!!!!!!!!!!!!!!!!!!!
    public mAdapter (ArrayList<postLogExChoice.placowka> number, listItemClickListener listener){
        //mNumberItems = number;
        karmie_recyclerview = number;
        mOnClickListener = listener;
    }
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.activity_list_ex;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder (view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        postLogExChoice.placowka placowka = karmie_recyclerview.get(position);
        ((NumberViewHolder) holder).element_listy.setText(placowka.getNazwa());
        //holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return karmie_recyclerview.size();
        //return mNumberItems;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        TextView element_listy;
        public NumberViewHolder(View itemView) {
            super(itemView);
            element_listy = (TextView) itemView.findViewById(R.id.ex_textview);
            itemView.setOnClickListener(this);

        }
        void bind(int listIndex) {
            element_listy.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
