package com.challenge.snail;

public class Position {
    public int top;
    public int bottom;
    public int left;
    public int right;

    public Position(int rows, int cols) {
        this.top = 0;
        this.bottom = rows - 1;
        this.left = 0;
        this.right = cols - 1;
    }
}