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

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.interfaces.VideoListener;
import mk.codeacademy.exibitioncentermatka.models.Video;

public class VideoAdapter  extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<Video> data;
    LayoutInflater inflater;
    VideoListener listener;
    Context context;

    public VideoAdapter(Context context , ArrayList<Video> data , VideoListener listener){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.video_item,parent , false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = data.get(position);
        holder.textView.setText(video.getTitle());
        String mDrawableName = video.getVideoImages().get(0);
        int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
        holder.imageView.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.video_title);
            imageView = itemView.findViewById(R.id.video_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null ) {
                        listener.videoSwitch(data.get(getAdapterPosition()));
                    }
                }
            });
        }
    }


}
