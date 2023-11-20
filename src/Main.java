import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();
        EmployeeDaoInterface dao = new EmployeeDaoImplementation();
        do{
            System.out.println("\n\t\t\tEMPLOYEE MANAGEMENT\n\n" +
                    "1. Add new Employee\n" +
                    "2. View all Employees\n" +
                    "3. View Employee by Id\n" +
                    "4. View Employee by Designation\n" +
                    "5. Update Employee\n" +
                    "6. Delete Employee\n" +
                    "\t0. EXIT");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    System.out.println("\nAdding new Employee\n");
                    System.out.println("Enter Name of the Employee: ");
                    emp.setName(sc.nextLine());
                    System.out.println("Enter Gender of the Employee: ");
                    emp.setGender(sc.nextLine());
                    System.out.println("Enter Employee Age: ");
                    emp.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter Designation of the Employee: ");
                    emp.setDesignation(sc.nextLine());
                    System.out.println("Enter Salary of the Employee: ");
                    emp.setSalary(sc.nextDouble());
                    dao.add(emp);
                    break;
                case 2:
                    System.out.println("Viewing all Employees\n");
                    dao.viewAll();
                    break;
                case 3:
                    System.out.println("Viewing Employee using Id\n");
                    System.out.println("Enter the Id of the Employee to be viewed: ");
                    dao.viewId(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Viewing Employee using Designation\n");
                    System.out.println("Enter the Designation of Employees to be viewed: ");
                    dao.viewDesignation(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Updating Employee\n");
                    System.out.println("Enter the Id of the Employee to be updated: ");
                    int id = sc.nextInt();
                    dao.viewId(id);
                    System.out.println("1. Update Name of the Employee\n" +
                            "2. Update Designation of the Employee\n" +
                            "3. Update Salary of the Employee\n");
                    int updateCh = sc.nextInt();
                    sc.nextLine();
                    switch (updateCh){
                        case 1:
                            System.out.println("Enter updated Name: ");
                            String newName = sc.nextLine();
                            dao.updateName(id, newName);
                            break;
                        case 2:
                            System.out.println("Enter updated Designation: ");
                            String newDesignation = sc.nextLine();
                            dao.updateDesignation(id, newDesignation);
                            break;
                        case 3:
                            System.out.println("Enter updated Salary");
                            Double newSalary = sc.nextDouble();
                            dao.updateSalary(id,newSalary);
                            break;
                        default:
                            System.out.println("Wrong option entered... Please try again");
                    }
                    break;
                case 6:
                    System.out.println("Deleting Employee\n");
                    System.out.println("Enter the Id of the Employee to be deleted: ");
                    dao.delete(sc.nextInt());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oops!! You entered an invalid option....\nPlease enter a valid choice");
            }
        }while (true);
    }
}