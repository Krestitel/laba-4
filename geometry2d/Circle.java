package geometry2d;
import exceptions.NegativeValueException;
import exceptions.InvalidFigureParametersException;
import java.util.logging.*;

public class Circle implements Figure {
    private double radius;
    private static final Logger logger = Logger.getLogger(Circle.class.getName());

    static {
        try {
            // Указываем кодировку UTF-8 для корректного отображения русских символов
            FileHandler fileHandler = new FileHandler("figures.log", 1024 * 1024, 1, true);
            fileHandler.setFormatter(new XMLFormatter());
            fileHandler.setLevel(Level.SEVERE);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.SEVERE); // Устанавливаем уровень для самого логгера
        } catch (Exception e) {
            System.err.println("Ошибка инициализации логгера: " + e.getMessage());
        }
    }

    public Circle(double radius) {
        if (radius < 0) {
            // Используем английские сообщения для избежания проблем с кодировкой
            logger.severe("Attempt to create circle with negative radius: " + radius);
            throw new NegativeValueException("Радиус не может быть отрицательным: " + radius);
        }
        if (radius == 0) {
            logger.severe("Attempt to create circle with zero radius");
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