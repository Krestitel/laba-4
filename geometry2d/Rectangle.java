package geometry2d;
import exceptions.NegativeValueException;        // ДОБАВЛЯЕМ ИМПОРТ
import exceptions.InvalidFigureParametersException; // ДОБАВЛЯЕМ ИМПОРТ

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        // ДОБАВЛЯЕМ ПРОВЕРКИ (4 строки)
        if (width < 0 || height < 0) {
            throw new NegativeValueException("Ширина и высота не могут быть отрицательными: width=" + width + ", height=" + height);
        }
        if (width == 0 || height == 0) {
            throw new InvalidFigureParametersException("Ширина и высота не могут быть нулевыми: width=" + width + ", height=" + height);
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double Area() {
        return width * height;
    }

    @Override
    public void Show() {
        System.out.println("Прямоугольник: ширина = " + width + ", высота = " + height +
                ", площадь = " + String.format("%.2f", Area()));
    }
}