public class Main {

    public static void printInfo(Employee e)
    {
        System.out.println("pay : " + e.getSalary());
        System.out.println("vdays: " + e.getVacationDays());
        System.out.println("vform: " + e.getVacationForm());
        System.out.println();
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee(0);
        System.out.println("Empleado: horas: " + e1.getHours() + ", salario: " + e1.getSalary() +
                ", dias de vacaciones: " + e1.getVacationDays() + ", formato: " + e1.getVacationForm());

        Secretary s1 = new Secretary(15);
        System.out.println("Secretario: horas: " + s1.getHours() + ", salario: " + s1.getSalary() +
                ", dias de vacaciones: " + s1.getVacationDays() + ", formato: " + s1.getVacationForm());
        System.out.print("s1 dice: ");
        s1.takeDictation("hola mundo");

        Lawyer a1 = new Lawyer(10);
        System.out.println("Abogado: horas: " + a1.getHours() + ", salario: " + a1.getSalary() +
                ", dias de vacaciones: " + a1.getVacationDays() + ", formato: " + a1.getVacationForm());
        System.out.print("a1 dice: ");
        a1.sue();

        Marketer m1 = new Marketer(5);
        System.out.println("Marketer: horas: " + m1.getHours() + ", salario: " + m1.getSalary() +
                ", dias de vacaciones: " + m1.getVacationDays() + ", formato: " + m1.getVacationForm());
        System.out.print("m1 dice: ");
        m1.advertise();

        LegalSecretary s2 = new LegalSecretary(20);
        System.out.println("Secretario legal: horas: " + s2.getHours() + ", salario: " + s2.getSalary() +
                ", dias de vacaciones: " + s2.getVacationDays() + ", formato: " + s2.getVacationForm());
        System.out.print("s2 dice: ");
        s2.fileLegalBriefs();
        System.out.print("y también dice: ");
        s2.takeDictation("Soy legal");
        System.out.println("s2 es empleado: " + (s2 instanceof Employee));
        System.out.println("s2 es empleado: " + (s2 instanceof Secretary));
        System.out.println("s2 es empleado: " + (s2 instanceof LegalSecretary));
        //System.out.println("s2 es empleado: " + (s2 instanceof Lawyer));

        Employee[] employees = {e1, s1, a1, m1};
        for (Employee e : employees) {
            if (e instanceof Secretary) {
                ((Secretary)e).takeDictation("hello");
            }

            if (e instanceof Lawyer) {
                ((Lawyer) e).sue();
            }
        }

        Employee ed = new Lawyer(10);
        System.out.println("formato ed: " + ed.getVacationForm());
        System.out.println("salario ed: " + ed.getSalary());
        ((Lawyer) ed).sue();

        printInfo(ed);
        printInfo(a1);
        printInfo(m1);

        Employee x = new Employee(5);
        //((Lawyer) x).sue(); // genera una excepción
    }
}
