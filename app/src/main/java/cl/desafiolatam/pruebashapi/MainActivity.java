package cl.desafiolatam.pruebashapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import cl.desafiolatam.pruebashapi.databinding.ActivityMainBinding;
import cl.desafiolatam.pruebashapi.view.ViewModelHeres;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewModelHeres viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(ViewModelHeres.class);


        viewModel.llamarApi();

    }
}