package az.company.process;

import az.company.connection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProcess {

    private static Connection connection = DBConnection.getConnetion();

    private static Statement statement = null;

    public static void createStudentTable() {

        try {
            String query = "CREATE TABLE student(studentId INT PRIMARY KEY NOT NULL, name VARCHAR(255)," +
                    " surname VARCHAR(255),birthdate INT,studentNumber VARCHAR(30))";
            statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Student table has created successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        DBConnection.closeConnection();


    }

    public static void insertStudent() {

        try {
            String query = "INSERT INTO student (studentId,name,surname,birthdate,studentNumber)VALUES(1,'Sebzali','Ebdurrehimli',1995,'233423423')";
            statement = connection.createStatement();
            statement.execute(query);

            System.out.println("Data inserted successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent() {
        try {
            String query = "UPDATE student set name='Shamil',surname='Abdurrahimli',birthdate = 1994,studentNumber = '2423423423' where studentId =1";
            statement = connection.createStatement();
            statement.execute(query);


            System.out.println("Data updated successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteStudent() {

        try {
            String query = "DELETE from student where studentId=1";
            statement = connection.createStatement();
            statement.execute(query);

            System.out.println("Data deleted successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
