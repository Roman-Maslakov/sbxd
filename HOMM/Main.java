package HOMM;

public class Main {
    public static void main(String[] args) {
        // Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин 
        RangeUnit crossbowMan = new CrossbowMan();
        RangeUnit sniper = new Sniper();
        MeleeUnit peasant = new Peasant();
        MeleeUnit spearMan = new SpearMan();
        MeleeUnit bandit = new Bandit();
        Mage mage = new Mage();
        Monk monk = new Monk();
    }
}