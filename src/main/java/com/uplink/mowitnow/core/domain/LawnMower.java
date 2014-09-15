package com.uplink.mowitnow.core.domain;

import com.uplink.mowitnow.core.position.Position;

/**
 * Created by walid on 12/09/14.
 */
public class LawnMower {

    private Integer id;

    private Position position;

    private Orientation orientation;

    public LawnMower(int id, Position position, Orientation orientation) {
        this.id = id;
        this.position = position;
        this.orientation = orientation;
    }

    public Integer getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setOrientation(Instruction instruction) {
        orientation = orientation.getOrientation(instruction);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\"id\" : %d, \"x\": %d, \"y\": %d , \"orientation\" : \"%s\"",
                this.id ,this.getPosition().getX(),
                this.getPosition().getY() ,
                orientation.name()));
        return sb.toString();
    }

    public static class LawnMowerBuilder {

        private int id ;

        private int x;

        private int y;

        private Orientation orientation;

        public LawnMowerBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public LawnMowerBuilder setX(String x) {
            this.x = Integer.parseInt(x);
            return this;
        }
        public LawnMowerBuilder setY(String y) {
            this.y = Integer.parseInt(y);
            return this;
        }

        public LawnMowerBuilder setOrientation(String orientation) {
            this.orientation = Orientation.valueOf(orientation);
            return this;
        }

        public LawnMower createLawnMower() {
            return new LawnMower(id ,new Position(x , y), orientation);
        }
    }
}