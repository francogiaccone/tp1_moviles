package com.example.tp1_moviles;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp1_moviles.databinding.ActivityTraductorBinding;

public class TraductorActivity extends AppCompatActivity {

    private TraductorActivityViewModel mv;
    private ActivityTraductorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraductorActivityViewModel.class);
        binding = ActivityTraductorBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        mv.getMPalabra().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.etPalabra.setText(palabra.getEnglish());
                binding.ivImagen.setImageResource(palabra.getIdImg());
            }
        });

        mv.obtenerPalabra(getIntent());
    }
}