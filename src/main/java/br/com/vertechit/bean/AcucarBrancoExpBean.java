/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class AcucarBrancoExpBean {
    
    private String DATA;
    private double VALOR;
    private double VAR_MES;
    private double VALOR_DOLAR;
    
    public AcucarBrancoExpBean(String DATA, String VALOR, String VAR_MES, String VALOR_DOLAR){
        setDATA(DATA);
        setVALOR(Double.parseDouble(VALOR.replace(",", ".")));
        setVAR_MES(Double.parseDouble(VAR_MES.replace(",", ".").substring(0,VAR_MES.length() - 1)));
        setVALOR_DOLAR(Double.parseDouble(VALOR_DOLAR.replace(",", ".")));
    }

    /**
     * @return the DATA
     */
    public String getDATA() {
        return DATA;
    }

    /**
     * @param DATA the DATA to set
     */
    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    /**
     * @return the VALOR
     */
    public double getVALOR() {
        return VALOR;
    }

    /**
     * @param VALOR the VALOR to set
     */
    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }

    /**
     * @return the VAR_MES
     */
    public double getVAR_MES() {
        return VAR_MES;
    }

    /**
     * @param VAR_MES the VAR_MES to set
     */
    public void setVAR_MES(double VAR_MES) {
        this.VAR_MES = VAR_MES;
    }

    /**
     * @return the VALOR_DOLAR
     */
    public double getVALOR_DOLAR() {
        return VALOR_DOLAR;
    }

    /**
     * @param VALOR_DOLAR the VALOR_DOLAR to set
     */
    public void setVALOR_DOLAR(double VALOR_DOLAR) {
        this.VALOR_DOLAR = VALOR_DOLAR;
    }
    
}
