package com.uplink.mowitnow.core.position;

/**
 * Created by walid on 12/09/14.
 */
public class Position implements Cloneable{

    int x;

    int y;

    public Position( int x ,int y) {

        this.y = y;
        this.x = x;
    }

    public Position(Position position) {

        this.y = position.getY();
        this.x = position.getX();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
