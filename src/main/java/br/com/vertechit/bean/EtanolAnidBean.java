/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class EtanolAnidBean {
    private String DT_ATE;
    private Double VLR_REAL;
    private Double VLR_DOLAR;

    public EtanolAnidBean(String DT_ATE, String VLR_REAL, String VLR_DOLAR){
        setDT_ATE(DT_ATE);
        setVLR_REAL(Double.parseDouble(VLR_REAL.replace(",", ".")));
        setVLR_DOLAR(Double.parseDouble(VLR_DOLAR.replace(",", ".")));
    }
    

    /**
     * @return the DT_ATE
     */
    public String getDT_ATE() {
        return DT_ATE;
    }

    /**
     * @param DT_ATE the DT_ATE to set
     */
    public void setDT_ATE(String DT_ATE) {
        this.DT_ATE = DT_ATE;
    }

    /**
     * @return the VLR_REAL
     */
    public Double getVLR_REAL() {
        return VLR_REAL;
    }

    /**
     * @param VLR_REAL the VLR_REAL to set
     */
    public void setVLR_REAL(Double VLR_REAL) {
        this.VLR_REAL = VLR_REAL;
    }

    /**
     * @return the VLR_DOLAR
     */
    public Double getVLR_DOLAR() {
        return VLR_DOLAR;
    }

    /**
     * @param VLR_DOLAR the VLR_DOLAR to set
     */
    public void setVLR_DOLAR(Double VLR_DOLAR) {
        this.VLR_DOLAR = VLR_DOLAR;
    }
    
    
}
