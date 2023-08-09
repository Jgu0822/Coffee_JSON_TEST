package com.example.batch.jsonApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseJson {

    // 데이터베이스로부터 JSON 데이터를 가져오는 메서드
    public List<JSONObject> getJsonFromDatabase() {
        List<JSONObject> coffeeList = new ArrayList<>();

        // 데이터베이스 연결 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/test";
        String dbUser = "root";
        String dbPassword = "1234";

        try {
            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT coffee_id, brand, origin, characteristics, processed FROM coffee";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 결과셋을 JSON 형태로 변환하여 리스트에 추가
            while (resultSet.next()) {
                JSONObject coffee = new JSONObject();
                coffee.put("coffee_id", resultSet.getInt("coffee_id"));
                coffee.put("brand", resultSet.getString("brand"));
                coffee.put("origin", resultSet.getString("origin"));
                coffee.put("characteristics", resultSet.getString("characteristics"));
                coffee.put("processed", resultSet.getString("processed"));
                coffeeList.add(coffee);
            }

            // 연결 종료
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return coffeeList;
    }

    public static void main(String[] args) {
        DatabaseJson databaseJson = new DatabaseJson();
        List<JSONObject> coffeeList = databaseJson.getJsonFromDatabase();

        // JSON 배열로 변환 후 출력
        JSONArray jsonCoffeeArray = new JSONArray(coffeeList);

        System.out.println(jsonCoffeeArray.toString(4));
        System.out.println("@@@@@@@@@@@@@@@@@@@성공@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}
