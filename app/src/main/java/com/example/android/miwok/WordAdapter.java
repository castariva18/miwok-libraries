package com.example.android.miwok;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Word> mData;
    private int mBackground;

    WordAdapter(Context context, ArrayList<Word> data, int colorResId) {
        this.mContext = context;
        this.mData = data;
        this.mBackground = ResourcesCompat.getColor(
                context.getResources(), colorResId, context.getTheme());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.list_item, parent, false);
        view.setBackgroundColor(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = mData.get(position);
        holder.miwokTextView.setText(word.getMiwokWord());
        holder.defaultTextView.setText(word.getDefaultWord());
        if (word.hasImage()) {
            holder.imageView.setVisibility(View.VISIBLE);
            Picasso.get().load("http://dif.indraazimi.com/miwok/" + word.getImage()).into(holder.imageView);
           // TODO holder.imageView.setImageResource(word.getImageResId());
        }
        else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView miwokTextView;
        final TextView defaultTextView;
        final ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            miwokTextView = itemView.findViewById(R.id.miwok_textview);
            defaultTextView = itemView.findViewById(R.id.default_textview);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setClickable(true);
            itemView.setFocusable(true);
        }
    }

}
