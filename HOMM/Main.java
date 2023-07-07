package HOMM;

import HOMM.Units.*;

public class Main {
    public static void main(String[] args) {

        Peasant farmer = new Peasant("Бедный Крестьянин", 2, 2);
        Peasant farmer2 = new Peasant("Бедный Крестьянин2", 2, 5);
        Peasant farmer3 = new Peasant("Бедный Крестьянин3", 2, 7);
        CrossbowMan archer = new CrossbowMan("Лучник на противоположном конце карты", 9, 0);

        Field.addUnit(farmer, Field.redTeam);
        Field.addUnit(archer, Field.blueTeam);
        Field.addUnit(farmer2, Field.redTeam);
        Field.addUnit(farmer3, Field.redTeam);
        BaseUnit closestToArcher = archer.findClosestEnemy();

        System.out.println(Field.getMapInfo());
        System.out.printf("Ближайший противник для %s - %s, расстояние до противника - %d клеток", 
                            archer.getName(), closestToArcher.getName(), archer.getDistance(closestToArcher));
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