package geometry2d;
import exceptions.NegativeValueException;
import exceptions.InvalidFigureParametersException;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        // ДОБАВЛЯЕМ ПРОВЕРКИ (2 строки)
        if (radius < 0) {
            throw new NegativeValueException("Радиус не может быть отрицательным: " + radius);
        }
        if (radius == 0) {
            throw new InvalidFigureParametersException("Радиус не может быть нулевым");
        }
        this.radius = radius;
    }

    @Override
    public double Area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void Show() {
        System.out.println("Круг: радиус = " + radius + ", площадь = " + String.format("%.2f", Area()));
    }
}