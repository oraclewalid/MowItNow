package com.uplink.mowitnow.core.position;

import com.uplink.mowitnow.core.domain.Orientation;

/**
 * Created by walid on 12/09/14.
 */
public class PositionHandlerFactory {

    public static PositionHandler getPositionHandler(Orientation orientation){
        switch (orientation){
            case N:
                return new PositionHandler.NorthPositionHandler();
            case S:
                return new PositionHandler.SouthPositionHandler();
            case E:
                return new PositionHandler.EastPositionHandler();
            case W:
                return new PositionHandler.WestPositionHandler();
            default:
                return null;
        }
    }
}
