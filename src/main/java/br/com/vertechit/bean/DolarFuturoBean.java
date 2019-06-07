/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class DolarFuturoBean {
    
    private String VENTO;
    private double PRECO_ABERT;
    private double PRECO_MIN;
    private double PRECO_MAX;
    private double PRECO_MED;
    private double PRECO_ULT;
    private double PRECO_AJUSTE;
    private String VAR_PTOS;
    private double PRECO_ULT_COMPRA;
    private double PRECO_ULT_VENDA;

    public DolarFuturoBean(String VENTO,String PRECO_ABERT,String PRECO_MIN,String PRECO_MAX,String PRECO_MED,String PRECO_ULT,String PRECO_AJUSTE,String VAR_PTOS,String PRECO_ULT_COMPRA,String PRECO_ULT_VENDA){
        setVENTO(VENTO);
        setPRECO_ABERT( Double.parseDouble( PRECO_ABERT.replace(".","").replaceAll(",", ".")));
        setPRECO_MIN( Double.parseDouble( PRECO_MIN.replace(".","").replaceAll(",", ".")));
        setPRECO_MAX( Double.parseDouble( PRECO_MAX.replace(".","").replaceAll(",", ".")));
        setPRECO_MED( Double.parseDouble( PRECO_MED.replace(".","").replaceAll(",", ".")));
        setPRECO_ULT( Double.parseDouble( PRECO_ULT.replace(".","").replaceAll(",", ".")));
        setPRECO_AJUSTE( Double.parseDouble( PRECO_AJUSTE.replace(".","").replaceAll(",", ".")));
        setVAR_PTOS(VAR_PTOS);
        setPRECO_ULT_COMPRA( Double.parseDouble( PRECO_ULT_COMPRA.replace(".","").replaceAll(",", ".")));
        setPRECO_ULT_VENDA( Double.parseDouble( PRECO_ULT_VENDA.replace(".","").replaceAll(",", ".")));
    }
    
    /**
     * @return the VENTO
     */
    public String getVENTO() {
        return VENTO;
    }

    /**
     * @param VENTO the VENTO to set
     */
    public void setVENTO(String VENTO) {
        this.VENTO = VENTO;
    }

    /**
     * @return the PRECO_ABERT
     */
    public double getPRECO_ABERT() {
        return PRECO_ABERT;
    }

    /**
     * @param PRECO_ABERT the PRECO_ABERT to set
     */
    public void setPRECO_ABERT(double PRECO_ABERT) {
        this.PRECO_ABERT = PRECO_ABERT;
    }

    /**
     * @return the PRECO_MIN
     */
    public double getPRECO_MIN() {
        return PRECO_MIN;
    }

    /**
     * @param PRECO_MIN the PRECO_MIN to set
     */
    public void setPRECO_MIN(double PRECO_MIN) {
        this.PRECO_MIN = PRECO_MIN;
    }

    /**
     * @return the PRECO_MAX
     */
    public double getPRECO_MAX() {
        return PRECO_MAX;
    }

    /**
     * @param PRECO_MAX the PRECO_MAX to set
     */
    public void setPRECO_MAX(double PRECO_MAX) {
        this.PRECO_MAX = PRECO_MAX;
    }

    /**
     * @return the PRECO_MED
     */
    public double getPRECO_MED() {
        return PRECO_MED;
    }

    /**
     * @param PRECO_MED the PRECO_MED to set
     */
    public void setPRECO_MED(double PRECO_MED) {
        this.PRECO_MED = PRECO_MED;
    }

    /**
     * @return the PRECO_ULT
     */
    public double getPRECO_ULT() {
        return PRECO_ULT;
    }

    /**
     * @param PRECO_ULT the PRECO_ULT to set
     */
    public void setPRECO_ULT(double PRECO_ULT) {
        this.PRECO_ULT = PRECO_ULT;
    }

    /**
     * @return the PRECO_AJUSTE
     */
    public double getPRECO_AJUSTE() {
        return PRECO_AJUSTE;
    }

    /**
     * @param PRECO_AJUSTE the PRECO_AJUSTE to set
     */
    public void setPRECO_AJUSTE(double PRECO_AJUSTE) {
        this.PRECO_AJUSTE = PRECO_AJUSTE;
    }

    /**
     * @return the VAR_PTOS
     */
    public String getVAR_PTOS() {
        return VAR_PTOS;
    }

    /**
     * @param VAR_PTOS the VAR_PTOS to set
     */
    public void setVAR_PTOS(String VAR_PTOS) {
        this.VAR_PTOS = VAR_PTOS;
    }

    /**
     * @return the PRECO_ULT_COMPRA
     */
    public double getPRECO_ULT_COMPRA() {
        return PRECO_ULT_COMPRA;
    }

    /**
     * @param PRECO_ULT_COMPRA the PRECO_ULT_COMPRA to set
     */
    public void setPRECO_ULT_COMPRA(double PRECO_ULT_COMPRA) {
        this.PRECO_ULT_COMPRA = PRECO_ULT_COMPRA;
    }

    /**
     * @return the PRECO_ULT_VENDA
     */
    public double getPRECO_ULT_VENDA() {
        return PRECO_ULT_VENDA;
    }

    /**
     * @param PRECO_ULT_VENDA the PRECO_ULT_VENDA to set
     */
    public void setPRECO_ULT_VENDA(double PRECO_ULT_VENDA) {
        this.PRECO_ULT_VENDA = PRECO_ULT_VENDA;
    }
    
}
