package HOMM.Game;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseUnit implements Interface {

    public String state = "ready";
    private Integer x, y;
    private ArrayList<BaseUnit> team;
    private String name;
    private int[] damage = new int[2];
    private int hp;
    private int maxHp;
    private int initiative;
    private int speed;

    /**
     * Характеристики юнита
     * 
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     */

    public BaseUnit(String name, int[] damage, int hp, int initiative, int speed, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.maxHp = hp;
        this.initiative = initiative;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public String getName() {
        return this.name;
    }

    public String getNameTeam() {
        return this.team.equals(Field.red) ? "Красных" : "Синих";
    }

    public ArrayList<BaseUnit> getTeam() {
        return this.team;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getDamage() {
        return new Random().nextInt(this.damage[0], this.damage[1] + 1);
    }

    public int getInitiative() {
        return this.initiative;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTeam(ArrayList<BaseUnit> team) {
        this.team = team;
    }

    protected void setHp(int dif) {
        if (this.hp <= dif) {
            this.hp = 0;
            this.state = "dead";
        }
        else this.hp -= dif;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
    }

    public boolean isAlive() {
        if (state.equals("ready") || state.equals("busy"))
            return true;
        return false;
    }

    // public String getInfo() {
    //     return String.format("Юнит: %s, Имя: %s, клетка на поле х: %d y: %d, команда: %s, хп: %d\n",
    //             getClass(), getName(), this.x + 1, this.y + 1, getNameTeam(), this.hp)
    //             .replace("class HOMM.Game.", "");
    // }
    
    public String getInfo() {
        return String.format("Юнит: %s, Имя: %s",
                getClass(), getName())
                .replace("class HOMM.Game.", "");
    }

    public int getDistance(BaseUnit unit) {
        if (unit.isAlive())
            return (int) (Math.ceil(Math.sqrt(Math.pow(unit.getX() - this.x, 2) + Math.pow(unit.getY() - this.y, 2))));
        else
            return -1;
    }

    public BaseUnit findClosestUnit(ArrayList<BaseUnit> team) {
        BaseUnit closest = null;
        int minDistance = 13; // максимальная дистанция на поле +1
        for (BaseUnit unit : team) {
            if (unit.isAlive() && minDistance > getDistance(unit)) {
                minDistance = getDistance(unit);
                closest = unit;
            }
        }
        return closest;
    }
}