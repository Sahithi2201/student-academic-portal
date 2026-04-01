package vcube.dao;
import java.sql.*;
import java.util.*;
import vcube.Model.Fee;
import vcube.utility.StudentCon;
public class FeeDAO {
    public void addFee(Fee f) {

        String sql = "INSERT INTO fees(username, fee_type, amount, status, paid_date) VALUES(?,?,?,?,?)";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, f.getUsername());
            ps.setString(2, f.getFeeType());
            ps.setInt(3, f.getAmount());
            ps.setString(4, f.getStatus());
            ps.setString(5, f.getPaidDate());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public List<Fee> getFeesByUsername(String username) {

        List<Fee> list = new ArrayList<>();
        String sql = "SELECT * FROM fees WHERE username=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fee f = new Fee();
                f.setId(rs.getInt("id"));
                f.setUsername(rs.getString("username"));
                f.setFeeType(rs.getString("fee_type"));
                f.setAmount(rs.getInt("amount"));
                f.setStatus(rs.getString("status"));
                f.setPaidDate(rs.getString("paid_date"));
                list.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   
    public List<Fee> getAllFees() {

        List<Fee> list = new ArrayList<>();
        String sql = "SELECT * FROM fees";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fee f = new Fee();
                f.setId(rs.getInt("id"));
                f.setUsername(rs.getString("username"));
                f.setFeeType(rs.getString("fee_type"));
                f.setAmount(rs.getInt("amount"));
                f.setStatus(rs.getString("status"));
                f.setPaidDate(rs.getString("paid_date"));
                list.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}




















