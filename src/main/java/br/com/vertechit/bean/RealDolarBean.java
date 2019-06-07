/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class RealDolarBean {
    
    private int DIAS_CORRIDOS;
    private double PRECO;
    
    public RealDolarBean(String DIAS_CORRIDOS, String PRECO){
        setDIAS_CORRIDOS(Integer.parseInt(DIAS_CORRIDOS));
        setPRECO(Double.parseDouble(PRECO.replaceAll(",", ".")));
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
     * @return the PRECO
     */
    public double getPRECO() {
        return PRECO;
    }

    /**
     * @param PRECO the PRECO to set
     */
    public void setPRECO(double PRECO) {
        this.PRECO = PRECO;
    }
    
            
}
