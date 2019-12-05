package mk.codeacademy.exibitioncentermatka.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.interfaces.HistoryListener;
import mk.codeacademy.exibitioncentermatka.models.TopItem;

public class TopItemAdapter extends RecyclerView.Adapter<TopItemAdapter.HistoryViewHolder> {

    ArrayList<TopItem> data;
    LayoutInflater inflater;
    HistoryListener listener;

    public TopItemAdapter(Context context , ArrayList<TopItem> data , HistoryListener listener){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.top_rv_item, parent , false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        TopItem topItem = data.get(position);
        holder.imageView.setImageResource(topItem.getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.top_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.viewImages(getAdapterPosition());
                }
            });
        }
    }
}
