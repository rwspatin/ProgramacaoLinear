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
    double[][] simp;
    
    
    public AlgoritimoSimplex(){
    
    }
    
    private void bigM(double[][] in, int linhaFunObj){
        //construindo o m
        double m = Double.MAX_VALUE;
        double numb=0;
        
        for(int i=0; i<in.length;i++){
            numb = in[linhaFunObj][i];
            //se for variavel artificial recebe o m
            if(numb==0){
                in[linhaFunObj][i] += m;
            }
        }
        //Chama a função para fazer a segunda iteração de bigM
        bigMSegPart(in);
    }
    
    private void bigMSegPart(double[][] in){
    
    }
    
    private void selecionaPivot(double [][] in, int linhaFunObj, int colunaB){
        double menor=0;
        //Não sei se faz sentido mas coloquei zero porque tem que selecionar o numero negativo
        int colunaPivot=0, linhaPivot=0;
        
        //Seleciona coluna privot
        for (int i=0; i<in.length;i++){
            if(in[linhaFunObj][i]<menor){
                menor = in[linhaFunObj][i];
                colunaPivot = i;
            }
        }
        
        double divisao=(in[0][colunaB]/in[0][colunaPivot]);
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
        double numero = in[linhaPivot][colunaPivot];
        
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
        //retorn o novo quadro
        return in;
    }
}
