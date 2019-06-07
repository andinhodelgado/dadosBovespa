/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.EtanolAnidBean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class EtanolAnidDAO {
    
    public void save(ArrayList<EtanolAnidBean> dpb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_ETANOL_CEPEA( ETACEP_ID\n" +
                     "                            , DT_INC\n" +
                     "                            , TIPO\n" +
                     "                            , DT_ATE\n" +                
                     "                            , VLR_REAL\n" +
                     "                            , VLR_DOLAR\n" +
                     "                            )\n" +
                     "                     VALUES( ETACEP_SEQ.NEXTVAL\n" +
                     "                           , TRUNC(SYSDATE)\n" +
                     "                           , 'ANIDRO'\n" +
                     "                           , to_date(?, 'dd/mm/yyyy')\n" +
                     "                           , ?\n" +
                     "                           , ?\n" +
                     "                           )";
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < dpb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setString(1, dpb.get(i).getDT_ATE());
                ps.setDouble(2, dpb.get(i).getVLR_REAL());
                ps.setDouble(3, dpb.get(i).getVLR_DOLAR());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            GenericDao.closeConnection();
            e.printStackTrace();
        }
        GenericDao.closeConnection();   
    }
    
}
