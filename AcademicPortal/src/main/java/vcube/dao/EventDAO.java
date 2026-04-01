package vcube.dao;

import java.sql.*;
import java.util.*;
import vcube.Model.Events;
import vcube.utility.StudentCon;

public class EventDAO {

    public void addEvent(Events e) {
        String sql="INSERT INTO events(title,event_date,description) VALUES(?,?,?)";
        try(Connection con=StudentCon.DBconnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,e.getTitle());
            ps.setString(2,e.getEventDate());
            ps.setString(3,e.getDescription());
            ps.executeUpdate();
        }catch(Exception ex){ex.printStackTrace();}
    }

    public List<Events> getAllEvents() {
        List<Events> list=new ArrayList<>();
        String sql="SELECT * FROM events";
        try(Connection con=StudentCon.DBconnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                Events e=new Events();
                e.setTitle(rs.getString("title"));
                e.setEventDate(rs.getString("event_date"));
                e.setDescription(rs.getString("description"));
                list.add(e);
            }
        }catch(Exception ex){ex.printStackTrace();}
        return list;
    }
}

