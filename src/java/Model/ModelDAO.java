/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class ModelDAO<T> {

    private final static String sqlAIRLINE = "select * from AIRLINE";
    private final static String sqlAIRPORT = "select * from AIRPORT";

    public UserDTO login(String userName, String password) {
        UserDTO userDTO = null;
        String sql = "select ADMIN_NAME,ADMIN_PASSWORD from VNADMIN where ADMIN_NAME = ? and ADMIN_PASSWORD = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userDTO = new UserDTO();
                userDTO.setUserName(rs.getString("ADMIN_NAME"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Query Student error!" + e.getMessage());

        }
        return userDTO;
    }

    public List<T> list(String input) {
        String sql = "";
        if (input.equalsIgnoreCase("airport")) {
            sql = "select * from AIRPORT ";
            List<T> list = new ArrayList<>();
            AirportDTO airportDTO = null;
            try {
                Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    airportDTO = new AirportDTO();
                    airportDTO.setAirportID(rs.getString("ID"));
                    airportDTO.setAirportName(rs.getString("AIRPORT_NAME"));
                    list.add((T) airportDTO);
                }
                return list;
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (input.equalsIgnoreCase("airline")) {
            sql = "select * from AIRLINE ";
            List<T> list = new ArrayList<>();
            AirlineDTO airlineDTO = null;
            try {
                Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    airlineDTO = new AirlineDTO();
                    airlineDTO.setAirlineID(rs.getString("ID"));
                    airlineDTO.setAirlineName(rs.getString("AIRLINE_NAME"));
                    list.add((T) airlineDTO);
                }
                return list;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(new ModelDAO<>().login("admin01", "1234").getUserName());
        List<AirlineDTO> list = new ModelDAO<AirlineDTO>().list("airline");
        for (AirlineDTO x : list) {
            System.out.println(x.getAirlineName() + "\n");
        }

    }
}
