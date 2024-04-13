package com.moviles.tp4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ServicioLlamada extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean modoWifi = intent.getBooleanExtra("connected", false);
        if(modoWifi){
            Intent intentLlamada = new Intent(Intent.ACTION_CALL );
            intentLlamada.setData(Uri.parse("tel:" + "2664553747"));
            intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentLlamada);

        }else{
            Toast.makeText(context, "Wifi Desactivado, No se realizo la llamada", Toast.LENGTH_SHORT).show();
        }
    }
}