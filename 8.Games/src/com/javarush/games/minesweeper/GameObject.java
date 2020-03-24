package com.javarush.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    public int countMineNeighbors;
    public boolean isOpen;
    public boolean isMine;
    public boolean isFlag;

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }
}
