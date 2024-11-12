package com.example.prueba1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner Sexo;
        EditText Peso, Estatura, IMC;
        Button CalcularIMC;

        Sexo = findViewById(R.id.spner_Sexo);
        Peso = findViewById(R.id.txtPeso);
        Estatura = findViewById(R.id.txtEstatura);

        String Mensaje = "";

        if(CalcularIMC(Peso.getText().toString() , Estatura.getText().toString()) < 18.5){
             Mensaje = "1) Come con más frecuencia. empieza poco a poco a hacer 5 a 6 comidas mas pequeñas durante el día.\n" +
                    "2) Elige alimentos con muchos nutrientes.\n" +
                    "3) Agrega aderezos.\n" +
                    "4) Prueba licuados y batidos de frutas.\n" +
                    "5) Controla que bebes y cuando.\n" +
                    "6) Haz ejercicio.";
        }else if(CalcularIMC(Peso.getText().toString() , Estatura.getText().toString()) > 25.0 && CalcularIMC(Peso.getText().toString() , Estatura.getText().toString()) < 34.9){

            Mensaje = "1) Haga 30 minutos de ejercicio ae";
        }
    }

    public double CalcularIMC(String Peso, String Estatura){
        double IMC = 0;

        Double EstaturaM = Double.parseDouble(Estatura)/1000;
        Double Pesokg = Double.parseDouble(Peso);

        IMC = Pesokg/(EstaturaM*EstaturaM);

        return IMC;
    }

}