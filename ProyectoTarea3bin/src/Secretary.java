public class Secretary extends Employee {

    public Secretary(int years)
    {
        super(years);
    }

    // Secretarios no obtienen bono por sus años de servicio.
    public int getSeniorityBonus()
    {
        return 0;
    }

    public void takeDictation(String text)
    {
        System.out.println("Tomando dictado del texto: " + text);
    }
}
