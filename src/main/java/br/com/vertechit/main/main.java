/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.main;


import br.com.vertechit.control.PrincipalCTR;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class main {

    public static void main(String args[]) {

        while (true) {
            try {
                SimpleDateFormat formata = new SimpleDateFormat("hh:mm");
                String data = formata.format(new Date());
                System.out.println("Data e Hora = " + data);
                
                if(data.equals("08:00")){
                    PrincipalCTR principalCTR = new PrincipalCTR();
                    principalCTR.capturaDados();
                }
                
                sleep(60*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
