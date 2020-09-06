package com.ugb.conversores;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    Conversor conversor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tbhConversor = (TabHost) findViewById(R.id.tbhConversores);
        tbhConversor.setup();
        String str = "Universal";
        tbhConversor.addTab(tbhConversor.newTabSpec(str).setIndicator(str, null).setContent(R.id.tabNuestro));
        String str2 = "Area";
        tbhConversor.addTab(tbhConversor.newTabSpec(str2).setIndicator(str2, null).setContent(R.id.tabÀrea));
    }


    public void Procesar(View v) {
        try {
            TextView temp = (TextView) findViewById(R.id.txtunidades);
            String str = "";
            int units = temp.getText().toString().equals(str) ? 1 : Integer.parseInt(temp.getText().toString());
            TextView temp2 = (TextView) findViewById(R.id.txtcantidad);
            TextView valor = (TextView) findViewById(R.id.txtCantity);
            String str2 = "/";
            if (!temp2.getText().toString().equals(str)) {
                int cantity = Integer.parseInt(temp2.getText().toString());
                int box = cantity / units;
                StringBuilder sb = new StringBuilder();
                sb.append(box);
                sb.append(str2);
                sb.append(cantity % units);
                valor.setText(sb.toString());
            } else if (!valor.getText().toString().equals(str)) {
                String[] data = valor.getText().toString().split(str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append((Integer.parseInt(data[0]) * units) + Integer.parseInt(data[1]));
                temp2.setText(sb2.toString());
            }
        } catch (Exception err) {
            TextView temp = (TextView) findViewById(R.id.lblrespuesta);
            temp.setText("Porfavor Ingrese solo Numeros.");

            Toast.makeText(getApplicationContext(), "Por Favor Ingrese Solamente Numeros", Toast.LENGTH_LONG).show();
        }
    }

    public void convertir(View v) {

        try {


            this.conversor = new Conversor();
            int de = ((Spinner) findViewById(R.id.cboDeL)).getSelectedItemPosition();
            int a = ((Spinner) findViewById(R.id.cboAL)).getSelectedItemPosition();
            double cantidad = Double.parseDouble(((TextView) findViewById(R.id.txtcan)).getText().toString());
            TextView tempVal = (TextView) findViewById(R.id.lblrespuesta);
            StringBuilder sb = new StringBuilder();
            sb.append("Respuesta: ");
            sb.append(this.conversor.convertir_area(de, a, cantidad));
            tempVal.setText(sb.toString());


        } catch (Exception err) {
            TextView temp = (TextView) findViewById(R.id.lblrespuesta);
            temp.setText("Porfavor Ingrese solo Numeros.");

            Toast.makeText(getApplicationContext(), "Por Favor Ingrese Solamente Numeros", Toast.LENGTH_LONG).show();
        }

    }
}


