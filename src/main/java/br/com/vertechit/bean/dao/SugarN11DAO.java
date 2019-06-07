/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.bean.dao;

import br.com.vertechit.bean.SugarN11Bean;
import br.com.vertechit.dbutil.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class SugarN11DAO {
    
    public void save(ArrayList<SugarN11Bean> dpb){
        Connection conn = GenericDao.getConnection();
        String sql = "INSERT INTO COM_TELA_ACUCAR_FUT( TELACFUT_ID\n" +
                     "                               , DT_INC     \n" +
                     "                               , TELA       \n" +
                     "                               , VLR_ABERT  \n" +
                     "                               , VLR_MAX    \n" +
                     "                               , VLR_MIN    \n" +
                     "                               , VLR_ULT    \n" +
                     "                               , VOL        \n" +
                     "                               , OPS_INT    \n" +
                     "                               )\n" +
                     "                        VALUES( TELACFUT_SEQ.NEXTVAL\n" +
                     "                              , TRUNC(SYSDATE)\n" +
                     "                              , to_date(?, 'dd/mm/yyyy')\n" +
                     "                              , ?\n" +
                     "                              , ?\n" +
                     "                              , ?\n" +
                     "                              , ?\n" +
                     "                              , ?\n" +
                     "                              , ?\n" +
                     "                              )";
        
        PreparedStatement ps = null;
        try {
            for(int i = 0;i < dpb.size();i++){
                ps = conn.prepareStatement(sql);
                ps.setString(1, dpb.get(i).getTELA());
                ps.setDouble(2, dpb.get(i).getOPEN());
                ps.setDouble(3, dpb.get(i).getHIGH());
                ps.setDouble(4, dpb.get(i).getLOW());
                ps.setDouble(5, dpb.get(i).getLAST());
                ps.setDouble(6, dpb.get(i).getVOL());
                ps.setDouble(7, dpb.get(i).getOP_INT());
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
