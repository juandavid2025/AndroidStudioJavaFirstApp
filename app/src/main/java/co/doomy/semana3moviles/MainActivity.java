package co.doomy.semana3moviles;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button platoFuerteBtn;
    private Button bebidaBtn;
    private Button postreBtn;
    private Button hacerPedidoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new StartActivityForResult(), this::onResult
        );

        platoFuerteBtn = findViewById(R.id.platoFuerteBtn);
        bebidaBtn = findViewById(R.id.bebidaBtn);
        postreBtn = findViewById(R.id.postreBtn);
        hacerPedidoBtn = findViewById(R.id.hacerPedidoBtn);

        platoFuerteBtn.setOnClickListener(
                v->{
                    Intent intent = new Intent(this, secondActivity.class);
                    intent.putExtra("title", "P");

                    launcher.launch(intent);
                }
        );

        bebidaBtn.setOnClickListener(
                v->{
                    Intent intent = new Intent(this, secondActivity.class);
                    intent.putExtra("title", "B");

                    launcher.launch(intent);
                }
        );

        postreBtn.setOnClickListener(
                v->{
                    Intent intent = new Intent(this, secondActivity.class);
                    intent.putExtra("title", "D");

                    launcher.launch(intent);
                }
        );

        hacerPedidoBtn.setOnClickListener(
                v->{
                    Toast.makeText(this, "Pedido completado", Toast.LENGTH_LONG);
                }
        );
    }

    public void onResult(ActivityResult result){

       if(result.getResultCode() == RESULT_OK){
           String platoModificado = result.getData().getExtras().getString("title");
           String value = result.getData().getExtras().getString("value");

           if(platoModificado.equals("P")){
               platoFuerteBtn.setText(value);
           }else if (platoModificado.equals("B")){
               bebidaBtn.setText(value);
           }else{
              postreBtn.setText(value);
           }
       }
    }

}