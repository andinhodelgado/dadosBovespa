/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class DiPreBean {
    
    private int DIAS_CORRIDOS;
    private double DIAS_UTEIS;
    private double DIAS_ANO;
    
    public DiPreBean(String DIAS_CORRIDOS, String DIAS_UTEIS, String DIAS_ANO){
        setDIAS_CORRIDOS(Integer.parseInt(DIAS_CORRIDOS));
        setDIAS_UTEIS(Double.parseDouble(DIAS_UTEIS.replaceAll(",", ".")));
        setDIAS_ANO(Double.parseDouble(DIAS_ANO.replaceAll(",", ".")));
    }
    /**
     * @return the DIAS_CORRIDOS
     */
    public int getDIAS_CORRIDOS() {
        return DIAS_CORRIDOS;
    }

    /**
     * @param DIAS_CORRIDOS the DIAS_CORRIDOS to set
     */
    public void setDIAS_CORRIDOS(int DIAS_CORRIDOS) {
        this.DIAS_CORRIDOS = DIAS_CORRIDOS;
    }

    /**
     * @return the DIAS_UTEIS
     */
    public double getDIAS_UTEIS() {
        return DIAS_UTEIS;
    }

    /**
     * @param DIAS_UTEIS the DIAS_UTEIS to set
     */
    public void setDIAS_UTEIS(double DIAS_UTEIS) {
        this.DIAS_UTEIS = DIAS_UTEIS;
    }

    /**
     * @return the DIAS_ANO
     */
    public double getDIAS_ANO() {
        return DIAS_ANO;
    }

    /**
     * @param DIAS_ANO the DIAS_ANO to set
     */
    public void setDIAS_ANO(double DIAS_ANO) {
        this.DIAS_ANO = DIAS_ANO;
    }
    
}
