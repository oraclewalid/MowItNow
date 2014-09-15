package com.uplink.mowitnow.core.domain;

import com.uplink.mowitnow.core.position.Position;

/**
 * Created by walid on 12/09/14.
 */
public class Area {

    int x;

    int y;

    public Area(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInArea(Position position){
        return (position.getX() <= x) && (position.getY() <= y);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"x\": %d, \"y\": %d",x, y));
        return sb.toString();
    }
}
