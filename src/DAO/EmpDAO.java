/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EmpDTO;
import Utils.MyConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author minhv
 */
public class EmpDAO {
    
    public static ArrayList getEmpData() {
        ArrayList<EmpDTO> empList=new ArrayList<>();
        try {
            Connection cn = MyConection.makeConnection();
            if (cn != null) {
                String sql = "Select EmpID,Fullname,Phone,Email,Address,DateOfBirth,IsDelete\n"
                        + "from tblEmployees";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getString("IsDelete").equals("0")) {
                        EmpDTO emp = new EmpDTO(rs.getString("EmpID"), rs.getString("FullName"), rs.getString("Phone"),
                                rs.getString("Email"), rs.getString("Address"), rs.getDate("DateOfBirth"), false);
                        empList.add(emp);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }
    
    public static int insertEmp(String EmpID, String Fullname, String Phone, String Email, String Address, String DateOfBirth, boolean IsDelete) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="insert tblEmployees\n" +
                       "values(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, EmpID);
            pst.setString(2, Fullname);
            pst.setString(3, Phone);
            pst.setString(4, Email);
            pst.setString(5, Address);
            pst.setString(6, DateOfBirth);
            int delete;
            if(IsDelete==true){
                delete=1;
            }else{
                delete=0;
            }
            pst.setInt(7, delete);
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int updateEmp(String EmpID, String Fullname, String Phone, String Email, String Address, String DateOfBirth) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="update tblEmployees\n" +
                       "set Fullname=?,Phone=?,Email=?,Address=?,DateOfBirth=?\n" +
                       "where EmpID=?";
            PreparedStatement pst=cn.prepareStatement(sql);      
            pst.setString(1, Fullname);
            pst.setString(2, Phone);
            pst.setString(3, Email);
            pst.setString(4, Address);
            pst.setString(5, DateOfBirth);
            pst.setString(6, EmpID);
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int deleteEmp(String EmpID) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="update tblEmployees\n" +
                       "set IsDelete='1'\n" +
                       "where EmpID=?";
            PreparedStatement pst=cn.prepareStatement(sql);      
            pst.setString(1, EmpID);
            result=pst.executeUpdate();
        }
        return result;
    }

    
}
