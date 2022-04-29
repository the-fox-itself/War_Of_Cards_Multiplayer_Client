package GameMechanic.Objects.GameObjects; //Пакет класса.

import static ServerMechanic.ServerMainGUIVariables.COLOR_OBJECT_WATER; //Импорт нужного цвета.

public class ObjectWater extends GameObject { //Вода.
    public ObjectWater() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectWater...");
        width = (int) (Math.random() * 171) + 30; //Определяется размер.
        height = width; //Она круглая, поэтому её длины должны быть одинаковыми.
        color = COLOR_OBJECT_WATER; //Её цвет.
        name = "Water"; //Её название.
        System.out.println("Finished creating object of class ObjectWater.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = null;
        iconOfNearby = null;
    }
}
