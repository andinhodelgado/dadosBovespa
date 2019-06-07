/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dadosbovespa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 *
 * @author anderson
 */
public class Teste {

    private static final int BUFFER_SIZE = 4096;

    public Teste() {
    }

    public void runPhantomjsWebDriver() {
        try {
            // Set phantomjs executable file path to system variable phantomjs.binary.path's value.
            String phantomjsExeutableFilePath = "C:/Users/anderson/Documents/NetBeansProjects/dadosBovespa/dadosBovespa/src/main/java/br/com/vertechit/dbutil/phantomjs.exe";
            System.setProperty("phantomjs.binary.path", phantomjsExeutableFilePath);

            // Initiate PhantomJSDriver.
            WebDriver driver = new PhantomJSDriver();
            driver.manage().window().maximize();

            driver.get("http://data.tradingcharts.com/futures/quotes/SB.html");

            Thread.sleep(3000);

            
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
