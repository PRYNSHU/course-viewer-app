package com.example.myfbase_crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder> {

    private ArrayList<courseModal> courseModalsarraylist;
    private Context context;
    private courseClickInterface courseClickInterface;
    int lastPos = -1;

    public courseAdapter(ArrayList<courseModal> courseModalsarraylist, Context context, courseAdapter.courseClickInterface courseClickInterface) {
        this.courseModalsarraylist = courseModalsarraylist;
        this.context = context;
        this.courseClickInterface = courseClickInterface;
    }

    @NonNull
    @Override
    public courseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_format , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull courseAdapter.ViewHolder holder, int position) {

        courseModal courseModal = courseModalsarraylist.get(position);
        holder.crsName.setText(courseModal.getCoursename());
        holder.crsPrice.setText(courseModal.getCourseprice());

        Picasso.get().load(courseModal.getImglink()).into(holder.imgview);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseClickInterface.OncourseClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseModalsarraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView crsName , crsPrice;
        private ImageView imgview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            crsName = itemView.findViewById(R.id.crsName);
            crsPrice =itemView.findViewById(R.id.crsprice);
            imgview  =itemView.findViewById(R.id.imgview);

        }
    }

    public interface courseClickInterface{
        void OncourseClick(int lastPos);
    }
}
