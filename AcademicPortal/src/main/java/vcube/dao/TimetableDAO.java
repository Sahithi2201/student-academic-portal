package vcube.dao;

import java.sql.*;
import java.util.*;
import vcube.Model.Timetable;
import vcube.utility.StudentCon;

public class TimetableDAO {

  
    public void addTimetable(Timetable t) {

        String sql = "INSERT INTO timetable(day,period,subject) VALUES(?,?,?)";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getDay());
            ps.setString(2, t.getPeriod());
            ps.setString(3, t.getSubject());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public List<Timetable> getAllTimetable() {

        List<Timetable> list = new ArrayList<>();
        String sql = "SELECT * FROM timetable ORDER BY day, period";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Timetable t = new Timetable();
                t.setId(rs.getInt("id"));
                t.setDay(rs.getString("day"));
                t.setPeriod(rs.getString("period"));
                t.setSubject(rs.getString("subject"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}









