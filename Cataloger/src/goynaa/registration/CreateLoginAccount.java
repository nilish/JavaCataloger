package goynaa.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CreateLoginAccount {
	//@Resource(name="jdbc/goynaa_db")
	private DataSource ds;
	public CreateLoginAccount()
	{
		try {
			Context ctx = new InitialContext();
		    ds = (DataSource)ctx.lookup("java:comp/env/jdbc/goynaa_db");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public int insertNewLogin(String new_email, String new_password) throws SQLException {
		// TODO Auto-generated method stub
		int numRowChanged = 0;
			 Connection con = null;
			 PreparedStatement st = null;
			try {
				con = ds.getConnection();
			 if(con != null)
			 {
			    String query = "INSERT INTO cataloger_user (email, password, enabled, user_role) VALUES (?,?,?,?)"; 
				st = (PreparedStatement) con.prepareStatement(query);
				st.setString(1, new_email);
		        st.setString(2, new_password);
			    st.setString(3, "new"); 
			    st.setString(4, "vendor");  
			    numRowChanged = st.executeUpdate();			
				System.out.println("Successfully insert the product id "+new_email);
				st.close();	
			      }
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					return numRowChanged;
	}
}
