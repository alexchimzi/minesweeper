package org.example;

public class Tile {
    public boolean getFlag() {
        return flag;
    }

    public void setFlag() {
        this.flag = !this.flag;
    }

    boolean flag;

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    boolean bomb;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    int number;

    public Tile( ){
        this.flag = false;
    }

}
