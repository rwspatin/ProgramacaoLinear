/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

import java.util.Scanner;

/**
 *
 * @author Renan Winter Spatin e Nikollas Gabriel Assumpção
 */
public class entradaSimplex {
    int[][] li;
    int qtdVariavel, qtdFolga, qtdA, linhaFuncObj;
    Scanner ler = new Scanner(System.in);
    Scanner l = new Scanner(System.in);
    
    
    int[][] variaveis;
    String[] simbolo;
    int[] folga;
    int[] artificial;
    int[] b;
    
    AlgoritimoSimplex bigm = new AlgoritimoSimplex();
    
    //conta numero de folgas para colocar posição da função objetiva
    int contador=0;
    
    //conta numero de variavel artificial
    int contadorA=0;
    
    //Conta linhas de restriçõe para vetor de restrições
    int linhasRestricao=0;
    
    
    public void executa(){
        int n=0;
        System.out.println("\n\t\tAlgoritmo Big M");
        System.out.println("Digite o número de restrições: ");
        n = ler.nextInt();
        
        System.out.println("Digite o numero de variaveis das retrições: ");
        qtdVariavel= ler.nextInt();                                                 //QTD VAriavel
        
        int setar = n+1;
        
        variaveis = new int[setar][qtdVariavel];
        simbolo = new String[setar];
        folga = new int[setar];
        artificial = new int[setar];
        b = new int[setar];
        
        for(linhasRestricao=0; linhasRestricao<n;linhasRestricao++){
            int v=0;
            System.out.println(linhasRestricao+"ª restrição");
            
            for(int j=0;j<qtdVariavel;j++){
                System.out.println("Digite o valor da "+j+"ª variavel: ");
                v = ler.nextInt();
                variaveis[linhasRestricao][j] = v;
            }
            System.out.println("<(Menor ou igual)\t >(maior ou igual)\t =(igual)");
            System.out.println("Digite o simbolo de igualdade: ");
            simbolo[linhasRestricao]=l.next();
            
            System.out.println("Digite o valor da restrição: ");
            b[linhasRestricao]=l.nextInt();
        }
        System.out.println(linhasRestricao);
        //System.out.println(linhasRestricao);
        System.out.println("Função objetiva");
        for(int k=0;k<qtdVariavel;k++){
            System.out.println("Escreva o "+k+"º valor: ");
            variaveis[linhasRestricao][k] = l.nextInt();
        }
        folgaEArtificial();
    }
    
    
    public void folgaEArtificial(){
        String simb;
        for(int i=0;i<linhasRestricao;i++){
            simb=simbolo[i];
            
            if(simb.equals("<")){
                folga[i]=1;
                artificial[i]=0;
                contador++;
            }else if(simb.equals(">")){
                folga[i]=(0-1);
                artificial[i]=1;
                contadorA++;
                
            }else if(simb.equals("=")){
                folga[i]=0;
                artificial[i]=1;
                contadorA++;
                
            }else{
                System.err.println("Erro em simbolo na posicao "+i+" simbolo digitado foi "+simb);
            }
        }
        
        //a posição da função objetiva é a quantidade de folga + variavel artificia(quando houver)
        setPosicaoFuncObj(linhasRestricao+1);                                       //Linha Função obj
        setFolga(contador);                                                         //QTD Folga
        setA(contadorA);                                                            //QTD Artificial
        
        
        preencheQuadro();
    }
    
    public void preencheQuadro(){
        int tamanho = linhasRestricao+1;
        int colunas = qtdVariavel+qtdFolga+qtdA+1;
        int posicaoF=0;
        
        li = new int[tamanho][colunas];
        
        for(int i=0; i<tamanho;i++){
            for(int j=0;j<qtdVariavel;j++){
                li[i][j]=variaveis[i][j];
            }
            
            
            for(int k=qtdVariavel;k<(qtdVariavel+contador);k++){
                //somente coloca o numero quando a folga for dessa posição, se não fica 0
                if((qtdVariavel+posicaoF)==k){
                    li[i][k]=folga[i];
                }else{
                    li[i][k]=0;
                }
            }
            
            
            for(int w=(qtdVariavel+contador);w<(qtdVariavel+contador+contadorA);w++){
                
                //somente coloca o numero quando a Artificial for dessa posição, se não fica 0
                if((qtdVariavel+contador+posicaoF)==w){
                    //muda o valor da variavel para negativo
                    if(folga[i]!=0){
                        li[i][w]=(-folga[i]);
                    }else{
                        li[i][w]=folga[i];
                    }
                    
                }else{
                    li[i][w]=0;
                }
            }
            posicaoF++;
            
            int x=0;
            for(x=0;x<linhasRestricao;x++){
                li[x][colunas-1]=b[x];
            }
            //o encontro de b com a função objetiva recebe 0
            li[x][colunas-1]=0;
        }
        
        //Chama função do do Algoritmo Simplex
        bigm.resolve(li, linhaFuncObj, qtdVariavel, qtdFolga, qtdA);
    }
    
    //FUNÇÕES USADAS PARA SETAR VARIAVEIS QUE SERÃO NECESSÁRIAS NO ALGORITIMO
    
    public void setPosicaoFuncObj(int i){
        linhaFuncObj=i;
    }
    
    public void setFolga(int i){
        qtdFolga=i;
    }
    
    public void setA(int i){
        qtdA=i;
    }
}
