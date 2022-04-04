package cl.desafiolatam.pruebashapi.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import cl.desafiolatam.pruebashapi.R;
import cl.desafiolatam.pruebashapi.adapter.AdapterHero;
import cl.desafiolatam.pruebashapi.cliente.ClienteRetrofit;
import cl.desafiolatam.pruebashapi.databinding.FragmentBlankListaBinding;
import cl.desafiolatam.pruebashapi.modelo.ResponseItem;
import cl.desafiolatam.pruebashapi.utilidad.ServicioRespuesta;
import cl.desafiolatam.pruebashapi.view.ViewModelHeres;
import retrofit2.Call;
import retrofit2.Callback;

public class BlankFragmentLista extends Fragment {

    private FragmentBlankListaBinding binding;
    private AdapterHero adapterHero;
    private ViewModelHeres viewModelHeres;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBlankListaBinding.inflate(inflater,container,false);
        viewModelHeres = new ViewModelProvider(getActivity()).get(ViewModelHeres.class);

        return  binding.getRoot();


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterHero = new AdapterHero();
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        binding.rvsuperhero.setAdapter(adapterHero);
        binding.rvsuperhero.setLayoutManager(manager);

        adapterHero.setListener(new AdapterHero.MiOnClickListener() {
            @Override
            public void onClickListener(ResponseItem responseH) {
                viewModelHeres.viewHERES(responseH);
                Navigation.findNavController(getView()).navigate(R.id.action_blankFragmentLista2_to_blankFragmentDetalle2);

            }
        });

        viewModelHeres.getResponseMutableLiveData().observe(getViewLifecycleOwner(),responseItem ->
        {Log.i("superH",responseItem.toString());
            adapterHero.setLista(responseItem);

        });

    }


}