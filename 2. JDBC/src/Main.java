import java.sql.*; // Importing the package

public class Main {
    public static void main(String[] args) {

        /*
        Steps fot JDBC Connectivity
        - Import the required package `java.sql`
        - Load the driver
        - Register the driver
        - Create connection
        - Execute a statement or query
        - Process the result
        - Close the connection
         */

        // Load and register the driver
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Class Loaded");
        }catch(ClassNotFoundException e){
            System.out.println("Driver not found!!");
        }

        // Create the connection
        String url = "jdbc:postgresql://localhost:5432/jdbcdemo";
        String username = "shivamkumar";
        String password = "Realmex7@123";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
        }catch(SQLException e){
            System.out.println("Error creating connection");
        }

        // Create a statement
        String getNameWithSid1 = "SELECT sname FROM STUDENT WHERE sid = 1"; // Query to be executed
        String getAllData = "SELECT * FROM STUDENT";
        String insertData = "INSERT INTO STUDENT(sid,sname,marks) VALUES(7,'Test', 90.88)";
        String updateData = "UPDATE STUDENT SET sname = 'Test' WHERE sid = 1";
        String deleteData = "DELETE FROM STUDENT WHERE sid=1";
        Statement statement = null;
        try{
            statement = con.createStatement();
        }catch (SQLException e){
            System.out.println("Error creating the statement");
        }
        ResultSet result = null; // variable to store the result of the query
        try{
            // Executing the query
            result = statement.executeQuery(getAllData); // To select we use executeQuery but if updating, then execute
        } catch (SQLException e) {
            System.out.println("Error executing the statement");
        }

        // Process the result
        try{
            while(result.next()){
                System.out.println("Name: " + result.getString("sname"));
            }
        }catch (SQLException e){
            System.out.println("Error getting the result");
        }

        // Insert into the table
        try{
            statement.execute(insertData);
            System.out.println("Data instered");
        }catch (SQLException e){
            System.out.println("Error inserting data");
        }

        // Update data
        try{
            statement.execute(updateData);
            System.out.println("Data updated");
        }catch (SQLException e){
            System.out.println("Error updating data");
        }

        // Delete data
        try{
            statement.execute(deleteData);
            System.out.println("Data Deleted");
        }catch (SQLException e){
            System.out.println("Error updating data");
        }

        // Close the connection
        try{
            statement.close();
            con.close();
            System.out.println("Connection closed");
        }catch (SQLException e){
            System.out.println("Error closing the connection");
        }
    }
}