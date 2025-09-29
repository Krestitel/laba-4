package test;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Тестирование геометрических фигур ===\n");

        // Ввод данных для круга
        System.out.print("Введите радиус круга: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleRadius);

        // Ввод данных для прямоугольника
        System.out.print("Введите ширину прямоугольника: ");
        double rectWidth = scanner.nextDouble();
        System.out.print("Введите высоту прямоугольника: ");
        double rectHeight = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectWidth, rectHeight);

        // Ввод данных для цилиндров
        System.out.print("Введите высоту цилиндра с круглым основанием: ");
        double cylinder1Height = scanner.nextDouble();
        System.out.print("Введите высоту цилиндра с прямоугольным основанием: ");
        double cylinder2Height = scanner.nextDouble();

        // Создание объектов
        Cylinder cylinder1 = new Cylinder(circle, cylinder1Height);
        Cylinder cylinder2 = new Cylinder(rectangle, cylinder2Height);

        // Вывод результатов
        System.out.println("\n=== Результаты ===");
        System.out.println("2D фигуры:");
        circle.Show();
        rectangle.Show();

        System.out.println("\nЦилиндры:");
        cylinder1.Show();
        System.out.println();
        cylinder2.Show();

        scanner.close();
    }
}