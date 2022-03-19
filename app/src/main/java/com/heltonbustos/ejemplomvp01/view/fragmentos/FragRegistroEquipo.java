package com.heltonbustos.ejemplomvp01.view.fragmentos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.heltonbustos.ejemplomvp01.R;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoPresenter;
import com.heltonbustos.ejemplomvp01.interfaces.registroequipo.RegistroEquipoView;
import com.heltonbustos.ejemplomvp01.presenter.registroequipo.RegistroEquipoPresenterImpl;
import com.heltonbustos.ejemplomvp01.view.actividades.Login;
import com.heltonbustos.ejemplomvp01.view.actividades.OtraActividad;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragRegistroEquipo extends Fragment implements RegistroEquipoView {

    //Campos de texto del formulario
    TextView txtFecha;
    EditText txtCodigo, txtNombreCli, txtMarca, txtModelo, txtObs;

    //radio para el cargador
    RadioButton rdSiCargador, rdNoCargador;
    //radio para el equipo
    RadioButton rdSiEquipo, rdNoEquipo;
    //radio para el manual
    RadioButton rdSiManual, rdNoManual;
    //radio para la garantia
    RadioButton rdSiGarantia, rdNoGarantia;
    //radio para el sistemaop
    RadioButton rdSiSistemaOp, rdNoSistemaOp;
    //radio para el monitor
    RadioButton rdSiMonitor, rdNoMonitor;
    //radio para el audio
    RadioButton rdSiAudio, rdNoAudio;
    //radio para el touchpad
    RadioButton rdSiTouchpad, rdNoTouchpad;


    //presentador MVP
    RegistroEquipoPresenter presenter;

    //variables para trabajar con los nombres de las fotos
    String f = "";

    //botones para tomar foto 1, foto 2 y registro
    Button btnFoto1, btnFoto2, btnRegistrarEquipo;

    //ImageView para fotos
    ImageView img1, img2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_registro_equipo, container, false);

        //campos de texto formulario
        txtFecha = v.findViewById(R.id.txtFechaIngreso);
        txtCodigo = v.findViewById(R.id.txtCodigoIngreso);
        txtNombreCli = v.findViewById(R.id.txtNombreCLi);
        txtMarca = v.findViewById(R.id.txtMarca);
        txtModelo = v.findViewById(R.id.txtModelo);
        txtObs = v.findViewById(R.id.txtObs);


        //radio cargador
        rdSiCargador = v.findViewById(R.id.rdSiCargador);
        rdNoCargador = v.findViewById(R.id.rdNoCargador);
        //radio equipo
        rdSiEquipo = v.findViewById(R.id.rdSiEquipo);
        rdNoEquipo = v.findViewById(R.id.rdNoEquipo);
        //radio manual
        rdSiManual = v.findViewById(R.id.rdSiManual);
        rdNoManual = v.findViewById(R.id.rdNoManual);
        //radio garantia
        rdSiGarantia = v.findViewById(R.id.rdSiGarantia);
        rdNoGarantia = v.findViewById(R.id.rdNoGarantia);
        //radio sistemaop
        rdSiSistemaOp = v.findViewById(R.id.rdSiSistemaOp);
        rdNoSistemaOp = v.findViewById(R.id.rdNoSistemaOp);
        //radio monitor
        rdSiMonitor = v.findViewById(R.id.rdSiMonitor);
        rdNoMonitor = v.findViewById(R.id.rdNoMonitor);
        //radio audio
        rdSiAudio = v.findViewById(R.id.rdSiAudio);
        rdNoAudio = v.findViewById(R.id.rdNoAudio);
        //radio touchpad
        rdSiTouchpad = v.findViewById(R.id.rdSiTouch);
        rdNoTouchpad = v.findViewById(R.id.rdNoTouch);

        //presentador
        presenter = new RegistroEquipoPresenterImpl(this);

        //para traer la fecha actual
        Calendar calendar = Calendar.getInstance(); // Returns instance with current date and time set
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        f = formatter.format(calendar.getTime());
        txtFecha.setText(f);

        //ImageView para fotos
        btnFoto1 = v.findViewById(R.id.btnFoto1);
        btnFoto2 = v.findViewById(R.id.btnFoto2);

        //btn para registrar
        btnRegistrarEquipo = v.findViewById(R.id.btnRegistrarEquipo);

        //ImageView para fotos
        img1 = v.findViewById(R.id.img1);
        img2 = v.findViewById(R.id.img2);

        btnFoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OtraActividad)getActivity()).permisosCamara1(img1);
            }
        });

        btnFoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OtraActividad)getActivity()).permisosCamara2(img2);
            }
        });

        btnRegistrarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarRegistro();
            }
        });

        return v;
    }

    @Override
    public void exitoEquipo() {
        Toast.makeText(getContext(), "Registrado Correctamente!", Toast.LENGTH_SHORT).show();
        ((OtraActividad)getActivity()).permisosAlmacenamiento(txtCodigo.getText().toString());
        txtCodigo.setText("");
        txtNombreCli.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtObs.setText("");
        rdNoCargador.isChecked();
    }

    @Override
    public void errorEquipo() {
        Toast.makeText(getContext(), "No se pudo registrar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorCodigo() {
        txtCodigo.setError("Complete el campo código");
    }

    public void setErrorNombreCli() {
        txtCodigo.setError("Complete el campo código");
    }

    @Override
    public void setErrorMarca() {
        txtMarca.setError("Complete el campo marca");
    }

    @Override
    public void setErrorModelo() {
        txtModelo.setError("Completo el campo modelo");
    }

    public void solicitarRegistro(){

        String cargador = "NO";
        String equipo = "NO";
        String manual = "NO";
        String garantia = "NO";
        String sistemaOp = "NO";
        String monitor = "NO";
        String audio = "NO";
        String touchpad = "NO";


        if(rdSiCargador.isChecked()){ cargador = "SI"; }
        if(rdSiEquipo.isChecked()){ equipo = "SI"; }
        if(rdSiManual.isChecked()){ manual = "SI"; }
        if(rdSiGarantia.isChecked()){ garantia = "SI"; }
        if(rdSiSistemaOp.isChecked()){ sistemaOp = "SI"; }
        if(rdSiMonitor.isChecked()){ monitor = "SI"; }
        if(rdSiAudio.isChecked()){ audio = "SI"; }
        if(rdSiTouchpad.isChecked()){ touchpad = "SI"; }


        presenter.registrarEquipo(txtCodigo.getText().toString(),
                                  txtNombreCli.getText().toString(),
                                  txtMarca.getText().toString(),
                                  txtModelo.getText().toString(),f,
                                  cargador, equipo, manual, garantia, sistemaOp, monitor,
                                  audio, touchpad, txtObs.getText().toString(),
                                  getContext());
    }

    public static void mostrarImagen(ImageView img, Bitmap bitmap){
        img.setImageBitmap(bitmap);
    }



}