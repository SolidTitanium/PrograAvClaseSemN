public class HarvardLawyer extends Lawyer {

    /*
    * Los abogados de Harvard son como los abogados normales,
    * pero ganan un 20% más de dinero que un abogado normal,
    * obtienen 3 días más de vacaciones y tienen que completar cuatro
    * formularios de abogado para irse de vacaciones.
    * Es decir, el método getVacationForm debe devolver "pinkpinkpinkpink".
    */

    public HarvardLawyer(int years) { super(years); }

    public double getSalary() { return super.getSalary() * 1.2; }

    public int getVacationDays() { return super.getVacationDays() + 3; }

    public String getVacationForm() { return "pinkpinkpinkpink"; }
}