


package vcube.dao;

import java.sql.*;
import java.util.*;
import vcube.Model.Attendance;
import vcube.utility.StudentCon;

public class AttendanceDAO {

   
    public void addAttendance(Attendance a) {

        String sql = "INSERT INTO attendance(username, subject, present, total) VALUES (?,?,?,?)";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, a.getUsername());
            ps.setString(2, a.getSubject());
            ps.setInt(3, a.getPresent());
            ps.setInt(4, a.getTotal());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public List<Attendance> getAttendanceByUsername(String username) {

        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE username=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setUsername(rs.getString("username"));
                a.setSubject(rs.getString("subject"));
                a.setPresent(rs.getInt("present"));
                a.setTotal(rs.getInt("total"));
                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   
    public List<Attendance> getAllAttendance() {

        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setUsername(rs.getString("username"));
                a.setSubject(rs.getString("subject"));
                a.setPresent(rs.getInt("present"));
                a.setTotal(rs.getInt("total"));
                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
