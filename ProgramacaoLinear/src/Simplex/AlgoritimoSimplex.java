/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

/**
 *
 * @author rwspa
 */
public class AlgoritimoSimplex {
    //Simplex Quadro
    
    
    public AlgoritimoSimplex(){
    
    }
    
    //Tem que informar a quantidade de x e quantidade de folgas que tem para acrescentar direto na artificial
    private void bigM(double[][] in, int linhaFunObj, int qtdX, int qtdF, int qtdA){
        
        double m = 0;
        double numb=0;
        
        //construindo o m
        m=Double.MAX_VALUE;
        
        //Saber quantas casas vai pular para chegar na artificial
        int pular = qtdX+qtdF;
        
        //saber até onde ir para não fazer nada na coluna B
        int chegar = pular+qtdA;
        //Conta quantos m's existem
        int contador =0;
        for(int i=pular; i<=chegar;i++){
            numb = in[linhaFunObj][i];
            in[linhaFunObj][i] += m;
            contador++;
        }
        //Chama a função para fazer a segunda iteração de bigM
        bigMSegPart(in,pular,chegar,contador,linhaFunObj);
    }
    
    private void bigMSegPart(double[][] in, int pular, int chegar, int qtdM, int linhaFunObj){
        int num=0;
        //Vai fazer ate acabar os m's acrescentados
        for(int i=pular; i<=chegar;i++){
            //ve em qual linha esta o 1 para fazer aquela conta
            for(int j=0; i<in.length;j++){
                //Se acahr a linha que quer pega a posiçõa e sai do for
                if(in[j][i]==1){
                    num=j;
                    break;
                }
            }
            //Faz as contas com as linhas
            for(int k=0; k<in.length;k++){
                //a linha na função objetiva vai ser ela menos a linha achada no for anterior
                in[linhaFunObj][k] -= in[num][k];
            }
        }
        int colunaB = chegar+1;
        selecionaPivot(in, linhaFunObj,colunaB);
    }
    
    private void selecionaPivot(double [][] in, int linhaFunObj, int colunaB){
        double menor=0;
        double divisao =0;
        //Não sei se faz sentido mas coloquei zero porque tem que selecionar o numero negativo
        int colunaPivot=0, linhaPivot=0;
        
        //Seleciona coluna privot
        for (int i=0; i<in.length;i++){
            if(in[linhaFunObj][i]<menor){
                menor = in[linhaFunObj][i];
                colunaPivot = i;
            }
        }
        
        divisao=(in[0][colunaB]/in[0][colunaPivot]);
        double d=0;
        //Seleciona linha pivot
        //length-1 porque não conta a linha da funcao obj
        for(int j=0; j<(in.length-1);j++){
            //Divide a parada
            d = (in[j][colunaB]/in[j][colunaPivot]);
            //Se for menor do que existia ele vai ser selecionado
            if(d<divisao){
                divisao = d;
                linhaPivot = j;
            }
        }
        //chama a função para terminar o trabalho
        pivot(in, linhaPivot, colunaPivot);
    }
    
    private void pivot (double [][] in, int linhaPivot, int colunaPivot) {
	//Pega o numero para dividir as linhas
        double numero = 0;
        numero=in[linhaPivot][colunaPivot];
        
        //Acho que isso funciona
        //Divide cada coluna da linha pivot pelo numero pivot
        for(int i=0; i<in.length;i++){
            in[linhaPivot][i] /= numero;
        }
        interaLinhas(in, linhaPivot, colunaPivot);
    }
    
    //Funcao para fazer aquela parada das linhas que vai fazendo conta com a pivot
    private double[][] interaLinhas(double [][] in, int linhaPivot, int colunaPivot){
        double n=0;
        
        //Se ainda tiver numeros negativos continua a iteração
        if(confereQuadroOtimo(in)>0){
            for(int i=0; i<in.length;i++){
            //Numero para calculo da linha
            n=in[i][colunaPivot];
            
            //Se não for linha pivot pode iterar
            if(!(i==linhaPivot)){
                //cada coluna vai fazer uma conta diferente
                //Não sei de esse length vai funcionar aqui
                for(int j=0; j<in.length; j++){
                    in[i][j] -= in[linhaPivot][j];
                }
            }
            }
        }else{
            System.out.println("O quadro é otimo");
        }
        //retorn o novo quadro
        return in;
    }
    
    private int confereQuadroOtimo(double[][] in){
        int linhaFuncObj = in.length;
        //Contador de numeros negativos
        int qtdNegativo=0;
        
        for(int i=0; i<in.length;i++){
            if(in[linhaFuncObj][i]<0){
                qtdNegativo++;
            }
        }
        return qtdNegativo++;
    }
    
    public void imprime(char[][] in){
        String resultado = " ";
        for(int i=0;i<in.length;i++){
            for(int j=0;j<in.length;j++){
                resultado += in[i][j] + "\n";
            }
        }
        //Coloca o resultado em uma area de texto
        
        //txtArea.setText(resultado);
    }
}
