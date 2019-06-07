/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.AcucarBrancoExpBean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class AcucarBrancoExpDAO {
    
    public void save(ArrayList<AcucarBrancoExpBean> dpb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_ACUCAR_CEPEA( ACUCCEPEA_ID\n" +
                     "                            , DT_INC\n" +
                     "                            , TIPO\n" +
                     "                            , DT_REF\n" +                
                     "                            , VLR\n" +
                     "                            , VAR_MES\n" +
                     "                            , VLR_DOLAR\n" +
                     "                            )\n" +
                     "                     VALUES( ACUCCEPEA_SEQ.NEXTVAL\n" +
                     "                           , TRUNC(SYSDATE)\n" +
                     "                           , 'EXPORTACAO'\n" +
                     "                           , to_date(?, 'dd/mm/yyyy')\n" +
                     "                           , ?\n" +
                     "                           , ?\n" +
                     "                           , ?\n" +
                     "                           )";
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < dpb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setString(1, dpb.get(i).getDATA());
                ps.setDouble(2, dpb.get(i).getVALOR());
                ps.setDouble(3, dpb.get(i).getVAR_MES());
                ps.setDouble(4, dpb.get(i).getVALOR_DOLAR());
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
