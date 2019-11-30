package demojdbc;

import java.sql.*;

public class DemoJdbc {

	public static void main(String[] args) {
       sauverEnBase("Jean");
		
	}

//	public static void sauverEnBase(String personne) {
//		
//		String url = "jdbc:mysql://localhost/formation";
//		String login = "root";
//		String pwd="";
//		Connection cn=null;
//		Statement st =null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			cn = DriverManager.getConnection(url, login, pwd);
//			st = cn.createStatement();
//			String sql = "INSERT INTO javadb (personne) VALUES ('"+ personne + "')";
//			st.executeUpdate(sql);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				cn.close();
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
public static void sauverEnBase(String personne) {
		
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String pwd="";
		Connection cn=null;
		PreparedStatement st =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, pwd);
			
			String sql = "INSERT INTO client (nom) VALUES (?)";
			st = cn.prepareStatement(sql);
			st.setString(1, personne);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void lireEnBase() {
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String pwd ="";
		Connection cn = null; 
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, pwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM javadb";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("personne"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
