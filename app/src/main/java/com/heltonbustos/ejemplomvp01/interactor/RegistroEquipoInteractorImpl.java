package com.heltonbustos.ejemplomvp01.interactor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.heltonbustos.ejemplomvp01.interfaces.RegistroEquipoInteractor;
import com.heltonbustos.ejemplomvp01.interfaces.RegistroEquipoPresenter;
import com.heltonbustos.ejemplomvp01.interfaces.RegistroPresenter;

public class RegistroEquipoInteractorImpl implements RegistroEquipoInteractor {

    @Override
    public void registrarEquipo(String codigo, String marca, String modelo, RegistroEquipoPresenter presenter, Context contexto) {

        if(codigo.equals("") ){
            presenter.setErrorCodigo();
        }
        else if(modelo.equals("")){
            presenter.setErrorModelo();
        }
        else if(marca.equals("")){
            presenter.setErrorMarca();
        }
        else {
            //registrar en SQLite
            ConexionBD conexion = new ConexionBD(contexto, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("marca", marca);
            registro.put("modelo", modelo);

            long x = bd.insert("equipos", null, registro);
            bd.close();

            if (x > 0) {
                presenter.exitoEquipo();
            } else {
                presenter.errorEquipo();
            }
        }
    }
}
