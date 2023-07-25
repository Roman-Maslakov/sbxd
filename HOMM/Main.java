package HOMM;

import HOMM.Game.*;

public class Main {
    public static void main(String[] args) {

        Sniper buivol = new Sniper("Buivol", 10, 1);
        Field.addUnit(buivol, Field.blue);
        Field.addUnit(new CrossbowMan("Colya", 10, 2), Field.blue);
        Field.addUnit(new Peasant("Vadimich", 9, 1), Field.blue);
        Field.addUnit(new Peasant("Поц", 9, 2), Field.blue);
        Field.addUnit(new Monk("Монах", 10, 4), Field.blue);
        Field.addUnit(new Mage("ЧародеЙ", 10, 5), Field.blue);
        Field.addUnit(new SpearMan("Копейщик", 9, 3), Field.blue);
        Field.addUnit(new Bandit("Бандит", 9, 5), Field.blue);
        Field.addUnit(new SpearMan("Палка", 9, 7), Field.blue);
        Field.addUnit(new Bandit("Бед", 9, 9), Field.blue);

        CrossbowMan roma = new CrossbowMan("Roma", 1, 1);
        Field.addUnit(roma, Field.red);
        Field.addUnit(new Sniper("Igor", 1, 2), Field.red);
        Field.addUnit(new Monk("Геннадий", 1, 4), Field.red);
        Field.addUnit(new Mage("Василий", 1, 5), Field.red);
        Field.addUnit(new Peasant("Пацан", 2, 1), Field.red);
        Field.addUnit(new Peasant("Пацан2", 2, 2), Field.red);
        Field.addUnit(new SpearMan("Красное копье", 2, 3), Field.red);
        Field.addUnit(new Bandit("Негодяй", 2, 5), Field.red);
        Field.addUnit(new SpearMan("Алевтий", 2, 7), Field.red);
        Field.addUnit(new Bandit("Приколист", 2, 9), Field.red);
        

        //System.out.println(Field.mapInfo());

        Field.battle();

        //System.out.println(Field.mapInfo());
    }

    // public static BaseUnit randomUnit(int dice) {
    // switch (dice) {
    // case 0:
    // return new Bandit();
    // case 1:
    // return new CrossbowMan();
    // case 2:
    // return new Mage();
    // case 3:
    // return new Monk();
    // case 4:
    // return new Peasant();
    // case 5:
    // return new SpearMan();
    // default:
    // return new Sniper();
    // }
    // }
}