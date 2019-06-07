/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class EmpacotadoESALQBean {
    
    private String DATA;
    private double VALOR;
    private double VAR_DIA;
    private double VAR_MES;
    private double VAL_DOLAR;

    public EmpacotadoESALQBean(String DATA, String VALOR, String VAR_DIA, String VAR_MES, String VAL_DOLAR){
        setDATA(DATA);
        setVALOR(Double.parseDouble(VALOR.replace(",", ".")));
        setVAR_DIA(Double.parseDouble(VAR_DIA.replace(",", ".").substring(0,VAR_DIA.length() - 1)));
        setVAR_MES(Double.parseDouble(VAR_MES.replace(",", ".").substring(0,VAR_MES.length() - 1)));
        setVAL_DOLAR(Double.parseDouble(VAL_DOLAR.replace(",", ".")));
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
     * @return the VAR_DIA
     */
    public double getVAR_DIA() {
        return VAR_DIA;
    }

    /**
     * @param VAR_DIA the VAR_DIA to set
     */
    public void setVAR_DIA(double VAR_DIA) {
        this.VAR_DIA = VAR_DIA;
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
     * @return the VAL_DOLAR
     */
    public double getVAL_DOLAR() {
        return VAL_DOLAR;
    }

    /**
     * @param VAL_DOLAR the VAL_DOLAR to set
     */
    public void setVAL_DOLAR(double VAL_DOLAR) {
        this.VAL_DOLAR = VAL_DOLAR;
    }
    
}
