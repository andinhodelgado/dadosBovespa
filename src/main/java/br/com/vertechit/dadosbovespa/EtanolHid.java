/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.EtanolHidBean;
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
public class EtanolHid {
    
    public ArrayList<EtanolHidBean> execCon() throws IOException{
        ArrayList<EtanolHidBean> ceb = new ArrayList<EtanolHidBean>();
        
        Document doc = Jsoup.connect("http://www.cepea.esalq.usp.br/br/indicador/etanol.aspx").get();
        
        Elements tableElements = doc.select("table#imagenet-indicador1");
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 0; i < 15; i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            ceb.add(new EtanolHidBean(rowItems.get(0).text().substring(5, 15),
                                      rowItems.get(1).text(),
                                      rowItems.get(2).text()
                    ));
         }
        
        return ceb;
    }
    
}
