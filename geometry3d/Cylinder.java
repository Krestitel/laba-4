package geometry3d;
import geometry2d.Figure;
import exceptions.NegativeValueException;
import exceptions.InvalidFigureParametersException;
import java.util.logging.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cylinder {
    private Figure base;
    private double height;
    private static final Logger logger = Logger.getLogger(Cylinder.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("cylinder.log", true);
            fileHandler.setFormatter(new Formatter() {
                private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                @Override
                public String format(LogRecord record) {
                    return String.format("[%s] [%s] %s - %s%n",
                            dateFormat.format(new Date(record.getMillis())),
                            record.getLevel().getName(),
                            record.getLoggerName(),
                            record.getMessage());
                }
            });
            fileHandler.setLevel(Level.FINEST);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.FINEST);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            System.err.println("Ошибка инициализации логгера: " + e.getMessage());
        }
    }

    public Cylinder(Figure base, double height) {
        if (base == null) {
            logger.severe("Попытка создания цилиндра с null основанием");
            throw new InvalidFigureParametersException("Основание не может быть null");
        }
        if (height < 0) {
            logger.severe("Попытка создания цилиндра с отрицательной высотой: " + height);
            throw new NegativeValueException("Высота цилиндра не может быть отрицательной: " + height);
        }
        if (height == 0) {
            logger.severe("Попытка создания цилиндра с нулевой высотой");
            throw new InvalidFigureParametersException("Высота цилиндра не может быть нулевой");
        }
        this.base = base;
        this.height = height;
        logger.finest("Создан цилиндр с основанием типа: " + base.getClass().getSimpleName() + ", высота=" + height);
    }

    public double Volume() {
        double volume = base.Area() * height;
        logger.finest("Вычислен объем цилиндра: " + volume);
        return volume;
    }

    public void Show() {
        System.out.print("Цилиндр: ");
        base.Show();
        System.out.println(" высота = " + height + ", объем = " + String.format("%.2f", Volume()));
        logger.finest("Отображение информации о цилиндре");
    }
}