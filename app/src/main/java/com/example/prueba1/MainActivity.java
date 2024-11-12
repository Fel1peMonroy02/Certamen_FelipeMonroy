package com.example.prueba1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner Sexo;
        EditText Peso, Estatura;
        Button CalcularIMC;

        TextView MensajeFinal, MensajeIMC;

        Sexo = findViewById(R.id.spner_Sexo);

        Peso = findViewById(R.id.txtPeso);
        Estatura = findViewById(R.id.txtEstatura);

        MensajeFinal = findViewById(R.id.txtMensaje);
        MensajeIMC = findViewById(R.id.txtIMC);

        CalcularIMC = findViewById(R.id.btnCalcular);

        CalcularIMC.setOnClickListener(view -> {
            Double EstaturaM = Double.parseDouble(Estatura.getText().toString())/100;
            Double Pesokg = Double.parseDouble(Peso.getText().toString());

            Double IMC = Pesokg/(EstaturaM*EstaturaM);

            String IMCtotal = IMC.toString().substring(0,5);

            MensajeIMC.setText("IMC= "+IMCtotal);
            MensajeFinal.setText(CalcularIMCF(IMC));
        });
    }



    public String CalcularIMCF(double IMC){

        String Mensaje = "";

        if(IMC < 18.5){
            Mensaje = "1) Come con más frecuencia. empieza poco a poco a hacer 5 a 6 comidas mas pequeñas durante el día.\n" +
                    "2) Elige alimentos con muchos nutrientes.\n" +
                    "3) Agrega aderezos.\n" +
                    "4) Prueba licuados y batidos de frutas.\n" +
                    "5) Controla que bebes y cuando.\n" +
                    "6) Haz ejercicio.";
        }else if(IMC > 25.0 && IMC < 34.9){

            Mensaje = "1) Haga 30 minutos de ejercicio aeróbico 5 veces por semana.\n" +
                    "2) Logre un equilibrio entre el consumo de calorías y la actvidad física.\n" +
                    "3) Límite las grasas saturadas a no mas del 7% de las calorías totales.\n" +
                    "4) Tenga una alimentacion baja en colesterol con carnes magras, frutas, verduaras y cereales integrales.";
        }else if (IMC >=18.5 && IMC <=24.9){
            Mensaje = "Felicidades ud mantiene una excelente alimentación";
        }else{
            Mensaje= "Error Calculo";
        }


        return Mensaje;
    }

}