//package es.br.senac.calculadora;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    private Calculadora calc;
//    private boolean usuarioEstaDigitandoUmNumero;
//    private boolean separadorDecimalFoiDigitado;
//    private TextView txtVisor;
//    //criando a string visor
//    String visor = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        calc = new Calculadora();
//        usuarioEstaDigitandoUmNumero = false;
//        separadorDecimalFoiDigitado = false;
//        txtVisor = (TextView) findViewById(R.id.txtVisor);
//        txtVisor.setText("0");
//
//        //final TextView txtVisor = (TextView) findViewById(R.id.txtVisor);
//        //txtVisor.setText(visor);
//
//        /**  final Button btnZero = (Button) findViewById(R.id.btnZero);
//         btnZero.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View view) {
//        txtVisor.setText(visor=visor +"0");
//
//
//
//        }
//        });
//
//         final Button btnUm = (Button) findViewById(R.id.btnUm);
//         btnUm.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View view) {
//        txtVisor.setText(visor=visor +"1");
//
//        }
//        });
//
//
//         final Button btnDois = (Button) findViewById(R.id.btnDois);
//         btnDois.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View view) {
//        txtVisor.setText(visor=visor +"2");
//        }
//        });
//
//         final Button btnTres = (Button) findViewById(R.id.btnTres);
//         btnTres.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"3");
//        }
//        });
//
//         final Button btnQuatro = (Button) findViewById(R.id.btnQuatro);
//         btnQuatro.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"4");
//        }
//        });
//
//         final Button btnCinco = (Button) findViewById(R.id.btnCinco);
//         btnCinco.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"5");
//        }
//        });
//
//         final Button btnSeis = (Button) findViewById(R.id.btnSeis);
//         btnSeis.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"6");
//        }
//        });
//
//         final Button btnSete = (Button) findViewById(R.id.btnSete);
//
//         btnSete.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"7");
//        }
//        });
//
//         final Button btnOito = (Button) findViewById(R.id.btnOito);
//
//         btnOito.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"8");
//        }
//        });
//
//         final Button btnNove = (Button) findViewById(R.id.btnNove);
//         btnNove.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        txtVisor.setText(visor=visor +"9");
//        }
//        });
//
//         final Button btnC = (Button) findViewById(R.id.btnC);
//         btnC.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        visor = "";
//        txtVisor.setText(visor);
//        }
//        });
//
//         final Button btnSoma = (Button) findViewById(R.id.btnSoma);
//         btnSoma.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        // txtVisor.setText(visor=visor +"+");
//
//        if (visor.endsWith("-")){
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() -1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//
//
//        }if (visor.endsWith("x")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//        }if (visor.endsWith("÷")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "+";
//        txtVisor.setText(visor);
//        }else {
//        txtVisor.setText(visor=visor +"+");
//        }
//        }
//        });
//
//         final Button btnMenos = (Button) findViewById(R.id.btnMenus);
//         btnMenos.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        // txtVisor.setText(visor=visor +"-");
//
//        // endsWith faz a busca no visor do sinal +
//        // visor.substring corta as casa para localizar a posiçao do sinal,começando a conta do "0"
//        //visor.length() me passa qual a ultima posição do visor, mais como coeça a contagem do numero "0" acrescentamos o  -1
//
//        if (visor.endsWith("+")){
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() -1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//
//
//        }if (visor.endsWith("x")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//        }if (visor.endsWith("÷")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "-";
//        txtVisor.setText(visor);
//        }else {
//        txtVisor.setText(visor=visor +"-");
//        }
//
//
//        }
//        });
//
//
//         final Button btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
//         btnMultiplicar.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        // txtVisor.setText(visor=visor +"x");
//
//        if (visor.endsWith("+")){
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() -1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//
//
//        }if (visor.endsWith("-")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//        }if (visor.endsWith("÷")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "x";
//        txtVisor.setText(visor);
//        }else {
//        txtVisor.setText(visor=visor +"x");
//        }
//        }
//        });
//         final Button btnDividir = (Button) findViewById(R.id.btnDividir);
//         btnDividir.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//        //txtVisor.setText(visor=visor +"÷");
//
//        if (visor.endsWith("+")){
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() -1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//
//
//        }if (visor.endsWith("x")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "";
//        txtVisor.setText(visor);
//
//        }if (visor.endsWith("-")) {
//        // recebendo o corte do visor
//        String operacao = visor.substring(0, visor.length() - 1);
//        //subistituindo o sinal  do visor
//        visor = operacao + "÷";
//        txtVisor.setText(visor);
//        }else {
//        txtVisor.setText(visor=visor +"÷");
//        }
//        }
//        });
//
//
//         final Button btnDel = (Button) findViewById(R.id.btnDel);
//         btnDel.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View view) {
//        String del = visor.substring(0, visor.length() -1);
//        visor=del;
//        txtVisor.setText(visor);
//
//        if(visor.length() ==0){
//        visor="";
//        txtVisor.setText(visor);
//        }
//        }
//        });
//
//
//
//         }**/
//
//        public void onClickNumeros(View v){
//            Button botaoTocado = (Button) v;
//            String digito = botaoTocado.getText().toString();
//
//            String textoNoVisor = txtVisor.getText().toString();
//
//            if (!usuarioEstaDigitandoUmNumero || textoNoVisor.equals("0")) {
//
//                txtVisor.setText(digito);
//                if (!digito.equals("0")) {
//                    usuarioEstaDigitandoUmNumero = true;
//                } else {
//                    txtVisor.setText(textoNoVisor + digito);
//                }
//            }
//        }
//
//        public void onClickOperacoes (View v){
//            Button botaoTocado = (Button) v;
//            String operacao = botaoTocado.getText().toString();
//
//            if (operacao.equals(",") && !separadorDecimalFoiDigitado) {
//                separadorDecimalFoiDigitado = true;
//                if (!usuarioEstaDigitandoUmNumero) {
//                    txtVisor.setText("0" + ",");
//                } else {
//                    txtVisor.setText(txtVisor.getText().toString() + ",");
//                    usuarioEstaDigitandoUmNumero = true;
//
//                }
//            } else if (!operacao.equals(",")) {
//                String valorSemVirgula = txtVisor.getText().toString().replace(',', '.');
//                calc.setOperando(Double.parseDouble(valorSemVirgula));
//                calc.realizarOperacao(operacao);
//
//                String textoResultado = String.valueOf(calc.getOperando());
//
//                if (textoResultado.endsWith(".0")) {
//                    textoResultado = textoResultado.substring(0, textoResultado.length() - 2);
//
//                } else {
//                    txtVisor.setText(textoResultado.replace('.', ','));
//                    usuarioEstaDigitandoUmNumero = false;
//                    separadorDecimalFoiDigitado = false;
//                }
//            }
//        }
//        public void onClickMemoria (View v){
//
//            Button botaoTocado = (Button) v;
//            String operacaoMemoria = botaoTocado.getText().toString();
//            String valorSemVirgula = txtVisor.getText().toString().replace(',', '.');
//
//            calc.setOperando(Double.parseDouble(valorSemVirgula));
//            calc.realizaOperacaoDeMemoria(operacaoMemoria);
//
//            usuarioEstaDigitandoUmNumero = false;
//
//        }
//    }
//}
