package es.br.senac.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //criando a string visor
    String visor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtVisor = (TextView) findViewById(R.id.txtVisor);
              txtVisor.setText(visor);

        final Button btnZero = (Button) findViewById(R.id.btnZero);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            txtVisor.setText(visor=visor +"0");



            }
        });

        final Button btnUm = (Button) findViewById(R.id.btnUm);
        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             txtVisor.setText(visor=visor +"1");

            }
        });


        final Button btnDois = (Button) findViewById(R.id.btnDois);
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtVisor.setText(visor=visor +"2");
            }
        });

        final Button btnTres = (Button) findViewById(R.id.btnTres);
        btnTres.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtVisor.setText(visor=visor +"3");
        }
    });

        final Button btnQuatro = (Button) findViewById(R.id.btnQuatro);
        btnQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"4");
            }
        });

        final Button btnCinco = (Button) findViewById(R.id.btnCinco);
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"5");
            }
        });
        final Button btnSeis = (Button) findViewById(R.id.btnSeis);
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"6");
            }
        });
        final Button btnSete = (Button) findViewById(R.id.btnSete);

        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"7");
            }
        });

        final Button btnOito = (Button) findViewById(R.id.btnOito);

        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"8");
            }
        });
        final Button btnNove = (Button) findViewById(R.id.btnNove);
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"9");
            }
        });
        final Button btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText("");
            }
        });
        final Button btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"+");
            }
        });
        final Button btnMenos = (Button) findViewById(R.id.btnMenus);
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"-");
            }
        });
        final Button btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"x");

            }
        });
        final Button btnDividir = (Button) findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVisor.setText(visor=visor +"÷");
            }
        });






}


}
