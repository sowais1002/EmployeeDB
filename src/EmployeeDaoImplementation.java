import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImplementation implements EmployeeDaoInterface {

    Connection con;
    @Override
    public void add(Employee employee) {
        con = DbConnection.getCon();
        String query = "INSERT INTO employees (name, gender, age, designation, salary) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, employee.getName());
            pstm.setString(2, employee.getGender());
            pstm.setInt(3,employee.getAge());
            pstm.setString(4,employee.getDesignation());
            pstm.setDouble(5,employee.getSalary());
            int status = pstm.executeUpdate();
            if(status !=0){
                System.out.println("The Employee was Added Successfully!!!");
            }else{
                System.out.println("There was an error adding the Employee! Please Try Again");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void viewAll() {
        con = DbConnection.getCon();
        String query = "SELECT * FROM employees";
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            if(!res.next()){
                System.out.println("No employee found in the Database...");
            }else{
                do {
                    System.out.format("ID: " + "%d |" +
                                    " Name: " + "%s |" +
                                    " Gender: " + "%s |" +
                                    " Age: " + "%d |" +
                                    " Designation: " + "%s |" +
                                    " Salary: " + "%f\n" +
                                    "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n",
                            res.getInt(1),
                            res.getString(2),
                            res.getString(3),
                            res.getInt(4),
                            res.getString(5),
                            res.getDouble(6));
                }while (res.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void viewId(int id) {
        con = DbConnection.getCon();
        String query = "SELECT * FROM employees WHERE id ="+id;
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            if(!res.next()){
                System.out.println("No employee with id: "+id+" found in the Database...");
            }else{
                System.out.format("ID: " + "%d |" +
                                " Name: " + "%s |" +
                                " Gender: " + "%s |" +
                                " Age: " + "%d |" +
                                " Designation: " + "%s |" +
                                " Salary: " + "%f\n", res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void viewDesignation(String designation) {
        con = DbConnection.getCon();
        String query = "SELECT * FROM employees WHERE designation = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,designation);
            ResultSet res = pstm.executeQuery();
            if(!res.next()){
                System.out.println("No employee with designation "+designation+" found in the database...");
            }else{
                do {
                    System.out.format("ID: " + "%d |" +
                                    " Name: " + "%s |" +
                                    " Gender: " + "%s |" +
                                    " Age: " + "%d |" +
                                    " Designation: " + "%s |" +
                                    " Salary: " + "%f\n" +
                                    "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n",
                            res.getInt(1),
                            res.getString(2),
                            res.getString(3),
                            res.getInt(4),
                            res.getString(5),
                            res.getDouble(6));
                }while (res.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateName(int id, String newName) {
        con = DbConnection.getCon();
        String query = "UPDATE employees SET name = ? WHERE id = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,newName);
            pstm.setInt(2,id);
            int status = pstm.executeUpdate();
            if(status != 0){
                System.out.println("The name for Employee with Id: "+id+" was updated successfully!");
            }else{
                System.out.println("There was an error updating the name...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateDesignation(int id, String newDesignation) {
        con = DbConnection.getCon();
        String query = "UPDATE employees SET designation = ? WHERE id = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, newDesignation);
            pstm.setInt(2, id);
            int status = pstm.executeUpdate();
            if(status != 0){
                System.out.println("The designation of the Employee with Id: "+id+" was updated successfully");
            }else{
                System.out.println("There was an error updating the designation...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSalary(int id, Double newSalary) {
        con = DbConnection.getCon();
        String query = "UPDATE employees SET salary = ? WHERE id = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setDouble(1, newSalary);
            pstm.setInt(2, id);
            int status = pstm.executeUpdate();
            if(status != 0){
                System.out.println("The salary of the Employee with Id: "+id+" was updated successfully");
            }else{
                System.out.println("There was an error updating the salary...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        con = DbConnection.getCon();
        String query = "DELETE FROM employees WHERE id ="+id;
        try{
            Statement st = con.createStatement();
            int status = st.executeUpdate(query);
            if(status != 0){
                System.out.println("The Employee with id="+id+" was deleted successfuylly!!!");
            }else{
                System.out.println("There was an error deleting the employee...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
