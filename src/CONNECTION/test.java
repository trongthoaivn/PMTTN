package CONNECTION;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test extends ConnectionSQL {

    public String checkData(){

        String sql ="select * from Admin";
        Connection conn =super.getJDBCConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getDate(3)+rs.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "complete";
    }

    public static void main(String[] args) {
        test a = new test();
        System.out.println(a.checkData());
    }


}
