import java.sql.*;

public class DatabaseConnection{

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_database","root","Ani@2310");
            statement=connection.createStatement();

            createTable();

            insertEmployee(1, "Anisha", 100000, "IT");
            insertEmployee(2, "Riya", 120000, "Data Science");
            insertEmployee(3, "Amit", 50000, "IT");
            insertEmployee(4, "Vinay", 90000, "HR");

            findEmployee(3);
            updateEmployee(1, 130000);
            findEmployee(1);

            deleteEmployee(4);

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void createTable(){
        try{
            statement.executeUpdate("CREATE TABLE Employee(EMP_ID INT PRIMARY KEY,NAME VARCHAR(40),SALARY INT,DEPARTMENT VARCHAR(40));");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertEmployee(int empId,String name,int salary,String department){
        try{
            String query="INSERT INTO Employee(EMP_ID,NAME,SALARY,DEPARTMENT) VALUES("+empId+",'"+name+"',"+salary+",'"+department+"');";
            statement.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public static void findEmployee(int empId){
        try{
            String query="SELECT * FROM Employee WHERE EMP_ID="+empId+";";
            resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                for(int i=1;i<=4;i++){
                    System.out.print(resultSet.getString(i)+" ");
                }
                System.out.println();
            }
            else{
                System.out.println("Employee not found");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updateEmployee(int empId,int salary){
        try{
            String query="UPDATE Employee SET SALARY="+salary+" WHERE EMP_ID="+empId+";";
            statement.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEmployee(int empId){
        try{
            String query="DELETE FROM Employee WHERE EMP_ID="+empId+";";
            statement.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}