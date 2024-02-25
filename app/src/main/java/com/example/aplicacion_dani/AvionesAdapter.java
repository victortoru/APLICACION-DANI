package com.example.aplicacion_dani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AvionesAdapter extends RecyclerView.Adapter<AvionesAdapter.AvionViewHolder> {

    private List<AvionItem> avionItemList;
    private Context context;

    public AvionesAdapter(List<AvionItem> avionItemList) {
        this.avionItemList = avionItemList;
    }

    @NonNull
    @Override
    public AvionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avion, parent, false);
        return new AvionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvionViewHolder holder, int position) {
        AvionItem avionItem = avionItemList.get(position);
        holder.textView.setText(avionItem.getRuta());
    }

    @Override
    public int getItemCount() {
        return avionItemList.size();
    }

    public static class AvionViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AvionViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textRuta);
        }
    }
}
