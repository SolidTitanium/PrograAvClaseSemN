public class Janitor extends Employee {

    /*
    * Los conserjes trabajan el doble de horas a la semana que otros empleados
    * (80 horas a la semana), ganan $30,000 ($10,000 menos que los empleados generales),
    * tienen la mitad de vacaciones que otros empleados (solo 5 días) y tienen un
    * método adicional llamado clean que imprime "Workin' for the man".
    */

    public Janitor(int years) { super(years); }

    public int getHours() {return super.getHours()*2; }

    public double getSalary() { return super.getSalary() - 10000.0; }

    public int getVacationDays() { return super.getVacationDays()/2; }

    public void clean() { System.out.println("Workin' for the man"); }
}