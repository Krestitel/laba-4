package geometry2d;
import exceptions.NegativeValueException;
import exceptions.InvalidFigureParametersException;
import java.util.logging.*;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

    static {
        try {
            // Используем тот же файл, но с уровнем INFO
            FileHandler fileHandler = new FileHandler("figures.log", 1024 * 1024, 1, true);
            fileHandler.setFormatter(new XMLFormatter());
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.INFO);
        } catch (Exception e) {
            System.err.println("Ошибка инициализации логгера: " + e.getMessage());
        }
    }

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            logger.warning("Attempt to create rectangle with negative dimensions: width=" + width + ", height=" + height);
            throw new NegativeValueException("Ширина и высота не могут быть отрицательными: width=" + width + ", height=" + height);
        }
        if (width == 0 || height == 0) {
            logger.warning("Attempt to create rectangle with zero dimensions: width=" + width + ", height=" + height);
            throw new InvalidFigureParametersException("Ширина и высота не могут быть нулевыми: width=" + width + ", height=" + height);
        }
        this.width = width;
        this.height = height;
        logger.info("Rectangle created: width=" + width + ", height=" + height);
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