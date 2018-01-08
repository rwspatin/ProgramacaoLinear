/**
 * *********************************************************
 * ALUNOS: NIKOLLAS G. ASSUMPÇÂO & RENAN WINTER SPATIN *
 ***********************************************************
 */
//Oferta == Linha / Demanda == Coluna
package Transporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SolucaoVoguelTransporte {

    public void metodoVoguel(TabelaTransporte tabela) {

        ArrayList<Integer> ofertasEsgotadas = new ArrayList<>();
        ArrayList<Integer> demandasEsgotadas = new ArrayList<>();

        while (ofertasEsgotadas.size() != tabela.getTamanhoOfertas() && demandasEsgotadas.size() != tabela.getTamanhoDemandas()) {

            calcularPenalidades(tabela);
            Float menorCusto = selecionarMenorCusto(tabela);

            ArrayList<Integer> coordenadas = getCoordenadas(menorCusto, tabela);
            
            Float oferta = tabela.getOfertas()[coordenadas.get(0)];
            Float demanda = tabela.getDemandas()[(coordenadas.get(1))];
            
            /*if(oferta.equals(0) && float){
                
            }*/
            
            
        }

    }

    public Float selecionarMenorCustoLinha(Integer linha, TabelaTransporte tabela) {

        ArrayList<Float> LinhaMaiorPenalidade = new ArrayList<>();
        LinhaMaiorPenalidade.addAll(Arrays.asList(tabela.getCustosTransporte()[linha]));

        Float menorCusto = Collections.min(LinhaMaiorPenalidade);

        return menorCusto;
    }

    public Float selecionarMenorCustoColuna(Integer coluna, TabelaTransporte tabela) {

        ArrayList<Float> ColunaMaiorPenalidade = new ArrayList<>();

        Float[][] demanda = tabela.getCustosTransporte();

        for (int linha = 0; linha < tabela.getTamanhoOfertas(); linha++) {

            ColunaMaiorPenalidade.add(demanda[linha][coluna]);

        }

        Float menorCusto = Collections.min(ColunaMaiorPenalidade);

        return menorCusto;
    }

    public Float selecionarMenorCusto(TabelaTransporte tabela) {

        //ESSE METODO CALCULA A MAIOR PENALIDADE ENTRE LINHAS E COLUNAS E
        //RETORNA A CELULA COM O MENOR CUSTO RELATIVA
        ArrayList<Float> PenalidadesOferta = new ArrayList<>();
        ArrayList<Float> PenalidadesDemanda = new ArrayList<>();

        PenalidadesOferta.addAll(Arrays.asList(tabela.getPenalidadesOferta()));
        PenalidadesDemanda.addAll(Arrays.asList(tabela.getPenalidadesDemanda()));

        Float x1 = Collections.max(PenalidadesOferta); //Linha
        Float x2 = Collections.max(PenalidadesDemanda); //Coluna

        Integer value = Float.compare(x1, x2);

        if (value < 0) {
            //PenalidadesDemanda.indexOf(x2);
            return selecionarMenorCustoColuna(PenalidadesDemanda.indexOf(x2), tabela);
        } else if (value > 0) {
            //PenalidadesOferta.indexOf(x1);
            return selecionarMenorCustoLinha(PenalidadesOferta.indexOf(x1), tabela);
        } else {
            //PenalidadesOferta.indexOf(x1);
            return selecionarMenorCustoLinha(PenalidadesOferta.indexOf(x1), tabela);
        }

    }

    public TabelaTransporte calcularPenalidades(TabelaTransporte tabela) {

        calcularPenalidaDeLinha(tabela);
        calcularPenalidadeColuna(tabela);

        return tabela;

    }

    public void calcularPenalidaDeLinha(TabelaTransporte tabela) {

        Float[][] oferta = tabela.getCustosTransporte();

        for (int linha = 0; linha < tabela.getTamanhoOfertas(); linha++) {

            ArrayList<Float> valores = new ArrayList<>();

            valores.addAll(Arrays.asList(oferta[linha]));

            tabela.getPenalidadesOferta()[linha] = calcularDiferenca(getDoisMenores(valores));

        }

    }

    public void calcularPenalidadeColuna(TabelaTransporte tabela) {

        Float[][] demanda = tabela.getCustosTransporte();

        for (int coluna = 0; coluna < tabela.getTamanhoDemandas(); coluna++) {

            for (int linha = 0; linha < tabela.getTamanhoOfertas(); linha++) {

                ArrayList<Float> valores = new ArrayList<>();

                valores.add(demanda[linha][coluna]);

                tabela.getPenalidadesDemanda()[coluna] = calcularDiferenca(getDoisMenores(valores));

            }

        }

    }

    public ArrayList<Float> getDoisMenores(ArrayList<Float> numeros) {

        ArrayList<Float> x = new ArrayList<>();

        Collections.sort(numeros);

        x.add(numeros.get(0));
        x.add(numeros.get(1));

        return x;

    }

    public Float calcularDiferenca(ArrayList<Float> valores) {

        return (valores.get(1) - valores.get(0));

    }

    public ArrayList<Integer> getCoordenadas(Float custo, TabelaTransporte tabela) {

        Float[][] demanda = tabela.getCustosTransporte();
        ArrayList<Integer> coordenadas = new ArrayList<>();

        for (int coluna = 0; coluna < tabela.getTamanhoDemandas(); coluna++) {

            for (int linha = 0; linha < tabela.getTamanhoOfertas(); linha++) {

                if ((demanda[linha][coluna]).equals(custo)) {
                    coordenadas.add(linha);
                    coordenadas.add(coluna);
                }

            }

        }

        return coordenadas;

    }

    /*public boolean quantidadeIgualDemanda() {

    }*/

}
