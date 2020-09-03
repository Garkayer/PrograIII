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


        tbhConversores.addTab(tbhConversores.newTabSpec("M").setContent(R.id.tabNuestro).setIndicator("Nuestro"));
        tbhConversores.addTab(tbhConversores.newTabSpec("L").setContent(R.id.tabÀrea).setIndicator("Àrea"));


    }
    public void calcular(View view){
        try {
            TextView tmpVal = (TextView) findViewById(R.id.txtCantidad);
            double cantidad = Double.parseDouble(tmpVal.getText().toString());

            Spinner spn;
            double valores[][] = {
                    new double[]{1, 0.84, 7.67169, 24.5016, 34.76, 8.75, 22.03, 6.91, 802.50, 3784.05,},//Nuestrp
                    new double[]{1, 0.1329421, 0.111111, 0.092903, 0.00014775, 0.00001319, 0.000009,}, //Àrea

            };
            int de = 0, a = 0;
            double resp = 0;
            switch (tbhConversores.getCurrentTabTag()) {

                case "M":
                    spn = (Spinner) findViewById(R.id.cboDeM);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAM);
                    a = spn.getSelectedItemPosition();
                    resp = valores[0][a] / valores[0][de] / cantidad;
                    break;
                case "L":
                    spn = (Spinner) findViewById(R.id.cboDeL);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAL);
                    a = spn.getSelectedItemPosition();
                    resp = valores[1][a] / valores[1][de] * cantidad;
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