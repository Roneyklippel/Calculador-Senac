package es.br.senac.calculadora;
// declarando a class calculadora
public class Calculadora {
//declarando as variaveis do tipo double
    private double operando;
    private double  operandoAnterior;
    private  double memoria;
    //declarando as variavel do tipo String
    private String operadorAnterior;
   //private é para manter o principio do encapsolamento da orientação a objeto
    //e que seja acessado por quem não deve acessa os dados da classe

    // criando o metodo construtor
    public Calculadora(){
        operando=0;
        operandoAnterior=0;
        operadorAnterior="";
        memoria=0;
    }

    // aqui criamos metodo publico do tipo double para receber as informações das variaveis em private
    //getOperando retorna ou mostra no visor o resultado da operacao
    public double getOperando() {
        //return é a resposta da operacao
        return operando;
    }

    //setOperando recebe o numero digitado na calculadora e retorna ele no visor
    public  void setOperando(double operando) {
        //this.operando "this" significa que ele recebe ele mesmo
        this.operando= operando;
    }


    // metodo privado do tipo void, significa que ele sera usado internamente sem aparecer na tela


    private void realizarOperacaoAnterior(){
        // iniciando se existe uma operacao anterior pendente
        //! a esclamacao quer dizer que tem que ser difente de 0 ou vazio
        //equals ("") busca se o que esta no txtvisor está vazio
        if (!operadorAnterior.equals("")){
            if (operadorAnterior.equals("+")){
                operando = operandoAnterior + operando;}
            else if (operadorAnterior.equals("-")){
                operando =operandoAnterior - operando;
            }else if (operadorAnterior.equals("x")){
                operando = operandoAnterior * operando;
            }else  if (operadorAnterior.equals("/")){
                if (operando != 0){
                    operando = operandoAnterior / operando;
                }
            }
        }
    }

    //crinado a variavel do tipo String op
    public  void realizarOperacao(String op){
        if (op.equals("%")){
            operando =(operandoAnterior*operando)/100;
        }else if (op.equals("+/-")){
            operando = -operando;
        }else if (op.equals("C")){
            operando =0;
            memoria =0;
            operadorAnterior="";
        }else {
            realizarOperacaoAnterior();
            operadorAnterior =op;
            operandoAnterior=operando;

        }
    }

    //crinado a variavel do tipo String opm
    public  void realizaOperacaoDeMemoria(String opm){
        if (opm.equals("mc")){
            memoria = 0;
        }else if (opm.equals("m+")){
            memoria += operando;
        }else if (opm.equals("m-")){
            memoria -= operando;
        }else if (opm.equals("mr")){
            operando = memoria;
        }
    }
}
