package geometry3d;
import geometry2d.Figure;
import exceptions.NegativeValueException;        // ДОБАВЛЯЕМ ИМПОРТ
import exceptions.InvalidFigureParametersException; // ДОБАВЛЯЕМ ИМПОРТ

public class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) {
        // ДОБАВЛЯЕМ ПРОВЕРКИ (4 строки)
        if (base == null) {
            throw new InvalidFigureParametersException("Основание не может быть null");
        }
        if (height < 0) {
            throw new NegativeValueException("Высота цилиндра не может быть отрицательной: " + height);
        }
        if (height == 0) {
            throw new InvalidFigureParametersException("Высота цилиндра не может быть нулевой");
        }
        this.base = base;
        this.height = height;
    }

    public double Volume() {
        return base.Area() * height;
    }

    public void Show() {
        System.out.print("Цилиндр: ");
        base.Show();
        System.out.println(" высота = " + height + ", объем = " + String.format("%.2f", Volume()));
    }
}