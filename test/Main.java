package test;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.NegativeValueException;        // ДОБАВЛЯЕМ ИМПОРТ
import exceptions.InvalidFigureParametersException; // ДОБАВЛЯЕМ ИМПОРТ
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Тестирование геометрических фигур ===");

        try {
            // Ввод данных для круга
            System.out.print("Введите радиус круга: ");
            double circleRadius = scanner.nextDouble();
            Circle circle = new Circle(circleRadius);  // МОЖЕТ ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ

            // Ввод данных для прямоугольника
            System.out.print("Введите ширину прямоугольника: ");
            double rectWidth = scanner.nextDouble();
            System.out.print("Введите высоту прямоугольника: ");
            double rectHeight = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(rectWidth, rectHeight);  // МОЖЕТ ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ

            // Ввод данных для цилиндров
            System.out.print("Введите высоту цилиндра с круглым основанием: ");
            double cylinder1Height = scanner.nextDouble();
            System.out.print("Введите высоту цилиндра с прямоугольным основанием: ");
            double cylinder2Height = scanner.nextDouble();

            // Создание объектов цилиндров
            Cylinder cylinder1 = new Cylinder(circle, cylinder1Height);  // МОЖЕТ ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ
            Cylinder cylinder2 = new Cylinder(rectangle, cylinder2Height);  // МОЖЕТ ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ

            // Вывод результатов
            System.out.println("\n=== Результаты ===");
            System.out.println("2D фигуры:");
            circle.Show();
            rectangle.Show();

            System.out.println("\nЦилиндры:");
            cylinder1.Show();
            System.out.println();
            cylinder2.Show();

        } catch (NegativeValueException e) {
            // Обработка отрицательных значений
            System.out.println("❌ Ошибка ввода: " + e.getMessage());
            System.out.println("Пожалуйста, введите положительные значения.");

        } catch (InvalidFigureParametersException e) {
            // Обработка некорректных параметров
            System.out.println("❌ Ошибка параметров фигуры: " + e.getMessage());
            System.out.println("Проверьте введенные данные.");

        } catch (Exception e) {
            // Обработка всех остальных исключений
            System.out.println("💥 Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Закрытие сканера в любом случае
            scanner.close();
            System.out.println("\nПрограмма завершена.");
        }
    }
}