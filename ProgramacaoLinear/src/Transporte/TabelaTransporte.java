/**
 * *********************************************************
 * ALUNOS: NIKOLLAS G. ASSUMPÇÂO & RENAN WINTER SPATIN *
 ***********************************************************
 */
package Transporte;

//Oferta == Linha / Demanda == Coluna
public class TabelaTransporte {

    private Float demandaTotal = 0F;
    private Float ofertaTotal = 0F;

    private Float[][] custosTransporte;

    private Float[] ofertas;
    private Float[] demandas;

    private Float[] penalidadesOferta;

    private Float[] penalidadesDemanda;

    public TabelaTransporte() {

    }

    public void setTamanhoOfertas(int tamanhoOfertas) {
        this.ofertas = new Float[tamanhoOfertas];
    }

    public int getTamanhoOfertas() {
        return this.ofertas.length;
    }

    public void setTamanhoDemandas(int tamanhoDemandas) {
        this.demandas = new Float[tamanhoDemandas];
    }

    public int getTamanhoDemandas() {
        return this.demandas.length;
    }

    public void setTamanhoCustosTransporte() {
        this.custosTransporte = new Float[ofertas.length][demandas.length];
    }

    public Float[][] getCustosTransporte() {
        return custosTransporte;
    }

    public void setTamanhoPenalidadesOferta() {
        this.penalidadesOferta = new Float[ofertas.length];

    }

    public Float[] getPenalidadesOferta() {
        return penalidadesOferta;
    }

    public void setTamanhoPenalidadesDemanda() {
        this.penalidadesDemanda = new Float[demandas.length];

    }

    public Float[] getPenalidadesDemanda() {
        return penalidadesDemanda;
    }

    public void setDemandaTotal() {
        if (this.demandas != null) {
            for (float valor : this.demandas) {
                this.demandaTotal = this.demandaTotal + valor;
            }
        }
    }

    public Float getDemandaTotal() {
        return demandaTotal;
    }

    public void setOfertaTotal() {
        if (this.ofertas != null) {
            for (float valor : this.ofertas) {
                this.ofertaTotal = this.ofertaTotal + valor;
            }
        }

    }

    public Float getOfertaTotal() {
        return ofertaTotal;
    }

}
