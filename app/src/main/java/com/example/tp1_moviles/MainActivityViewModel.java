package com.example.tp1_moviles;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.Console;
import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private ArrayList<Palabra> palabras;
    private MutableLiveData<String> mMensaje;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public void cargarPalabras() {
        palabras = new ArrayList<>();
        palabras.add(new Palabra("lapicera", "Pen", R.drawable.lapicera));
        palabras.add(new Palabra("lapiz", "Pencil", R.drawable.lapiz));
        palabras.add(new Palabra("mochila", "Backpack", R.drawable.mochila));
        palabras.add(new Palabra("regla", "Rule", R.drawable.regla));
        palabras.add(new Palabra("tijera", "Scissor", R.drawable.tijera));
    }

    public void traducirPalabra(String palabra) {
        if (!palabra.isEmpty())
        {
            for (Palabra item : palabras) {
                if (item.getEspanol().equals(palabra)) {
                    Intent intent = new Intent(getApplication(), TraductorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("palabra", item);
                    intent.putExtra("palabra",bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    getApplication().startActivity(intent);
                    mMensaje.setValue("Redirigiendo...");
                    break;

                } else {
                    mMensaje.setValue("La palabra no se encuentra en el diccionario.");
                }
            }
        } else {
            mMensaje.setValue("Pon una palabra para traducir.");
        }
    }
}
