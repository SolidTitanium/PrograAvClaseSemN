// Clase para representar secretarios legales
public class LegalSecretary extends Secretary {

    public LegalSecretary(int years)
    {
        super(years);
    }

    public void fileLegalBriefs()
    {
        System.out.println("¡Podría archivar todo el día!");
    }

    public double getSalary()
    {
        double base = super.getSalary();
        return base + 5000.0; // 5,000.00 / año además del sueldo base
    }

}
