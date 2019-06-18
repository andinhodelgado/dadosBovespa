/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.control;

import br.com.vertechit.bean.AcucarBrancoExpBean;
import br.com.vertechit.bean.CristalESALQBean;
import br.com.vertechit.bean.DiPreBean;
import br.com.vertechit.bean.DolarFuturoBean;
import br.com.vertechit.bean.EmpacotadoESALQBean;
import br.com.vertechit.bean.EtanolAnidBean;
import br.com.vertechit.bean.EtanolHidBean;
import br.com.vertechit.bean.RealDolarBean;
import br.com.vertechit.bean.SugarN11Bean;
import br.com.vertechit.bean.dao.AcucarBrancoExpDAO;
import br.com.vertechit.bean.dao.CristalESALQDAO;
import br.com.vertechit.bean.dao.DiPreDAO;
import br.com.vertechit.bean.dao.DolarFuturoDAO;
import br.com.vertechit.bean.dao.EmpacotadoESALQDAO;
import br.com.vertechit.bean.dao.EtanolAnidDAO;
import br.com.vertechit.bean.dao.EtanolHidDAO;
import br.com.vertechit.bean.dao.RealDolarDAO;
import br.com.vertechit.bean.dao.SugarN11DAO;
import br.com.vertechit.dadosbovespa.AcucarBrancoExp;
import br.com.vertechit.dadosbovespa.CristalESALQ;
import br.com.vertechit.dadosbovespa.DiPre;
import br.com.vertechit.dadosbovespa.DolarFuturo;
import br.com.vertechit.dadosbovespa.EmpacotadoESALQ;
import br.com.vertechit.dadosbovespa.EtanolAnid;
import br.com.vertechit.dadosbovespa.EtanolHid;
import br.com.vertechit.dadosbovespa.RealDolar;
import br.com.vertechit.dadosbovespa.SugarN11;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anderson
 */
public class PrincipalCTR {

    public PrincipalCTR() {
    }

    public void capturaDados() {

        RealDolar rd = new RealDolar();
        DiPre dp = new DiPre();

        RealDolarDAO rdd = new RealDolarDAO();
        DiPreDAO dpd = new DiPreDAO();

        DolarFuturo dft = new DolarFuturo();
        DolarFuturoDAO dfd = new DolarFuturoDAO();

        CristalESALQ ce = new CristalESALQ();
        CristalESALQDAO ced = new CristalESALQDAO();

        EmpacotadoESALQ ee = new EmpacotadoESALQ();
        EmpacotadoESALQDAO eed = new EmpacotadoESALQDAO();

        AcucarBrancoExp ab = new AcucarBrancoExp();
        AcucarBrancoExpDAO abed = new AcucarBrancoExpDAO();

        SugarN11 sn = new SugarN11();
        SugarN11DAO snd = new SugarN11DAO();

        EtanolAnid ea = new EtanolAnid();
        EtanolAnidDAO ead = new EtanolAnidDAO();

        EtanolHid eh = new EtanolHid();
        EtanolHidDAO ehd = new EtanolHidDAO();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        String reportDate = df.format(yesterday);

        System.out.println("Taxa referencial REAL x DOLAR");
        try {
            ArrayList<RealDolarBean> rdb = rd.execCon(reportDate);
            rdd.save(rdb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        System.out.println("\nTaxa referencial DI x PRE");
        try {
            ArrayList<DiPreBean> dpb = dp.execCon(reportDate);
            dpd.save(dpb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        System.out.println("\nDolar FUTURO da BMF");
        try {
            ArrayList<DolarFuturoBean> dfr = dft.execCon();
            dfd.save(dfr);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Açucar CEPEA/ESALQ
        System.out.println("\nValor do Açucar CEPEA/ESALQ");
        try {
            ArrayList<CristalESALQBean> ceb = ce.execCon();
            ced.save(ceb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Açucar Empacotado CEPEA/ESALQ
        System.out.println("\nValor do Açucar Empacotado CEPEA/ESALQ");
        try {
            ArrayList<EmpacotadoESALQBean> eeb = ee.execCon();
            eed.save(eeb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Açucar Branco Exportacao CEPEA/ESALQ
        System.out.println("Valor do Açucar Branco Exportacao CEPEA/ESALQ");
        try {
            ArrayList<AcucarBrancoExpBean> ebe = ab.execCon();
            abed.save(ebe);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Açucar Futuro na bolsa de Nova York
        System.out.println("\nValor do Açucar Futuro na bolsa de Nova York");
        try {
            ArrayList<SugarN11Bean> snb = sn.execCon();
            snd.save(snb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Etanol Anidro CEPEA/ESALQ
        System.out.println("\nValor do Etanol Anidro CEPEA/ESALQ");
        try {
            ArrayList<EtanolAnidBean> eab = ea.execCon();
            ead.save(eab);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

        // Valor do Etanol Hidratado CEPEA/ESALQ
        System.out.println("\nValor do Etanol Hidratado CEPEA/ESALQ");
        try {
            ArrayList<EtanolHidBean> ehb = eh.execCon();
            ehd.save(ehb);
        } catch (Exception e) {
            System.out.println("Erro ao consultar!");
            e.printStackTrace();
        }

    }

}
