package vcube.dao;

import java.sql.*;
import java.util.*;

import vcube.Model.Marks;
import vcube.utility.StudentCon;

public class MarksDAO {

    public void addMarks(Marks m) {

        String sql = "INSERT INTO marks(username, subject, marks) VALUES (?,?,?)";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getUsername());
            ps.setString(2, m.getSubject());
            ps.setInt(3, m.getMarks());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Marks> getMarksByUsername(String username) {

        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM marks WHERE username=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Marks m = new Marks();
                m.setUsername(rs.getString("username"));
                m.setSubject(rs.getString("subject"));
                m.setMarks(rs.getInt("marks"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Marks> getAllMarks() {

        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM marks";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Marks m = new Marks();
                m.setUsername(rs.getString("username"));
                m.setSubject(rs.getString("subject"));
                m.setMarks(rs.getInt("marks"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}