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


public class MainActivity extends AppCompatActivity {

    private Calculadora calc;
    private boolean usuarioEstaDigitandoUmNumero;
    private boolean separadorDecimalFoiDigitado;
    private TextView txtVisor;
    private String separador;
    private char separadorChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calc = new Calculadora();
        usuarioEstaDigitandoUmNumero = false;
        separadorDecimalFoiDigitado = false;
        txtVisor = (TextView) findViewById(R.id.txtVisor);
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
        final Typeface fonteDigital = Typeface.createFromAsset(this.getAssets(),"digital.ttf");
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
    }


    public void onClickNumeros(View v) {
        Button botaoTocado = (Button) v;
        String digito = botaoTocado.getText().toString();

        String textoNoVisor = txtVisor.getText().toString();

        if (!usuarioEstaDigitandoUmNumero || textoNoVisor.equals("0")) {

            txtVisor.setText(digito);
            if (!digito.equals("0")) {
                usuarioEstaDigitandoUmNumero = true;
            } else {
                txtVisor.setText(textoNoVisor + digito);
            }
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

            } else {
                //txtVisor.setText(textoResultado.replace('.', ','));
                txtVisor.setText(textoResultado.replace('.',separadorChar));
                usuarioEstaDigitandoUmNumero = false;
                separadorDecimalFoiDigitado = false;
            }
        }
    }

    public void onClickMemoria(View v) {

        Button botaoTocado = (Button) v;
        String operacaoMemoria = botaoTocado.getText().toString();
        //String valorSemVirgula = txtVisor.getText().toString().replace(',', '.');
        String valorSemVirgula = txtVisor.getText().toString().replace(separadorChar, '.');

        calc.setOperando(Double.parseDouble(valorSemVirgula));
        calc.realizaOperacaoDeMemoria(operacaoMemoria);

        usuarioEstaDigitandoUmNumero = false;

    }


}
