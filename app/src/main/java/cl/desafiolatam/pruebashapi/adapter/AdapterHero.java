package cl.desafiolatam.pruebashapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.pruebashapi.R;

import cl.desafiolatam.pruebashapi.databinding.ItemHeroListBinding;
import cl.desafiolatam.pruebashapi.modelo.ResponseItem;

public class AdapterHero extends  RecyclerView.Adapter<AdapterHero.CustomViewHolder> {



   private List<ResponseItem> responseList = new ArrayList<>();

    private MiOnClickListener listener;

    public void setLista(List<ResponseItem> responseList){
        this.responseList = responseList;
        notifyDataSetChanged();
    }






    public void setListener(MiOnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(responseList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
        public ItemHeroListBinding binding;
        public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemHeroListBinding.bind(itemView);





    }

        public void bindData(ResponseItem responseH){

            binding.tvNombreSUPERList.setText(responseH.getName());
            Picasso.get().load(responseH.getImages().getSm()).into(binding.imgvSuperherolist);

            itemView.setOnClickListener(V->{
                listener.onClickListener(responseH);

            });


        }
    }

    public interface MiOnClickListener{
        void onClickListener(ResponseItem responseH);
    }
















}
