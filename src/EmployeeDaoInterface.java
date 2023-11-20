public interface EmployeeDaoInterface {

    void add(Employee employee); //To add an employee
    void viewAll(); //To view all the employee available in the system
    void viewId(int id); //To view a specific employee using Id
    void viewDesignation(String designation); //To view employees using Designation
    void updateName(int id, String newName); //To update the name of an already existing employee
    void updateDesignation(int id, String newDesignation); //To update the designation of an already existing employee
    void updateSalary(int id, Double newSalary); //To update the salary of an already existing employee
    void delete(int id); //To delete an employee using Id

}
