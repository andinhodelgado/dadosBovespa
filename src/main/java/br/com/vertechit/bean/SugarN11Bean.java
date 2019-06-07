/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean;

/**
 *
 * @author home
 */
public class SugarN11Bean {
    private String TELA;
    private double OPEN;
    private double HIGH;
    private double LOW;
    private double LAST;
    private int VOL;
    private int OP_INT;
    
    public SugarN11Bean(String TELA,String OPEN,String HIGH,String LOW,String LAST,String VOL,String OP_INT){
        setTELA(TELA);
        setOPEN(Double.parseDouble(OPEN));
        setHIGH(Double.parseDouble(HIGH));
        setLOW(Double.parseDouble(LOW));
        setLAST(Double.parseDouble(LAST.replace("*", "")));
        setVOL(Integer.parseInt(VOL));
        setOP_INT(Integer.parseInt(OP_INT));
    }

    /**
     * @return the TELA
     */
    public String getTELA() {
        return TELA;
    }

    /**
     * @param TELA the TELA to set
     */
    public void setTELA(String TELA) {
        this.TELA = TELA;
    }

    /**
     * @return the OPEN
     */
    public double getOPEN() {
        return OPEN;
    }

    /**
     * @param OPEN the OPEN to set
     */
    public void setOPEN(double OPEN) {
        this.OPEN = OPEN;
    }

    /**
     * @return the HIGH
     */
    public double getHIGH() {
        return HIGH;
    }

    /**
     * @param HIGH the HIGH to set
     */
    public void setHIGH(double HIGH) {
        this.HIGH = HIGH;
    }

    /**
     * @return the LOW
     */
    public double getLOW() {
        return LOW;
    }

    /**
     * @param LOW the LOW to set
     */
    public void setLOW(double LOW) {
        this.LOW = LOW;
    }

    /**
     * @return the LAST
     */
    public double getLAST() {
        return LAST;
    }

    /**
     * @param LAST the LAST to set
     */
    public void setLAST(double LAST) {
        this.LAST = LAST;
    }

    /**
     * @return the VOL
     */
    public int getVOL() {
        return VOL;
    }

    /**
     * @param VOL the VOL to set
     */
    public void setVOL(int VOL) {
        this.VOL = VOL;
    }

    /**
     * @return the OP_INT
     */
    public int getOP_INT() {
        return OP_INT;
    }

    /**
     * @param OP_INT the OP_INT to set
     */
    public void setOP_INT(int OP_INT) {
        this.OP_INT = OP_INT;
    }
    
}
