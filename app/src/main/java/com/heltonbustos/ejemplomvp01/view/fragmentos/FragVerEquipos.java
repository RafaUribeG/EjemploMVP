package com.heltonbustos.ejemplomvp01.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.heltonbustos.ejemplomvp01.R;
import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.AdaptadorDatos;
import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.RegistroEquiposDatos;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposViewInterface;
import com.heltonbustos.ejemplomvp01.presenter.verequipo.VerEquipoPresenterImpl;

import java.util.ArrayList;

public class FragVerEquipos extends Fragment implements VerEquiposViewInterface {

    AdaptadorDatos adaptador;
    RecyclerView myRecyclerView2;
    VerEquipoPresenterImpl presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ver_equipos, container, false);

        myRecyclerView2 = v.findViewById(R.id.myRecyclerView2);

        presenter = new VerEquipoPresenterImpl(this);
        presenter.llenarRecycler(getContext());


        return v;
    }

    @Override
    public void exitoE(ArrayList<RegistroEquiposDatos> listaRegistros) {
        myRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        myRecyclerView2.setAdapter(new AdaptadorDatos(listaRegistros, getContext()));
    }

    @Override
    public void errorE() {
        Toast.makeText(getContext(), "Aun no hay Registros  ", Toast.LENGTH_SHORT).show();
    }
}