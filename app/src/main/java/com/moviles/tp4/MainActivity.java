package com.moviles.tp4;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import static  android.Manifest.permission.CALL_PHONE;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.moviles.tp4.databinding.ActivityMainBinding;
import com.moviles.tp4.modelo.Usuario;
import com.moviles.tp4.ui.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;

    private ServicioLlamada broadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pedirPermiso();
        registrarBroadcast();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getmutable().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                if(aBoolean){
                    startActivity(intent);
                }


            }
        });
        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =binding.etEmail.getText().toString();
                String clave = binding.etClave.getText().toString();

                Usuario usuarioLogeado = new Usuario(email,clave);
                mv.VerificarUsuario(usuarioLogeado);

            }
        });




    }

    private void pedirPermiso(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(CALL_PHONE)

                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE},1000);
        }
    }

    private void registrarBroadcast(){
        this.broadcast = new ServicioLlamada();
        registerReceiver(broadcast, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }
}