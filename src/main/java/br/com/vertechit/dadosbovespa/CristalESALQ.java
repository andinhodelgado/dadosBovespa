/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.CristalESALQBean;
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
public class CristalESALQ {
    
    public ArrayList<CristalESALQBean> execCon() throws IOException{
        ArrayList<CristalESALQBean> ceb = new ArrayList<CristalESALQBean>();
        
        Document doc = Jsoup.connect("http://www.cepea.esalq.usp.br/br/indicador/acucar.aspx").get();
        
        Element tableElements = doc.select("table#imagenet-indicador1").first();
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 0; i < 15; i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            
            ceb.add(new CristalESALQBean(convertTelaData(rowItems.get(0).text()),
                                         convertTelaData(rowItems.get(1).text()),
                                         convertTelaData(rowItems.get(2).text()),
                                         convertTelaData(rowItems.get(3).text()),
                                         convertTelaData(rowItems.get(4).text())));
         }
        
        return ceb;
    }
    
    private String convertTelaData(String tela) {
        String ret;
        ret = tela.replace("%", "");
        return ret;
    }
    
}
