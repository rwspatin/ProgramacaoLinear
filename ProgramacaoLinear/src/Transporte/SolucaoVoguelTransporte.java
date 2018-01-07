/**
 * *********************************************************
 * ALUNOS: NIKOLLAS G. ASSUMPÇÂO & RENAN WINTER SPATIN *
 ***********************************************************
 */
package Transporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SolucaoVoguelTransporte {

    public TabelaTransporte calcularPenalidades(TabelaTransporte tabela) {

    }

    public void calcularPenalidadeLinha(TabelaTransporte tabela) {

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

            for (int linha = 0; linha < tabela.getTamanhoOfertas(); coluna++) {

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

}
