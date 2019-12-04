package mk.codeacademy.exibitioncentermatka.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.interfaces.ExponateListener;
import mk.codeacademy.exibitioncentermatka.models.Exponate;


public class ExponateAdapter  extends RecyclerView.Adapter<ExponateAdapter.ExponateViewHolder> {

    ArrayList<Exponate> data;
    LayoutInflater inflater;
    Context context;
    ExponateListener listener;

    public ExponateAdapter(Context context , ArrayList<Exponate> data ,ExponateListener listener){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExponateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.exponate_item , parent , false);
        return new ExponateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExponateViewHolder holder, int position) {
        Exponate exponate = data.get(position);
        holder.title.setText(exponate.getTitle());

        String mDrawableName = exponate.getImages().get(0);
        int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
        holder.imageView.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ExponateViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;

        public ExponateViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.exponate_image);
            title = itemView.findViewById(R.id.exponate_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        listener.viewExponate(data.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
