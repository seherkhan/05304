package Task2;

/**
 * Used to create objects that represent employees
 */
public abstract class Employee {
    private String name;
    private String NIC;
    /**
     * Constructor
     * @param name
     * @param nic
     */
    public Employee(String name,String nic){
        this.name=name;
        this.NIC=nic;
    }

    public abstract double earnings();

    /**
     * Display details of the object
     */
    public void displayDetails(){
        System.out.print("Name: "+name+", NIC: "+NIC);
    }
}
