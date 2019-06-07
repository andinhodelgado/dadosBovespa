/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.DolarFuturoBean;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author home
 */
public class DolarFuturo {
    
    public ArrayList<DolarFuturoBean> execCon(){
        
        //String[] vencto = null;
        ArrayList<String> vencto = new ArrayList<String>();
        
        ArrayList<DolarFuturoBean> dfb = new ArrayList<DolarFuturoBean> ();
        
        //WebDriver driver = new MyHtmlUnitDriver(true);
        WebDriver driver;
        driver = new HtmlUnitDriver(true) {
          @Override
          protected WebClient modifyWebClient(final WebClient client) {
              client.getOptions().setThrowExceptionOnScriptError(false);
              return client;
          }
        };
                
        // And now use this to visit Google
        driver.get("http://www2.bmf.com.br/pages/portal/bmfbovespa/boletim1/SistemaPregao1.asp?pagetype=pop&caminho=&Data=&Mercadoria=DOL");

        Document doc = Jsoup.parse(driver.getPageSource());
        
        //Close the browser
        driver.quit();
        
        Elements tableElements = doc.select("td#MercadoFut0 table");
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 1; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            vencto.add(rowItems.get(0).text());
         }
        
        tableElements = doc.select("td#MercadoFut2 table");
        
        tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 1; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");

            dfb.add(new DolarFuturoBean(convertVenctoData(vencto.get(i - 1)), // Vencto
                    rowItems.get(0).text(), // PREÇO ABERT.
                    rowItems.get(1).text(), // PREÇO MÍN.
                    rowItems.get(2).text(), // PREÇO MÁX.
                    rowItems.get(3).text(), // PREÇO MÉD.
                    rowItems.get(4).text(), // ÚLT. PREÇO
                    rowItems.get(5).text(), // AJUSTE
                    rowItems.get(6).text(), // VAR. PTOS.
                    rowItems.get(7).text(), // ÚLT. OF. COMPRA
                    rowItems.get(8).text()  // ÚLT. OF. VENDA
                    ));
            
         }
        
        return dfb;
        
    }
    
    private String convertVenctoData(String vencto){
        
        String ret;
        
        ret = vencto.replace("F", "01/20")
                .replace("G", "02/20")
                .replace("H", "03/20")
                .replace("J", "04/20")
                .replace("K", "05/20")
                .replace("M", "06/20")
                .replace("N", "07/20")
                .replace("Q", "08/20")
                .replace("U", "09/20")
                .replace("V", "10/20")
                .replace("X", "11/20")
                .replace("Z", "12/20");
        
        ret = "01/"+ret;
        
        return ret;
    }
    
}
