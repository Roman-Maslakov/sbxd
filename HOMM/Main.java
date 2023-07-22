package HOMM;

import HOMM.Game.*;

public class Main {
    public static void main(String[] args) {

        Sniper buivol = new Sniper("BuivolSniper", 10, 1);
        Field.addUnit(buivol, Field.blue);
        Field.addUnit(new CrossbowMan("ColyaArcher", 10, 2), Field.blue);
        Field.addUnit(new Sniper("VadimSniper", 10, 3), Field.blue);
        Field.addUnit(new Peasant("Vadimich", 9, 1), Field.blue);
        Field.addUnit(new Peasant("Поц", 9, 2), Field.blue);
        Field.addUnit(new Peasant("Чувак", 9, 3), Field.blue);
        Field.addUnit(new Peasant("Чел", 9, 4), Field.blue);
        Field.addUnit(new Monk("Монах", 10, 4), Field.blue);
        Field.addUnit(new Mage("ЧародеЙ", 10, 5), Field.blue);
        Field.addUnit(new Mage("Василий", 10, 6), Field.blue);

        CrossbowMan roma = new CrossbowMan("RomaArcher", 1, 1);
        Field.addUnit(roma, Field.red);
        Field.addUnit(new Sniper("IgorSniper", 1, 2), Field.red);
        Field.addUnit(new Sniper("VityaArcher", 1, 3), Field.red);
        Field.addUnit(new Monk("Геннадий", 1, 4), Field.red);
        Field.addUnit(new Mage("Василий", 1, 5), Field.red);
        Field.addUnit(new Mage("Анатолий", 1, 6), Field.red);
        Field.addUnit(new Peasant("Пацан", 2, 1), Field.red);
        Field.addUnit(new Peasant("Пацан2", 2, 2), Field.red);
        Field.addUnit(new Peasant("Человек", 2, 3), Field.red);
        Field.addUnit(new Peasant("Руффос", 2, 4), Field.red);

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