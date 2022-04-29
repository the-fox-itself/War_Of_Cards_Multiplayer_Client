package GameMechanic.Objects.Essences; //Пакет класса

import java.awt.*; //Импорт пакета с классом Color.
import java.io.Serializable;

public abstract class Essence implements Serializable { //Класс-родитель для всех живых объектов на местности.
    public int xOnFrame; //Первая координата этого существа на плоскости.
    public int yOnFrame; //Вторая координата этого существа на плоскости.
    public Color color; //Цвет существа.
    public int width; //Ширина существа.
    public int height; //Длина существа.
    public String name; //Название существа.

    public transient Image icon; //Спрайт объекта.

    int essenceHealth; //Количество жизней существа.
    public double essenceSpeed; //Скорость передвижения существа.
    public int timeOfNextWalk; //Время, спустя которое волк делает следующий шаг, если он не видит игрока.
    public int timePassed = 0; //Вспомогательная переменная для хранения пройденного времени.

    Essence() {
        System.out.println("Created class Essence.");
    }
    public abstract void recovery();
}
