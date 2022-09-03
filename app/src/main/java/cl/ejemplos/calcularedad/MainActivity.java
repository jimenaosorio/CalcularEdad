package cl.ejemplos.calcularedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularEdad(view);
            }
        });
    }

    public void calcularEdad(View view)
    {
        //Leer los datos de entrada
        EditText etDiaNac=(EditText) findViewById(R.id.dNac);
        Spinner etMesNac=(Spinner) findViewById(R.id.mNac);
        EditText etANac=(EditText) findViewById(R.id.aNac);

        //Transformar los datos
        int dNac=Integer.parseInt(etDiaNac.getText().toString());
        int aNac=Integer.parseInt(etANac.getText().toString());
        int mNac;
        switch (etMesNac.getSelectedItem().toString())
        {
            case "Enero": mNac=1;
                break;
            case "Febrero": mNac=2;
                break;
            case "Marzo": mNac=3;
                break;
            case "Abril": mNac=4;
                break;
            case "Mayo": mNac=5;
                break;
            case "Junio": mNac=6;
                break;
            case "Julio": mNac=7;
                break;
            case "Agosto": mNac=8;
                break;
            case "Septiembre": mNac=9;
                break;
            case "Octubre": mNac=10;
                break;
            case "Noviembre": mNac=11;
                break;
            default: mNac=12;
                break;
        }

        //Lógica de negocio, versión 1
        /*
        int añoActual=2022;
        int edad=añoActual-aNac;
        */

        //Lógica de negocio, versión 2
        /*
        int dActual=3;
        int mActual=9;
        int añoActual=2022;
        int edad=calcula(dNac,mNac,aNac,dActual,mActual,añoActual);
        */

        //Lógica de negocio, versión 3
        final Calendar calendar=Calendar.getInstance(); //Recupero el calendario
        int dActual=calendar.get(Calendar.DAY_OF_MONTH);
        int mActual=calendar.get(Calendar.MONTH)+1;
        int añoActual=calendar.get(Calendar.YEAR);
        int edad=calcula(dNac,mNac,aNac,dActual,mActual,añoActual);


        //Mostrar el resultado
        TextView resultado=(TextView) findViewById(R.id.txtResultado);
        //Versión 1

        //resultado.setText("Este año cumples "+edad+" años");

        //Versiones 2 y 3
        resultado.setText("Tienes "+edad+" años");
    }

    //Versiones 2 y 3
    public int calcula(int dNac, int mNac, int aNac, int dAct, int mAct, int aAct)
    {
        int edad=0;
        //Verifico si el cumpleaños ya pasó o si está de cumpleaños
        if((mNac<mAct) || (mNac==mAct && dNac<=dAct))
        {
            edad=aAct-aNac;
        }
        else    //Aun no cumple años
        {
            edad=aAct-aNac-1;
        }


        return edad;
    }
}




