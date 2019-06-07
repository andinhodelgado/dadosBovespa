/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.DiPreBean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class DiPreDAO {
    
    public void save(ArrayList<DiPreBean> dpb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_DI_PRE( DIPRE_ID\n" +
                     "                      , DT_INC\n" +
                     "                      , DIAS_CORRIDOS\n" +
                     "                      , DIAS_UTEIS\n" +                
                     "                      , DIAS_ANO\n" +
                     "                      )\n" +
                     "                VALUES( DIPRE_SEQ.NEXTVAL\n" +
                     "                      , TRUNC(SYSDATE)\n" +
                     "                      , ?\n" +
                     "                      , ?\n" +
                     "                      , ?\n" +
                     "                      )";
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < dpb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setLong(1, dpb.get(i).getDIAS_CORRIDOS());
                ps.setDouble(2, dpb.get(i).getDIAS_UTEIS());
                ps.setDouble(3, dpb.get(i).getDIAS_ANO());
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
