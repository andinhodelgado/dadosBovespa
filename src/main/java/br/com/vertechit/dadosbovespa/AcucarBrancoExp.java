/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.AcucarBrancoExpBean;
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
public class AcucarBrancoExp {
    
    public ArrayList<AcucarBrancoExpBean> execCon() throws IOException{
        ArrayList<AcucarBrancoExpBean> ceb = new ArrayList<AcucarBrancoExpBean>();
        
        Document doc = Jsoup.connect("http://www.cepea.esalq.usp.br/br/indicador/acucar-sao-paulo-mercado-externo.aspx").get();
        
        Elements tableElements = doc.select("table#imagenet-indicador2");
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 0; i < 15 ; i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            ceb.add(new AcucarBrancoExpBean(convertVenctoData(rowItems.get(0).text()),
                                         rowItems.get(1).text(),
                                         rowItems.get(2).text(),
                                         rowItems.get(3).text()));
         }
        
        return ceb;
    }
 
    private String convertVenctoData(String vencto){
        
        String ret;
        
        ret = vencto.replace("jan ", "01/")
                .replace("fev ", "02/")
                .replace("mar ", "03/")
                .replace("abr ", "04/")
                .replace("mai ", "05/")
                .replace("jun ", "06/")
                .replace("jul ", "07/")
                .replace("ago ", "08/")
                .replace("set ", "09/")
                .replace("out ", "10/")
                .replace("nov ", "11/")
                .replace("dez ", "12/");
        
        ret = "01/"+ret;
        
        return ret;
    }
    
}
