package com.ugb.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintStream;

import static java.lang.System.err;

public class MainActivity extends AppCompatActivity {

    TabHost tbhConversores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbhConversores = (TabHost)findViewById(R.id.tbhConversores);
        tbhConversores.setup();


        tbhConversores.addTab(tbhConversores.newTabSpec("M").setContent(R.id.tabMonedas).setIndicator("Monedas"));
        tbhConversores.addTab(tbhConversores.newTabSpec("L").setContent(R.id.tabLongitud).setIndicator("Longuitud"));
        tbhConversores.addTab(tbhConversores.newTabSpec("MA").setContent(R.id.tabMasa).setIndicator("Masa"));
        tbhConversores.addTab(tbhConversores.newTabSpec("T").setContent(R.id.tabTiempo).setIndicator("Tiempo"));
        tbhConversores.addTab(tbhConversores.newTabSpec("A").setContent(R.id.tabAlmacenamiento).setIndicator("Almacenamiento"));
        tbhConversores.addTab(tbhConversores.newTabSpec("V").setContent(R.id.tabVolumen).setIndicator("Volumen"));
       tbhConversores.addTab(tbhConversores.newTabSpec("TD").setContent(R.id.tabTrasnferenciaDatos).setIndicator("Transferencia"));

    }
    public void calcular(View view){
        try {
            TextView tmpVal = (TextView) findViewById(R.id.txtCantidad);
            double cantidad = Double.parseDouble(tmpVal.getText().toString());

            Spinner spn;
            double valores[][] = {
                    new double[]{1, 0.84, 7.67169, 24.5016, 34.76, 8.75, 22.03, 6.91, 802.50, 3784.05,},//monedas
                    new double[]{1, 0.001, 100, 1000, 1000000, 1000000000, 0.0006, 1.0936, 3.2808, 39.9701,}, //longitud
                    new double[]{1, 0.00045359, 0.4535923, 453.5923, 453592.37, 0.00000004535923, 0.0004464286, 0.0005, 0.0089285714, 0.01,}, //masa
                    new double[]{1, 1000000000, 1000000, 1000, 0.0166666667, 0.0002777778, 0.0000115741, 0.0000016534, 0.0000003802570, 0.00000003168808,}, //Tiempo
                    new double[]{1, 13, 0.000977, 0.000000954, 0.000000000931, 0.000000000000909, 0.000000000000000888, 0.000122, 0.000000119, 0.000000000116, 0.000000000000000111}, //Almacenamiento
                    new double[]{1, 4, 8, 15.7725, 128, 256, 768, 0.00378541, 3.78541, 3785.41,}, //Volumen...
                    new double[]{1, 0.001, 0.000125, 0.000001, 0.000000125, 0.000000001, 0.000000000125, 0.000000000001, 0.000000000000125} //Transferencia de Datos

            };
            int de = 0, a = 0;
            double resp = 0;
            switch (tbhConversores.getCurrentTabTag()) {

                case "M":
                    spn = (Spinner) findViewById(R.id.cboDeM);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAM);
                    a = spn.getSelectedItemPosition();
                    resp = valores[0][a] / valores[0][de] * cantidad;
                    break;
                case "L":
                    spn = (Spinner) findViewById(R.id.cboDeL);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAL);
                    a = spn.getSelectedItemPosition();
                    resp = valores[1][a] / valores[1][de] * cantidad;
                    break;
                case "MA":
                    spn = (Spinner) findViewById(R.id.cboDema);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAma);
                    a = spn.getSelectedItemPosition();
                    resp = valores[2][a] / valores[2][de] * cantidad;
                    break;
                case "T":
                    spn = (Spinner) findViewById(R.id.cboDeT);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAT);
                    a = spn.getSelectedItemPosition();
                    resp = valores[3][a] / valores[3][de] * cantidad;
                    break;

                case "A":
                    spn = (Spinner) findViewById(R.id.cboDeA);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAA);
                    a = spn.getSelectedItemPosition();
                    resp = valores[4][a] / valores[4][de] * cantidad;
                    break;

                case "V":
                    spn = (Spinner) findViewById(R.id.cboDeV);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAV);
                    a = spn.getSelectedItemPosition();
                    resp = valores[4][a] / valores[4][de] * cantidad;
                    break;
                case "TD":
                    spn = (Spinner) findViewById(R.id.cboDeTD);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboATD);
                    a = spn.getSelectedItemPosition();
                    resp = valores[4][a] / valores[4][de] * cantidad;
                    break;

            }


            tmpVal = (TextView) findViewById(R.id.lblrespuesta);
            tmpVal.setText("Respuesta: " + resp);
        }catch (Exception err){
        TextView temp = (TextView) findViewById(R.id.lblrespuesta);
        temp.setText("Porfavor Ingrese solo Numeros.");

            Toast.makeText(getApplicationContext(),"Por Favor Ingrese Solamente Numeros",Toast.LENGTH_LONG).show();
        }
    }
}