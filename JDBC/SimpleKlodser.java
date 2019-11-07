import java.sql.*;

public class SimpleKlodser {
    public static void main(String[] args) throws SQLException {

        // #1. Connect to the database
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/bricks?serverTimezone=UTC",
                "root",
                "Koch1338"
        );

        // #2. Create a statement / query / forespørgsel
        String mitQuery = "SELECT * FROM bricks.klodser WHERE size LIKE '8%';";
        Statement statement = connection.createStatement();

        // #3. Execute the statement and send the SQL-query to the SQL-server
        ResultSet resultSet = statement.executeQuery
                (mitQuery);

        // #4. Iterate through the results and print the results (vi har måske flere resultater end 1, derfor vil en løkke læse alle rækker ud fra resultSettet)
        while (resultSet.next())
            System.out.println("ID: " + resultSet.getString(1) + ", " +
                    resultSet.getString(5) + ", " +
                    "quantity: "+ resultSet.getString(8) +
                    ", Size: " +
                    resultSet.getString("size"));

        // #5. Close the connection (always!)
        connection.close();
    }
}
