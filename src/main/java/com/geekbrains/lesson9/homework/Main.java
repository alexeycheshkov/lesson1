package com.geekbrains.lesson9.homework;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.lang.Class;
import java.util.Map;

public class Main {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            connect();
            addPerson(new Person("Vicka",30,15000));
//            createTable(Person.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }
    }
    public static void addPerson (Object obj) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!(obj instanceof Person)){
            System.out.println("Object doesn't match to table.");
        }
        StringBuilder addPersonString = new StringBuilder("INSERT INTO ");
        addPersonString.append(obj.getClass().getAnnotation(Table.class).title());
        addPersonString.append(" (");
        Field[] objFields = obj.getClass().getDeclaredFields();

        for (Field objField : objFields) {
            addPersonString.append(objField.getName());
            addPersonString.append(", ");
        }
        addPersonString.setLength(addPersonString.length()-2);
        addPersonString.append(") VALUES (");

        Method[] objMethods = obj.getClass().getMethods();
        for (Method objMethod : objMethods) {
            if (objMethod.isAnnotationPresent(ColumnMethod.class)){
                if (objMethod.getReturnType() == String.class){
                    addPersonString.append("'");
                    addPersonString.append(obj.getClass().getDeclaredMethod(objMethod.getName(), null).invoke(obj));
                    addPersonString.append("', ");
                } else {
                    addPersonString.append(obj.getClass().getDeclaredMethod(objMethod.getName(), null).invoke(obj));
                    addPersonString.append(", ");
                }
            }
        }
        addPersonString.setLength(addPersonString.length()-2);
        addPersonString.append(");");

        statement.executeUpdate(String.valueOf(addPersonString));
//        System.out.println(addPersonString);
    }
    public static void createTable (Class personClass) throws SQLException{
        if (!personClass.isAnnotationPresent(Table.class)){
            throw new RuntimeException("@Table missed");
        }
        Map<Class,String> type = new HashMap<>();
        type.put(int.class,"INTEGER");
        type.put(Integer.class,"INTEGER");
        type.put(String.class, "TEXT");

        StringBuilder createTableString = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        createTableString.append(((Table)personClass.getAnnotation(Table.class)).title());
        createTableString.append(" (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");

        Field[] fieldArray = personClass.getDeclaredFields();
        for (Field field : fieldArray) {
            if (field.isAnnotationPresent(Column.class)){
                createTableString.append(field.getName());
                createTableString.append(" ");
                createTableString.append(type.get(field.getType()));
                createTableString.append(", ");
            }
        }
        createTableString.setLength(createTableString.length()-2);
        createTableString.append(");");
//        System.out.println(createTableString);
        statement.executeUpdate(String.valueOf(createTableString));
    }

    public static void connect() throws SQLException {
        try {
            java.lang.Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/geekbrains/lesson9/homework/homeDB.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
