package HOMM;

import HOMM.Units.*;

public class Main {
    public static void main(String[] args) {

        Sniper buivol = new Sniper("BuivolSniper", 10, 1);
        Field.addUnit(buivol, Field.blue);
        Field.addUnit(new CrossbowMan("ColyaArcher", 10, 2), Field.blue);
        Field.addUnit(new Sniper("VadimSniper", 10, 3), Field.blue);

        CrossbowMan roma = new CrossbowMan("RomaArcher", 1, 1);
        Field.addUnit(roma, Field.red);
        Field.addUnit(new Sniper("IgorSniper", 1, 8), Field.red);
        Field.addUnit(new CrossbowMan("VityaArcher", 1, 2), Field.red);
        Field.addUnit(new Sniper("VladislavSniper", 1, 5), Field.red);
        Field.addUnit(new Sniper("StanislavSniper", 1, 5), Field.red);
        
        System.out.println(Field.mapInfo());

        Field.battle();

        System.out.println(Field.mapInfo());
    }

    // public static BaseUnit randomUnit(int dice) {
    //     switch (dice) {
    //         case 0:
    //             return new Bandit();
    //         case 1:
    //             return new CrossbowMan();
    //         case 2:
    //             return new Mage();
    //         case 3:
    //             return new Monk();
    //         case 4:
    //             return new Peasant();
    //         case 5:
    //             return new SpearMan();
    //         default:
    //             return new Sniper();
    //     }
    // }
}