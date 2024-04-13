package com.moviles.tp4.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private  MutableLiveData<String> mText;
    private  MutableLiveData<Intent> mNumero;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getText() {

        if(mText == null){
            mText = new MutableLiveData<>();
        }

        return mText;
    }

    public MutableLiveData<Intent> getmNumero() {
        if(mNumero == null){
            mNumero = new MutableLiveData<>();
        }
        return mNumero;
    }

    public void hacerLLamada(String numero){

     if(numero == null || numero.isEmpty()) {
         String mensaje = "Numero Incorrecto";
         mText.setValue(mensaje);

     }else{
         Intent intentLlamada = new Intent(Intent.ACTION_CALL);
         intentLlamada.setData(Uri.parse("tel:" + numero));
         mNumero.setValue(intentLlamada);

     }


    }
}