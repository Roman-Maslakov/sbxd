package HOMM;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        BaseUnit[] team1 = new BaseUnit[10];
        BaseUnit[] team2 = new BaseUnit[10];

        for (int i = 0; i < 10; i++) {
            team1[i] = randomUnit(new Random().nextInt(8));
            team2[i] = randomUnit(new Random().nextInt(8));
        }

        System.out.println("Команда красных ");
        for (BaseUnit unit : team1) { System.out.println(unit.getInfo()); }
        System.out.println("\nКоманда синих ");
        for (BaseUnit unit : team2) { System.out.println(unit.getInfo()); }

        
    }

    public static BaseUnit randomUnit(int dice) {
        switch (dice) {
            case 0:
                return new Bandit();
            case 1:
                return new CrossbowMan();
            case 2:
                return new Mage();
            case 3:
                return new Monk();
            case 4:
                return new Peasant();
            case 5:
                return new Bandit();
            case 6:
                return new SpearMan();
            default:
                return new Sniper();
        }
    }
}
