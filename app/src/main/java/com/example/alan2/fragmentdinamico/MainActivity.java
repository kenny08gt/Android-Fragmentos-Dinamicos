package com.example.alan2.fragmentdinamico;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import layout.BlankFragment;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////77

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB1");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2");
        tabs.addTab(spec);

        inicializar_tabs();

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                //Toast.makeText(MainActivity.this, "Pulsada pestaña: " + tabId,Toast.LENGTH_SHORT).show();
                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if(tabId.equals("tab1")){
                    BlankFragment fragment = new BlankFragment();
                    transaction.replace(R.id.layoutPrincipal, fragment);
                }else{
                    BlankFragment2 fragment = new BlankFragment2();
                    transaction.replace(R.id.layoutPrincipal, fragment);
                }
                //Paso 3: Crear un nuevo fragmento y añadirlo



                transaction.addToBackStack(null);

// Commit the transaction

                //transaction.add(R.id.layoutPrincipal, fragment, "");

                //Paso 4: Confirmar el cambio
                transaction.commit();
            }
        });
        /////////////////////7
/*
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                BlankFragment2 fragment = new BlankFragment2();

                transaction.replace(R.id.layoutPrincipal, fragment);
                transaction.addToBackStack(null);
                //transaction.add(R.id.layoutPrincipal, fragment, "");

                //Paso 4: Confirmar el cambio
                transaction.commit();
            }
        });*/
    }

    private void inicializar_tabs() {
        FragmentManager fragmentManager = getFragmentManager();

        //Paso 2: Crear una nueva transacción
        FragmentTransaction transaction = fragmentManager.beginTransaction();


            BlankFragment fragment = new BlankFragment();
            transaction.replace(R.id.layoutPrincipal, fragment);

        //Paso 3: Crear un nuevo fragmento y añadirlo



        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
