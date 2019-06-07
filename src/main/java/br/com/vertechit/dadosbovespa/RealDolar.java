package br.com.vertechit.dadosbovespa;

import br.com.vertechit.bean.RealDolarBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class RealDolar 
{
    public ArrayList<RealDolarBean> execCon(String data) throws IOException{
        
        StringTokenizer st = new StringTokenizer(data, "/");
        
        String dia = st.nextToken();
        String mes = st.nextToken();
        String ano = st.nextToken();
        
        Document doc = Jsoup.connect("http://www2.bmf.com.br/pages/portal/bmfbovespa/boletim1/TxRef1.asp?Data="+data+"&Data1="+ano+mes+dia+"&slcTaxa=PTX").get();
        Elements tableElements = doc.select("table#tb_principal1");
        
        Elements tableRowElements = tableElements.select(":not(thead) tr");
//        Elements tableRowElements = tableElements.select("tr");
        
        ArrayList<RealDolarBean> rdb = new ArrayList<RealDolarBean> ();
        
        for (int i = 2; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            
            rdb.add(new RealDolarBean(rowItems.get(0).text(), rowItems.get(1).text()));

         }
        return rdb;
    }
    
}
