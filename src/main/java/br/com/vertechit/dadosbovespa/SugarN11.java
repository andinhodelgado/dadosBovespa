/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.SugarN11Bean;
import com.gargoylesoftware.htmlunit.WebClient;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 *
 * @author home
 */
public class SugarN11 {

    public ArrayList<SugarN11Bean> execCon() throws IOException, Exception {
        ArrayList<SugarN11Bean> snb = new ArrayList<SugarN11Bean>();

        String phantomjsExeutableFilePath = "C:/oracle/phantomjs.exe";
        System.setProperty("phantomjs.binary.path", phantomjsExeutableFilePath);

        // Initiate PhantomJSDriver.
        WebDriver driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        
        driver.get("http://data.tradingcharts.com/futures/quotes/SB.html");
        
//        Document doc = Jsoup.connect("http://data.tradingcharts.com/futures/quotes/SB.html").get();
        Document doc = Jsoup.parse(driver.getPageSource());

        driver.quit();
        
        Elements tableElements = doc.select("table.fe_quotes");
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        
        for (int i = 2; i < tableRowElements.size(); i++) {
            
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            
            if(!rowItems.get(0).text().contains("Cash")){
                snb.add(new SugarN11Bean(convertTelaData(rowItems.get(0).text()),
                        rowItems.get(1).text().replace("-", "0"),
                        rowItems.get(2).text().replace("-", "0"),
                        rowItems.get(3).text().replace("-", "0"),
                        rowItems.get(4).text().replace("-", "0"),
                        rowItems.get(8).text().replace("-", "0"),
                        rowItems.get(10).text().replace("-", "0")
                        ));
            }
         }
        return snb;
    }

    private String convertTelaData(String tela) {

        String ret;

        ret = tela.replace("Jan", "01")
                .replace("Feb", "02")
                .replace("Mar", "03")
                .replace("Apr", "04")
                .replace("May", "05")
                .replace("Jun", "06")
                .replace("Jul", "07")
                .replace("Aug", "08")
                .replace("Sep", "09")
                .replace("Oct", "10")
                .replace("Nov", "11")
                .replace("Dec", "12");

        ret = ret.replace("'", "/20");

        ret = "01/" + ret;

        return ret;
    }

}
