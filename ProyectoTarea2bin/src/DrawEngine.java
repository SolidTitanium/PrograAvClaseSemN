import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

public class DrawEngine {
    DrawingPanel panel;
    Graphics g;
    //Aquí se puede seleccionar el tamaño.
    int SIZE = 7;

    public DrawEngine(DrawingPanel Panel){
        panel = Panel;
        g = panel.getGraphics();
    }

    /*
    * Este método parsea las entradas y selecciona que dibujar
    * llamando al método correspondiente, recibe un arreglo que
    * contiene la coordenada x, y, y la figura a dibujar.
    */
    public void easyDraw(String[] point){
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);
        int shape = Integer.parseInt(point[2]);

        switch (shape) {
            case 0 -> drawCircle(x, y);
            case 1 -> drawSquare(x, y);
            case 2 -> drawTriangle(x, y);
        }
    }

    public void drawCircle(int x, int y){
        g.setColor(Color.blue);
        g.drawOval(x, y, SIZE, SIZE);
    }

    public void drawSquare(int x, int y){
        g.setColor(Color.green);
        g.drawRect(x, y, SIZE, SIZE);
    }

    public void drawTriangle(int x, int y){
        int adjSIZE = Math.floorDiv(SIZE, 2);
        int[] xPoints = {x, x+adjSIZE, x-adjSIZE};
        int[] yPoints = {y-adjSIZE, y+adjSIZE, y+adjSIZE};
        g.setColor(Color.red);
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
