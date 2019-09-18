package es.br.senac.calculadora;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

//declarando uma classe piblica
//extends AppCompatActivity é uma herança de classe
// é o nome da minha classe "MainActivity"
// é uma herança "extends" herda tudo da  classe pai " AppCompatActivity"
// é a classe pai  "AppCompatActivity"

public class MainActivity extends AppCompatActivity {
//declarando as variaveis
    private Calculadora calc;
    //declarando as variaveis do tipo boolean (que retorna false ou true)
    private boolean usuarioEstaDigitandoUmNumero;
    private boolean separadorDecimalFoiDigitado;
    //declarando as variavel do tipo TextView
    private TextView txtVisor;
    //declarando as variavel do tipo String (texto)
    private String separador;
    //declarando as variavel do tipo char ( que recebe apenas 1 caracter)
    private char separadorChar;
// fim da declaração das variaveis

    // metodo que declara o ciclo de criação da tela
    //@Override sobre escreve um metodo herdado da classe  pai " AppCompatActivity"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //declaração de metodo protected (significa que o  metodo é protegido)
        // void retorna vazio
        //declaração de metodo onCreate (metodo herdado da classe pai "AppCompatActivity"
        //(Bundle savedInstanceState) é o argumento do metodo onCreate
        // quando tem super e o nome do metodo ele está indo no pai e buscando tudo que tem lá
        //super.onCreate(savedInstanceState)  executa todos os codigos da classe pai
        super.onCreate(savedInstanceState);
        //"setContentView(R.layout.activity_main" metodo que liga a Activity.java com o java
        setContentView(R.layout.activity_main);


        //de
        calc = new Calculadora();
        usuarioEstaDigitandoUmNumero = false;
        separadorDecimalFoiDigitado = false;
        txtVisor = (TextView)findViewById(R.id.txtVisor);
        txtVisor.setText("0");



        Locale localizacao = getResources().getConfiguration().locale;
        NumberFormat fomatador = NumberFormat.getInstance(localizacao);
        // definimos inicialmente o separador como virgula,que é normal o padrão nacional separadorChar=',';

        if (fomatador instanceof DecimalFormat) {
            DecimalFormatSymbols simbolo = ((DecimalFormat) fomatador).getDecimalFormatSymbols();
            separadorChar = simbolo.getDecimalSeparator();
        }
        separador = String.valueOf(separadorChar);


        Button btnSeparador = (Button) findViewById(R.id.btnVigula);
        btnSeparador.setText(separador);




    //Uso da fonte digital
    final Typeface fonteDigital = Typeface.createFromAsset(this.getAssets(), "digital.ttf");
        txtVisor.setTypeface(fonteDigital);

        txtVisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo Auto-generated method stub
                if (txtVisor.getTypeface().equals(fonteDigital)){
                    txtVisor.setTypeface(Typeface.DEFAULT);

                }else {
                    txtVisor.setTypeface(fonteDigital);
                }

            }
        });
        Toast.makeText(this,"Toque no visor para trocar sua fonte!", Toast.LENGTH_LONG).show();

        final Button btnDel = (Button) findViewById(R.id.btnDel);
         btnDel.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
       if(txtVisor.getText() !=null && txtVisor.getText().toString().length()>0){
           txtVisor.setText(txtVisor.getText().toString().substring(0,txtVisor.getText().toString().length()-1));
       }

       }
        });
}
        public void onClickNumeros(View v) {
            Button botaoTocado = (Button) v;
            String digito = botaoTocado.getText().toString();

            String textoNoVisor = txtVisor.getText().toString();

            if (!usuarioEstaDigitandoUmNumero || textoNoVisor.equals("0")) {

                txtVisor.setText(digito);
                if (!digito.equals("0")) {
                    usuarioEstaDigitandoUmNumero = true;
                }
            }else {
                    txtVisor.setText(textoNoVisor + digito);

                }
            }

        public void onClickOperacoes(View v) {
            Button botaoTocado = (Button) v;
            String operacao = botaoTocado.getText().toString();
            //if (operacao.equals(",") && !separadorDecimalFoiDigitado)
            if (operacao.equals(separador) && !separadorDecimalFoiDigitado) {
                separadorDecimalFoiDigitado = true;
                if (!usuarioEstaDigitandoUmNumero) {
                    // txtVisor.setText("0" + ",");
                    txtVisor.setText("0" + separador);
                } else {
                    // txtVisor.setText(txtVisor.getText().toString() + ",");
                    txtVisor.setText(txtVisor.getText().toString() + separador);
                    usuarioEstaDigitandoUmNumero = true;
                }
                //usuarioEstaDigitandoUmNumero = true;
            } //else if (!operacao.equals(","))
            else if (!operacao.equals(separador)) {
                //String valorSemVirgula = txtVisor.getText().toString().replace(',', '.');
                String valorSemVirgula = txtVisor.getText().toString().replace(separadorChar, '.');
                calc.setOperando(Double.parseDouble(valorSemVirgula));
                calc.realizarOperacao(operacao);

                String textoResultado = String.valueOf(calc.getOperando());

                if (textoResultado.endsWith(".0")) {
                    textoResultado = textoResultado.substring(0, textoResultado.length() - 2);

                }
                    //txtVisor.setText(textoResultado.replace('.', ','));
                    txtVisor.setText(textoResultado.replace('.',separadorChar));
                    usuarioEstaDigitandoUmNumero = false;
                    separadorDecimalFoiDigitado = false;
                }
        }




        public void onClickMemoria(View v) {

            Button botaoTocado = (Button)v;
            String operacaoMemoria = botaoTocado.getText().toString();
            //String valorSemVirgula = txtVisor.getText().toString().replace(',', '.');
            String valorSemVirgula = txtVisor.getText().toString().replace(separadorChar, '.');

            calc.setOperando(Double.parseDouble(valorSemVirgula));
            calc.realizaOperacaoDeMemoria(operacaoMemoria);

            usuarioEstaDigitandoUmNumero = false;

        }



    }










