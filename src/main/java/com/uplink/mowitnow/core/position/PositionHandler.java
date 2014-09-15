package com.uplink.mowitnow.core.position;

/**
 * Created by walid on 12/09/14.
 */
public interface PositionHandler {

    Position move(Position position);


    public class NorthPositionHandler implements PositionHandler {

        public Position move(Position position) {

            return new Position(position.getX(), position.getY() + 1);
        }
    }

    public class SouthPositionHandler implements PositionHandler {

        public Position move(Position position) {

            return new Position(position.getX(), position.getY() - 1);
        }
    }

    public class EastPositionHandler implements PositionHandler {

        public Position move(Position position) {

            return new Position(position.getX() + 1, position.getY());
        }
    }

    public class WestPositionHandler implements PositionHandler {

        public Position move(Position position) {

            return new Position(position.getX() - 1, position.getY());
        }
    }
}


