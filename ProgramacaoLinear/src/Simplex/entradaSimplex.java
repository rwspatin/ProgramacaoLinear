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
public class entradaSimplex {
    Double[][] li;
    int qtdVariavel, qtdFolga, qtdA, linhaFuncObj;
    
    
    
    
    
    
    //FUNÇÕES USADAS PARA SETAR VARIAVEIS QUE SERÃO NECESSÁRIAS NO ALGORITIMO
    
    public void setPosicaoFuncObj(int i){
        linhaFuncObj=i;
    }
    
    public void somaVariavel(){
        qtdVariavel++;
    }
    
    public void somaFolga(){
        qtdFolga++;
    }
    
    public void somaA(){
        qtdA++;
    }
}
