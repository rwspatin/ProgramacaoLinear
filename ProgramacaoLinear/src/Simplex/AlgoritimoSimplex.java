/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

/**
 *
 * @author Renan Winter Spatin e Nikollas Gabriel Assumpção
 */
public class AlgoritimoSimplex {
    //Simplex Quadro
    
    int qtdColunas=0;
    
    public AlgoritimoSimplex(){
    
    }
    
    public void resolve(int[][] in, int linhaFunObj, int qtdX, int qtdF, int qtdA){
        System.out.println("\n\t\tBigM");
        
        qtdColunas=qtdX+qtdF+qtdA;
        
        imprime(in);
        bigM(in, linhaFunObj, qtdX, qtdF, qtdA);
    }
    
    //Tem que informar a quantidade de x e quantidade de folgas que tem para acrescentar direto na artificial
    private void bigM(int[][] in, int linhaFunObj, int qtdX, int qtdF, int qtdA){
        
        int m = 0;
        int numb=0;
        
        //construindo o m
        m=Integer.MAX_VALUE;
        
        //Saber quantas casas vai pular para chegar na artificial
        int pular = qtdX+qtdF;
        
        //saber até onde ir para não fazer nada na coluna B
        int chegar = pular+qtdA;
        //Conta quantos m's existem
        int contador =0;
        for(int i=pular; i<chegar;i++){
            numb = in[linhaFunObj][i];
            in[linhaFunObj][i] += m;
            contador++;
        }
        imprime(in);
        //Chama a função para fazer a segunda iteração de bigM
        bigMSegPart(in,pular,chegar,contador,linhaFunObj);
    }
    
    private void bigMSegPart(int[][] in, int pular, int chegar, int qtdM, int linhaFunObj){
        int num=0;
        //Vai fazer ate acabar os m's acrescentados
        for(int i=pular; i<chegar;i++){
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
        imprime(in);
        int colunaB = chegar+1;
        selecionaPivot(in, linhaFunObj,colunaB);
    }
    
    private void selecionaPivot(int [][] in, int linhaFunObj, int colunaB){
        int menor=0;
        int divisao =0;
        
        int colunaPivot=0, linhaPivot=0;
        
        //Seleciona coluna privot
        for (int i=0; i<in.length;i++){
            if(in[linhaFunObj][i]<menor){
                menor = in[linhaFunObj][i];
                colunaPivot = i;
            }
        }
        
        divisao=(in[0][colunaB]/in[0][colunaPivot]);
        int d=0;
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
        imprime(in);
        //chama a função para terminar o trabalho
        pivot(in, linhaPivot, colunaPivot);
    }
    
    private void pivot (int [][] in, int linhaPivot, int colunaPivot) {
	//Pega o numero para dividir as linhas
        int numero = 0;
        numero=in[linhaPivot][colunaPivot];
        
        //Divide cada coluna da linha pivot pelo numero pivot
        for(int i=0; i<in.length;i++){
            in[linhaPivot][i] /= numero;
        }
        imprime(in);
        interaLinhas(in, linhaPivot, colunaPivot);
    }
    
    //Funcao para fazer aquela parada das linhas que vai fazendo conta com a pivot
    private int[][] interaLinhas(int [][] in, int linhaPivot, int colunaPivot){
        int n=0;
        
        //Se ainda tiver numeros negativos continua a iteração
        if(confereQuadroOtimo(in)>0){
            for(int i=0; i<in.length;i++){
            //Numero para calculo da linha
            n=in[i][colunaPivot];
            
            //Se não for linha pivot pode iterar
            if(!(i==linhaPivot)){
                //cada coluna vai fazer uma conta diferente
                for(int j=0; j<in.length; j++){
                    in[i][j] -= in[linhaPivot][j];
                }
            }
            }
        }else{
            System.out.println("O quadro é otimo");
        }
        
        imprime(in);
        //retorn o novo quadro
        return in;
    }
    
    private int confereQuadroOtimo(int[][] in){
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
    
    public void imprime(int[][] in){
        System.out.println("\n\n--------------------------------");
        for(int i=0;i<in.length;i++){
            for(int j=0;j<qtdColunas;j++){
                System.out.println(" "+in[i][j]+" ");
            }
        }
    }
}
