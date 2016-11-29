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

/**
 * Created by Juan Mendez on 11/18/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    List<Landscape> mData;
    private LayoutInflater inflater;

    private static final int PRIME_ROW = 0;
    private static final int NON_PRIME_ROW = 1;

    public RecyclerAdapter(Context context, List<Landscape> data) {
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {  // Create the Prime and Non-Prime row Layouts

            case PRIME_ROW:

                ViewGroup primeRow = (ViewGroup) inflater.inflate(R.layout.list_item_prime, parent, false);
                return new MyViewHolder_PRIME(primeRow);

            case NON_PRIME_ROW:

                ViewGroup nonPrimeRow = (ViewGroup) inflater.inflate(R.layout.list_item_not_prime, parent, false);
                return new MyViewHolder_NON_PRIME(nonPrimeRow);

            default:

                ViewGroup defaultRow = (ViewGroup) inflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder_NON_PRIME holderDefault = new MyViewHolder_NON_PRIME(defaultRow);
                return holderDefault;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape current = mData.get(position);

        switch (holder.getItemViewType()) {

            case PRIME_ROW:

                MyViewHolder_PRIME holder_prime = (MyViewHolder_PRIME) holder;
                holder_prime.setData(current);

                break;

            case NON_PRIME_ROW:

                MyViewHolder_NON_PRIME holder_not_prime = (MyViewHolder_NON_PRIME) holder;
                holder_not_prime.setData(current);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        Landscape landscape = mData.get(position);
        if (landscape.isPrime())
            return PRIME_ROW;
        else
            return NON_PRIME_ROW;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    // Holder class for PRIME rows
    public class MyViewHolder_PRIME extends MyViewHolder {

        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_PRIME(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgRowType = (ImageView) itemView.findViewById(R.id.img_row_prime);
        }

        public void setData(Landscape current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.prime);
        }
    }

    // Holder class for NON-PRIME rows
    public class MyViewHolder_NON_PRIME extends MyViewHolder {

        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_NON_PRIME(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgRowType = (ImageView) itemView.findViewById(R.id.img_row_not_prime);
        }

        public void setData(Landscape current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.not_prime);
        }
    }
}
