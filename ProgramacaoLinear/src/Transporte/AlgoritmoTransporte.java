/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transporte;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS ALEJANDRO
 */
public class AlgoritmoTransporte {

    private Integer origem, destino, demandaTotal = 0, ofertaTotal = 0;
    private Double[][] custos;
    private Integer[][] oferta, demanda, unidades;

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Integer getDemandaTotal() {
        return demandaTotal;
    }

    public void setDemandaTotal(Integer demandaTotal) {
        this.demandaTotal = demandaTotal;
    }

    public Integer getOfertaTotal() {
        return ofertaTotal;
    }

    public void setOfertaTotal(Integer ofertaTotal) {
        this.ofertaTotal = ofertaTotal;
    }

    public Double[][] getCustos() {
        return custos;
    }

    public void setCustos(Double[][] custos) {
        this.custos = custos;
    }

    public Integer[][] getOferta() {
        return oferta;
    }

    public void setOferta(Integer[][] oferta) {
        this.oferta = oferta;
    }

    public Integer[][] getDemanda() {
        return demanda;
    }

    public void setDemanda(Integer[][] demanda) {
        this.demanda = demanda;
    }

    public Integer[][] getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer[][] unidades) {
        this.unidades = unidades;
    }
    public void criarTabela(){
        
    }

    public void criarTabela(JTable restricoes, DefaultTableModel custosModel) {
        Object[] cabecera = new String[destino + 2];
        cabecera[0] = " ";
        cabecera[destino + 1] = "Oferta";
        int opcao = JOptionPane.showOptionDialog(null, "Deseja Colocar os nomes de origem de destino?\nSim seleciona \"Nao\" será colocado números em seu lugar", "Método de Transporte", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SIM", "NAO"}, "SIM");
        if (opcao == 0) {
            while (custosModel.getRowCount() > 0) {
                custosModel.removeRow(0);
            }
            for (int i = 1; i <= destino; i++) {
                cabecera[i] = JOptionPane.showInputDialog(null, "Escreva o nome do destino " + (i), JOptionPane.INFORMATION_MESSAGE);
            }
            custosModel = new DefaultTableModel(cabecera, 0) {
                public boolean isCellEditable(int row, int column) {
                    if (column == 0 || (row == restricoes.getRowCount() - 1 && column == restricoes.getColumnCount() - 1)) {
                        return false;
                    }
                    return true;
                }
            };
            restricoes.setModel(custosModel);
            String fila[] = new String[destino + 2];
            for (int i = 0; i < origem; i++) {
                fila[0] = JOptionPane.showInputDialog(null, "Escrva o nome da origem " + (i + 1), JOptionPane.INFORMATION_MESSAGE);
                custosModel.addRow(fila);
            }
            fila[0] = "Demanda";
            custosModel.addRow(fila);
        } else {
            while (custosModel.getRowCount() > 0) {
                custosModel.removeRow(0);
            }
            for (int i = 1; i <= destino; i++) {
                cabecera[i] = new String("Destino " + (i));
            }
            custosModel = new DefaultTableModel(cabecera, 0) {
                public boolean isCellEditable(int row, int column) {
                    if (column == 0 || (row == restricoes.getRowCount() - 1 && column == restricoes.getColumnCount() - 1)) {
                        return false;
                    }
                    return true;
                }
            };
            restricoes.setModel(custosModel);
            String fila[] = new String[destino + 2];
            for (int i = 0; i < origem; i++) {
                fila[0] = new String("Origem " + (i + 1));
                custosModel.addRow(fila);
            }
            fila[0] = "Demanda";
            custosModel.addRow(fila);
        }
    }

}
