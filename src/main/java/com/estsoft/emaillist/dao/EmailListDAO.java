package com.estsoft.emaillist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.estsoft.db.DBConnection;
import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.emaillist.vo.EmailListVO;

@Repository
public class EmailListDAO {
	
	private DBConnection dbConnection;
	
	public EmailListDAO(){
		this.dbConnection = new MySQLWebDBConnection();
	}
	
	public EmailListDAO(DBConnection dbConnection){
		this.dbConnection = dbConnection;
	}
	
	public void insert(EmailListVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = dbConnection.getConnection();
			
			String sql = "INSERT INTO emaillist	VALUES(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(SQLException ex){
			System.out.println("error:"+ex);
		} finally{
			try{
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public List<EmailListVO> getList(){
		List<EmailListVO> list = new ArrayList<EmailListVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = dbConnection.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT no,first_name,last_name,email FROM emaillist";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmailListVO vo = new EmailListVO(no, firstName, lastName, email);
				list.add(vo);
			}
			
		} catch(SQLException ex){
			System.out.println("error:"+ex);
		} finally{
			try{
				if(rs != null)		rs.close();
				if(stmt != null)	stmt.close();
				if(conn != null)	conn.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
}
