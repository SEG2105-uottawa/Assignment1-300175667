public class Employee {

    public String name;
    public int hours; 
    public double rate;
    public Addres[] address;
    


    public Employee (String n, int h, double r){
        address = new address[6];
        this.name = n;
        this.hours = h;
        this.rate = r;

    }


    public Employee (String n, int h, double r, Address[] a ) {
        this.name = n;
        this.hours = h;
        this.rate = r;
        this.address = a;

    }
    
}
