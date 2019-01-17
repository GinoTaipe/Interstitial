package com.example.gino.interstitial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.*;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ConexionInternet.compruebaConexion(this))
        {
            //Pantalla completa
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            getSupportActionBar().hide();

            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //La actividad en forma vertical



            btnPlay=findViewById(R.id.btnPlay);
            MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //Crear anuncio
            mInterstitialAd.loadAd(new AdRequest.Builder().build()); //Cargar el anuncio

        }
        else {
            DialogoInternet(MainActivity.this).show(); //Mostrar el mensaje de conexion no establecida
        }
    }

    public AlertDialog.Builder DialogoInternet(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("No Conectado a Internet");
        builder.setMessage("La aplicación requiere conexión a internet");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

    public void Mostrar(View view)
    {
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
            btnPlay.setEnabled(false);

            mInterstitialAd.setAdListener(new AdListener()
            {
                int i=0;
                @Override
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when the ad is displayed.
                }


                @Override
                public void onAdClosed() {
                    switch (i){
                        case '0':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '2':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '3':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '4':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '5':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '6':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '7':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '8':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '9':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'0':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'1':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'2':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'3':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'4':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'5':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'6':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'7':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'8':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                        case '1'+'9':mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");break;
                    }
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    i++;
                    if(i==20)
                    {
                        i=0;
                    }
                }
            });
        }else{
            Toast.makeText(this,"Cargando",Toast.LENGTH_LONG).show();
        }

    }
}
