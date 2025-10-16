package test;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.NegativeValueException;
import exceptions.InvalidFigureParametersException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            // Простой ConsoleHandler для вывода в консоль
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

                @Override
                public synchronized String format(LogRecord record) {
                    return String.format(format,
                            new java.util.Date(record.getMillis()),
                            record.getLevel().getLocalizedName(),
                            record.getMessage()
                    );
                }
            });
            consoleHandler.setLevel(Level.FINE);
            logger.addHandler(consoleHandler);
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            System.err.println("Ошибка инициализации логгера: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.fine("Запуск программы");

        System.out.println("=== Тестирование геометрических фигур ===");

        try {
            // Ввод данных для круга
            System.out.print("Введите радиус круга: ");
            double circleRadius = scanner.nextDouble();
            logger.fine("Введен радиус круга: " + circleRadius);
            Circle circle = new Circle(circleRadius);

            // Ввод данных для прямоугольника
            System.out.print("Введите ширину прямоугольника: ");
            double rectWidth = scanner.nextDouble();
            System.out.print("Введите высоту прямоугольника: ");
            double rectHeight = scanner.nextDouble();
            logger.fine("Введены размеры прямоугольника: width=" + rectWidth + ", height=" + rectHeight);
            Rectangle rectangle = new Rectangle(rectWidth, rectHeight);

            // Ввод данных для цилиндров
            System.out.print("Введите высоту цилиндра с круглым основанием: ");
            double cylinderHeight1 = scanner.nextDouble();
            System.out.print("Введите высоту цилиндра с прямоугольным основанием: ");
            double cylinderHeight2 = scanner.nextDouble();
            logger.fine("Введены высоты цилиндров: " + cylinderHeight1 + ", " + cylinderHeight2);

            // Создание объектов цилиндров
            Cylinder cylinder1 = new Cylinder(circle, cylinderHeight1);
            Cylinder cylinder2 = new Cylinder(rectangle, cylinderHeight2);

            // Вывод результатов
            System.out.println("\n== Результаты ==");
            System.out.println("2D фигуры:");
            circle.Show();
            rectangle.Show();

            System.out.println("\nЦилиндры:");
            cylinder1.Show();
            System.out.println();
            cylinder2.Show();

            logger.fine("Успешное выполнение программы");

        } catch (NegativeValueException e) {
            logger.warning("Ошибка ввода: отрицательное значение - " + e.getMessage());
            System.out.println("X Ошибка ввода: " + e.getMessage());
            System.out.println("Пожалуйста, введите положительные значения.");
        } catch (InvalidFigureParametersException e) {
            logger.warning("Ошибка параметров фигуры - " + e.getMessage());
            System.out.println("X Ошибка параметров фигуры: " + e.getMessage());
            System.out.println("Проверьте введенные данные.");
        } catch (Exception e) {
            logger.severe("Неожиданная ошибка: " + e.getMessage());
            System.out.println(" X Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            logger.fine("Завершение программы");
            System.out.println("\nПрограмма завершена.");
        }
    }
}