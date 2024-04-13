package com.moviles.tp4.ui;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.moviles.tp4.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel  extends AndroidViewModel {

    private MutableLiveData<Boolean> mutable;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getmutable(){
        if(mutable == null){
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    public void VerificarUsuario(Usuario usuarioLogeado){

        Usuario u1 = new Usuario("dario@gmail.com","1234");


        if(usuarioLogeado.getClave().equals(u1.getClave()) && usuarioLogeado.getEmail().equals(u1.getEmail())){
            mutable.setValue(true);
        }else{
            Toast.makeText(getApplication(), "Usuario o clave incorrecta", Toast.LENGTH_SHORT).show();
        }

    }
}
