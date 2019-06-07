/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.DolarFuturoBean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class DolarFuturoDAO {
    
    public void save(ArrayList<DolarFuturoBean> dpb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_DOLAR_FUTURO( DOLFUT_ID\n" +
                     "                            , DT_INC\n" +
                     "                            , VENCTO\n" +
                     "                            , PRECO_ABERT\n" +
                     "                            , PRECO_MIN\n" +
                     "                            , PRECO_MAX\n" +
                     "                            , PRECO_MED\n" +
                     "                            , PRECO_ULT\n" +
                     "                            , PRECO_AJUSTE\n" +
                     "                            , VAR_PTOS\n" +
                     "                            , PRECO_ULT_COMPRA\n" +
                     "                            , PRECO_ULT_VENDA\n" +
                     "                            )\n" +
                     "                      VALUES( DOLFUT_SEQ.NEXTVAL\n" +
                     "                            , TRUNC(SYSDATE)\n" +
                     "                            , to_date(?, 'dd/mm/yyyy') \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            , ? \n" +
                     "                            )";
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < dpb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setString(1, dpb.get(i).getVENTO());
                ps.setDouble(2, dpb.get(i).getPRECO_ABERT());
                ps.setDouble(3, dpb.get(i).getPRECO_MIN());
                ps.setDouble(4, dpb.get(i).getPRECO_MAX());
                ps.setDouble(5, dpb.get(i).getPRECO_MED());
                ps.setDouble(6, dpb.get(i).getPRECO_ULT());
                ps.setDouble(7, dpb.get(i).getPRECO_AJUSTE());
                ps.setString(8, dpb.get(i).getVAR_PTOS());
                ps.setDouble(9, dpb.get(i).getPRECO_ULT_COMPRA());
                ps.setDouble(10, dpb.get(i).getPRECO_ULT_VENDA());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            GenericDao.closeConnection();
            e.printStackTrace();
        }
        GenericDao.closeConnection();   
    }
    
}
