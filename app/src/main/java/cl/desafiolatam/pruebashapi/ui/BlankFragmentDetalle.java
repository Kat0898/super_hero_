package cl.desafiolatam.pruebashapi.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import cl.desafiolatam.pruebashapi.R;
import cl.desafiolatam.pruebashapi.adapter.AdapterHero;
import cl.desafiolatam.pruebashapi.databinding.FragmentBlankDetalleBinding;
import cl.desafiolatam.pruebashapi.databinding.FragmentBlankListaBinding;
import cl.desafiolatam.pruebashapi.view.ViewModelHeres;


public class BlankFragmentDetalle extends Fragment {

    private FragmentBlankDetalleBinding binding;
    private ViewModelHeres viewModelHeres;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding = FragmentBlankDetalleBinding.inflate(inflater,container,false);
       viewModelHeres = new ViewModelProvider(getActivity()).get(ViewModelHeres.class);
       viewModelHeres.getResponseMutableLiveDataItem().observe(getViewLifecycleOwner(),responseItem -> {
           binding.tvAltura.setText(String.valueOf(responseItem.getAppearance().getHeight()));
           binding.tvcombate.setText(String.valueOf(responseItem.getPowerstats().getCombat()));
           binding.tvDurabilidad.setText(String.valueOf(responseItem.getPowerstats().getDurability()));
           binding.tvPoder.setText(String.valueOf(responseItem.getPowerstats().getPower()));
           binding.tvInteligencia.setText(String.valueOf(responseItem.getPowerstats().getIntelligence()));
           binding.tvVelocidad.setText(String.valueOf(responseItem.getPowerstats().getSpeed()));
           binding.tvNombreDetalle.setText(responseItem.getName());
           binding.tvNombreReal.setText(responseItem.getBiography().getAlignment());
           binding.tvFuerza.setText(String.valueOf(responseItem.getPowerstats().getStrength()));
           Picasso.get().load(responseItem.getImages().getLg()).into(binding.imgDetallate);



       });


       return binding.getRoot();
    }


}