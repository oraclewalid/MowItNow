package com.uplink.mowitnow.core.domain;

import com.uplink.mowitnow.core.position.Position;
import com.uplink.mowitnow.core.position.PositionHandler;
import com.uplink.mowitnow.core.position.PositionHandlerFactory;

import java.util.List;

/**
 * Created by walid on 12/09/14.
 */
public enum Instruction {

    G {
        @Override
        public void move(LawnMower lawnMower) {
            lawnMower.setOrientation(this);
        }
    },
    D {
        @Override
        public void move(LawnMower lawnMower) {
            lawnMower.setOrientation(this);
        }
    },
    A {
        @Override
        public void move(LawnMower lawnMower) {
            PositionHandler positionHandler = PositionHandlerFactory.getPositionHandler(lawnMower.getOrientation());
            Position position = positionHandler.move(lawnMower.getPosition());
            lawnMower.setPosition(position);
        }
    };

    abstract public void move(LawnMower lawnMower);
}
