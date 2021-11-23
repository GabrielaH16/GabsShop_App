package sv.edu.catolica.gabsshopapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import sv.edu.catolica.gabsshopapp.R;
import sv.edu.catolica.gabsshopapp.models.GymModels;

public class GymAdapter extends RecyclerView.Adapter<GymAdapter.ViewHolder> {
    private Context context;
    private List<GymModels>list;

    public GymAdapter(Context context, List<GymModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageGym);
        holder.nameGym.setText(list.get(position).getName());
        holder.priceGym.setText(String.valueOf(list.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageGym;
        TextView nameGym, priceGym;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageGym =itemView.findViewById(R.id.gym_img);
            nameGym=itemView.findViewById(R.id.gym_name);
            priceGym=itemView.findViewById(R.id.gym_price);
        }
    }
}
