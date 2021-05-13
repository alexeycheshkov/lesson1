package com.geekbrains.lesson2_OOP.homework;

public class Wall implements Let {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    @Override
    public boolean letGo(Player player) {
        return player.jump(this);
    }
}
