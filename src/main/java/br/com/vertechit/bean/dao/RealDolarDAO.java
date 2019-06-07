/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.RealDolarBean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class RealDolarDAO {
    
    public void save(ArrayList<RealDolarBean> rdb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_REAL_DOLAR( REALDOL_ID\n" +
                     "                          , DT_INC\n" +
                     "                          , DIAS_CORRIDOS\n" +
                     "                          , PRECO\n" +
                     "                          )\n" +
                     "                    VALUES( REALDOL_SEQ.NEXTVAL\n" +
                     "                          , TRUNC(SYSDATE)\n" +
                     "                          , ?\n" +
                     "                          , ?\n" +
                     "                          )";
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < rdb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setLong(1, rdb.get(i).getDIAS_CORRIDOS());
                ps.setDouble(2, rdb.get(i).getPRECO());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            GenericDao.closeConnection();
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.print("Nenhum dado encontrado para a data atual!");
        }
        GenericDao.closeConnection();
    }
    
}
