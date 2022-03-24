package com.heltonbustos.ejemplomvp01.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.heltonbustos.ejemplomvp01.R;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoPresenterInterface;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoViewInterface;
import com.heltonbustos.ejemplomvp01.presenter.eliminarequipo.EliminarEquipoPresenterImpl;

public class FragEliminarRegistroEquipos extends Fragment implements EliminarEquipoViewInterface {

    //Campos de texto del formulario
    TextView txtFecha;
    EditText txtCodigo;

    //Presentador MVP
    EliminarEquipoPresenterInterface presenter;

    //Botones
    Button btnEliminarRegistro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_eliminar_registro_equipos, container, false);

        //campos de texto formulario
        txtFecha = v.findViewById(R.id.txtFechaIngreso);
        txtCodigo = v.findViewById(R.id.txtCodigoIngreso);


        //presentador
        presenter = new EliminarEquipoPresenterImpl(this);


        btnEliminarRegistro = v.findViewById(R.id.btnEliminarRegistro);


        btnEliminarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                chequeoEliminar();
            }
        });

        return v;
    }

    private void chequeoEliminar() {
        presenter.eliminarEquipo(txtCodigo.getText().toString(), getContext());
    }


    @Override
    public void setErrorCodigo() {
        Toast.makeText(getContext(), "Ingrese código", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void exitoEli() {
        Toast.makeText(getContext(), "Registro eliminado correctamente!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorEli() {
        Toast.makeText(getContext(), "No se pudo eliminar el registro", Toast.LENGTH_SHORT).show();
    }
}