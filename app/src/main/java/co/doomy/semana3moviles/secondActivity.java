package co.doomy.semana3moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    private String selection;
    private TextView textoPrincipal;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button confirmarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textoPrincipal = findViewById(R.id.textoPrincipal);
        boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);
        boton3 = findViewById(R.id.boton3);
        confirmarBtn = findViewById(R.id.confirmarBtn);

        String title = getIntent().getExtras().getString("title");

        if (title.equals("P")) {
            textoPrincipal.setText("PLATO FUERTE");
            boton1.setText("Ajiaco");
            boton2.setText("Hamburguesa");
            boton3.setText("Baby Beef");
        }else if (title.equals("B")) {
            textoPrincipal.setText("BEBIDA");
            boton1.setText("Cerveza");
            boton2.setText("Limonada natural");
            boton3.setVisibility(View.INVISIBLE);
        }else {
            textoPrincipal.setText("POSTRE");
            boton1.setText("Brownie con helado");
            boton2.setText("Arroz con leche");
            boton3.setText("Tiramisú");
        }

        boton1.setOnClickListener(
                v->{
                    selection = boton1.getText().toString();
                    Toast.makeText(this, "Selected: "+selection, Toast.LENGTH_LONG).show();
                }
        );

        boton2.setOnClickListener(
                v->{
                    selection = boton2.getText().toString();
                    Toast.makeText(this, "Selected: "+selection, Toast.LENGTH_LONG).show();
                }
        );

        boton2.setOnClickListener(
                v->{
                    selection = boton3.getText().toString();
                    Toast.makeText(this, "Selected: "+selection, Toast.LENGTH_LONG).show();
                }
        );

        confirmarBtn.setOnClickListener(
                v->{
                    if (!selection.isEmpty()){
                        Intent data = new Intent();

                        data.putExtra("title", title);
                        data.putExtra("value", ""+selection);
                        setResult(RESULT_OK, data);

                        finish();
                    }else{
                        Toast.makeText(this, "Por favor escoja una opción", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}