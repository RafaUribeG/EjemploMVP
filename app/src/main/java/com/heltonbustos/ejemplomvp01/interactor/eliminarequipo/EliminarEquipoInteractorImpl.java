package com.heltonbustos.ejemplomvp01.interactor.eliminarequipo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import com.heltonbustos.ejemplomvp01.interactor.bd.ConexionBD;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoInteractorInterface;
import com.heltonbustos.ejemplomvp01.interfaces.eliminarequipo.EliminarEquipoPresenterInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EliminarEquipoInteractorImpl implements EliminarEquipoInteractorInterface {


    @Override
    public void eliminarEquipo(String codigo, EliminarEquipoPresenterInterface presenter, Context context) {

        if (codigo.equals("")) {
            presenter.setErrorCodigo();
        } else {

            ConexionBD conexion = new ConexionBD(context, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            int a = bd.delete("equipos", "codigo='" + codigo + "'", null);

            if (a > 0) {
                presenter.exitoEli();
            } else {
                presenter.errorEli();
            }
            bd.close();
        }

    }
}
