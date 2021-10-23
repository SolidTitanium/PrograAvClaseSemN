// Clase para representar especialistas en marketing
public class Marketer extends Employee {

    public Marketer(int years)
    {
        super(years);
    }

    public void advertise()
    {
        System.out.println("¡Actúe ahora mientras duren las existencias!");
    }

    public double getSalary()
    {
        double base = super.getSalary();
        return base + 10000.0;		// $10,000.00 / año además del sueldo base
    }
}
