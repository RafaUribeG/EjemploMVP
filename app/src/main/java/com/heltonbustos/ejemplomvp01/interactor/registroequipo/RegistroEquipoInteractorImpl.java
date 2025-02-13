package com.heltonbustos.ejemplomvp01.interactor.registroequipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.heltonbustos.ejemplomvp01.interactor.bd.ConexionBD;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoInteractor;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoPresenter;

public class RegistroEquipoInteractorImpl implements RegistroEquipoInteractor {

    @Override
    public void registrarEquipo(String codigo, String nombreCli, String marca, String modelo, String fecha,
                                String cargador, String equipo,
                                String manual,String garantia, String sistemaop, String monitor,
                                String audio, String touchpad, String observaciones, RegistroEquipoPresenter presenter, Context contexto) {

        if(codigo.equals("") ){
            presenter.setErrorCodigo();
        }
        else if(nombreCli.equals("")){
            presenter.setErrorNombreCli();
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
            registro.put("nombreCli", nombreCli);
            registro.put("marca", marca);
            registro.put("modelo", modelo);
            registro.put("fecha", fecha);
            registro.put("cargador", cargador);
            registro.put("equipo", equipo);
            registro.put("manual", manual);
            registro.put("garantia", garantia);
            registro.put("sistemaop", sistemaop);
            registro.put("monitor", monitor);
            registro.put("audio", audio);
            registro.put("touchpad", touchpad);
            registro.put("observaciones", observaciones);

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
