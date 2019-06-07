/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.DiPreBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author home
 */
public class DiPre {
    
    public ArrayList<DiPreBean> execCon(String data) throws IOException{
        
        StringTokenizer st = new StringTokenizer(data, "/");
        
        String dia = st.nextToken();
        String mes = st.nextToken();
        String ano = st.nextToken();
        
        Document doc = Jsoup.connect("http://www2.bmf.com.br/pages/portal/bmfbovespa/boletim1/TxRef1.asp?Data="+data+"&Data1="+ano+mes+dia+"&slcTaxa=PRE").get();
        Elements tableElements = doc.select("table#tb_principal1");
        
        Elements tableHeaderEles = tableElements.select("thead tr th");
        
        //System.out.println("headers");
        for (int i = 0; i < tableHeaderEles.size(); i++) {
            System.out.println(tableHeaderEles.get(i).text());
        }
        //System.out.println();
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        ArrayList<DiPreBean> dpb = new ArrayList<DiPreBean> ();
        
        for (int i = 2; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            //System.out.println("row"+i);
            Elements rowItems = row.select("td");
            
            dpb.add(new DiPreBean(rowItems.get(0).text(), rowItems.get(1).text(),rowItems.get(2).text()));
            
            //for (int j = 0; j < rowItems.size(); j++) {
              //  System.out.println(rowItems.get(j).text());
            //}
         }
        return dpb;

    }
    
}
