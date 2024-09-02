package com.example.tp1_moviles;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TraductorActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Palabra> mPalabra;

    public TraductorActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Palabra> getMPalabra() {
        if (mPalabra == null) {
            mPalabra = new MutableLiveData<>();
        }
        return mPalabra;
    }

    public void obtenerPalabra(Intent intent) {
        Bundle bundle = intent.getBundleExtra("palabra");
        if (bundle != null) {
            Palabra palabra = (Palabra) bundle.getSerializable("palabra");

            if (palabra != null) {
                mPalabra.setValue(palabra);
            }
        }
    }
}
