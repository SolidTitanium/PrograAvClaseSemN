// Clase para representar abogados
public class Lawyer extends Employee {

    public Lawyer(int years)
    {
        super(years);
    }

    public double getSalary()
    {
        return super.getSalary() + 5000 * getYears();
    }

    // sobrepone getVacationForm de la clase Employee
    public String getVacationForm()
    {
        return "rosa";
    }

    // sobrepone getVacationDays de la clase Employee
    public int getVacationDays()
    {
        return super.getVacationDays() + 5; // 1 semana de vacaciones extra
    }

    public void sue()
    {
        System.out.println("¡Te veré en la corte!");
    }
}
