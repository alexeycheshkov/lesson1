package com.geekbrains.lesson2_OOP.homework;

public class RunRoad implements Let{
    private int roadDistance;

    public RunRoad(int roadDistance) {
        this.roadDistance = roadDistance;
    }

    public int getRoadDistance() {
        return roadDistance;
    }

    @Override
    public boolean letGo(Player player) {
        return player.run(this);
    }
}
