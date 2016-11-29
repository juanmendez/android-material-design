package info.juanmendez.md.befamiliar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.model.Landscape;
import info.juanmendez.md.befamiliar.service.LandscapeService;

/**
 * Created by Juan Mendez on 11/18/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    List<Landscape> landscapes;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<Landscape> data) {
        inflater = LayoutInflater.from(context);
        this.landscapes = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape current = landscapes.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return landscapes.size();
    }

    public void removeItem( int position ){
        landscapes.remove( position );
        /*notifyItemRemoved( position );
        notifyItemRangeChanged( position, landscapes.size() );*/
        notifyDataSetChanged();
    }

    public void addItem( int position, Landscape landscape ){
        landscapes.add( position, landscape );
        /*notifyItemInserted( position );
        notifyItemRangeChanged( position, landscapes.size() );*/
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title       = (TextView)  itemView.findViewById(R.id.tvTitle);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete   = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd      = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current = current;
        }

        public void setListeners(){

            imgAdd.setOnClickListener(view -> {
                addItem( position, LandscapeService.clone( current ));
            });

            imgDelete.setOnClickListener(view -> {
                removeItem( position );
            });
        }
    }
}
