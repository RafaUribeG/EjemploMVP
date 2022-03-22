package com.heltonbustos.ejemplomvp01.interactor.modeloRecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.heltonbustos.ejemplomvp01.R;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDatos>{

    ArrayList<RegistroEquiposDatos> listDatos;
    Context context;

    public AdaptadorDatos(ArrayList<RegistroEquiposDatos> listDatos, Context context) {
        this.listDatos = listDatos;
        this.context = context;
    }



    @NonNull
    @Override
    public AdaptadorDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.registro_equipos, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatos.ViewHolderDatos holder, int position) {

        Bitmap bit1 = listDatos.get(position).getB1();
        Bitmap bit2 = listDatos.get(position).getB2();
        String cod = listDatos.get(position).getCodigo();
        String nom = listDatos.get(position).getNombreCli();
        String fec = listDatos.get(position).getFecha();
        String mar = listDatos.get(position).getMarca();
        String mod = listDatos.get(position).getModelo();
        String car = listDatos.get(position).getCargador();
        String equi = listDatos.get(position).getEquipo();
        String man = listDatos.get(position).getManual();
        String gar = listDatos.get(position).getGarantia();
        String sis = listDatos.get(position).getSistemaop();
        String mon = listDatos.get(position).getMonitor();
        String aud = listDatos.get(position).getAudio();
        String tou = listDatos.get(position).getTouchpad();
        String obs = listDatos.get(position).getObs();

        holder.imagen1.setImageBitmap(bit1);
        holder.imagen2.setImageBitmap(bit2);
        holder.codigo.setText(cod);
        holder.nombreCli.setText(nom);
        holder.fecha.setText(fec);
        holder.marca.setText(mar);
        holder.cargador.setText(car);
        holder.equipo.setText(equi);
        holder.manual.setText(man);
        holder.garantia.setText(gar);
        holder.sistemaop.setText(sis);
        holder.monitor.setText(mon);
        holder.audio.setText(aud);
        holder.touchpad.setText(tou);
        holder.obs.setText(obs);

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        ImageView imagen1;
        ImageView imagen2;
        TextView codigo;
        TextView nombreCli;
        TextView fecha;
        TextView marca;
        TextView modelo;
        TextView cargador;
        TextView equipo;
        TextView manual;
        TextView garantia;
        TextView sistemaop;
        TextView monitor;
        TextView audio;
        TextView touchpad;
        TextView obs;

        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);

            imagen1 = itemView.findViewById(R.id.img1Equipo);
            imagen2 = itemView.findViewById(R.id.img1Equipo);
            codigo = itemView.findViewById(R.id.txtCodigoEquipoL);
            nombreCli = itemView.findViewById(R.id.txtNombreEquipoL);
            fecha = itemView.findViewById(R.id.txtFechaEquipoL);
            marca = itemView.findViewById(R.id.txtMarcaEquipoL);
            modelo = itemView.findViewById(R.id.txtModeloEquipoL);
            cargador = itemView.findViewById(R.id.txtCargadorEquipoL);
            equipo = itemView.findViewById(R.id.txtEquipoL);
            manual = itemView.findViewById(R.id.txtManualEquipoL);
            garantia = itemView.findViewById(R.id.txtGarantiaEquipoL);
            sistemaop = itemView.findViewById(R.id.txtSistemaOpEquipoL);
            monitor = itemView.findViewById(R.id.txtMonitorEquipoL);
            audio = itemView.findViewById(R.id.txtAudioEquipoL);
            touchpad = itemView.findViewById(R.id.txtTouchEquipoL);
            obs = itemView.findViewById(R.id.txtObsEquipoL);

        }
    }
}
