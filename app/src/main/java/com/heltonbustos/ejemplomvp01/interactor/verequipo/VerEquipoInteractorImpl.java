package com.heltonbustos.ejemplomvp01.interactor.verequipo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import com.heltonbustos.ejemplomvp01.interactor.bd.ConexionBD;
import com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView.RegistroEquiposDatos;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposInteractorInterface;
import com.heltonbustos.ejemplomvp01.interfaces.verequipos.VerEquiposPresenterInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VerEquipoInteractorImpl implements VerEquiposInteractorInterface {

    ArrayList<RegistroEquiposDatos> listaRegistros = new ArrayList<>();
    @Override
    public void llenarRecycler(VerEquiposPresenterInterface presentador, Context contexto) {

        File ruta = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/MyApp/");
        }
        else{
            ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        }

        File fotos[] = ruta.listFiles();

        String codigo = "";
        String nombreCli = "";
        String marca = "";
        String modelo = "";
        String fecha = "";
        String cargador = "";
        String equipo = "";
        String manual = "";
        String garantia = "";
        String sistemaop = "";
        String monitor = "";
        String audio = "";
        String touchpad = "";
        String obs = "";

        ConexionBD conexion = new ConexionBD(contexto, "administracion", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT * FROM equipos ORDER BY fecha DESC", null);

        if (fila.moveToFirst()){
            do {
                codigo = fila.getString(0);
                nombreCli = fila.getString(1);
                marca = fila.getString(2);
                modelo = fila.getString(3);
                fecha = fila.getString(4);
                cargador = fila.getString(5);
                equipo = fila.getString(6);
                manual = fila.getString(7);
                garantia = fila.getString(8);
                sistemaop = fila.getString(9);
                monitor = fila.getString(10);
                audio = fila.getString(11);
                touchpad = fila.getString(12);
                obs = fila.getString(13);

                List<Bitmap> archivos = new ArrayList<>();

                if(fotos != null) {
                    for (int i = 0; i < fotos.length; i++) {
                        if (fotos[i].getAbsolutePath().contains(codigo)) {
                            archivos.add(BitmapFactory.decodeFile(fotos[i].getAbsolutePath()));
                        }
                    }

                    listaRegistros.add(
                            new RegistroEquiposDatos(archivos.get(0), archivos.get(1),
                                    "Código: " + codigo, "Nombre: " + nombreCli, "Marca: " + marca, "Modelo: " + modelo, "Fecha: " + fecha,
                                    "Cargador: " + cargador, "Equipo: " + equipo, "Manual: " + manual, "Garantía: " + garantia,
                                    "Sistema Operativo: " + sistemaop, "Monitor: " + monitor, "Audio: " + audio, "Touchpad: " + touchpad,
                                    "Observaciones: " + obs));
                }
                else{
                    Toast.makeText(contexto, "Aun no hay fotos", Toast.LENGTH_SHORT).show();
                    break;
                }
            } while(fila.moveToNext());

            fila.close();
            bd.close();



            presentador.exitoE(listaRegistros);
        }
        else{
            presentador.errorE();
        }

    }
}

