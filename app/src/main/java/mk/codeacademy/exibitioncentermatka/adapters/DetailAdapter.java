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

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    ArrayList<String> data;
    LayoutInflater inflater;
    HistoryListener listener;
    Context context;

    public DetailAdapter(Context context , ArrayList<String> data , HistoryListener listener){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.top_rv_item , parent , false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {

        String mDrawableName = data.get(position);
        int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
        holder.imageView.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.top_image);
        }
    }
}
