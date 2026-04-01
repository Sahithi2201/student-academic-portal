
package vcube.dao;

import java.sql.*;
import vcube.utility.StudentCon;

public class LoginDAO {

	public String validate(String username, String password) {

		String role = "";
		String sql = "SELECT role FROM users WHERE username=? AND password=?";

		try (Connection con = StudentCon.DBconnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
}
