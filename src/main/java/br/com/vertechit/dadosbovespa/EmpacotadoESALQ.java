/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.EmpacotadoESALQBean;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author home
 */
public class EmpacotadoESALQ {
 
    public ArrayList<EmpacotadoESALQBean> execCon() throws IOException{
        ArrayList<EmpacotadoESALQBean> ceb = new ArrayList<EmpacotadoESALQBean>();
        
        Document doc = Jsoup.connect("http://www.cepea.esalq.usp.br/br/indicador/acucar-cristal-empacotado-cepea-esalq-sao-paulo.aspx").get();
        
        Element tableElements = doc.select("table#imagenet-indicador1").first();
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 0; i < 15; i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            
            ceb.add(new EmpacotadoESALQBean(rowItems.get(0).text(),
                                         rowItems.get(1).text(),
                                         rowItems.get(2).text(),
                                         rowItems.get(3).text(),
                                         rowItems.get(4).text()
            ));
         }
        
        return ceb;
    }
    
}
