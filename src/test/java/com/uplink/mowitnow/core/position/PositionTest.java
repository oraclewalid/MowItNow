package com.uplink.mowitnow.core.position;

import com.uplink.mowitnow.core.domain.Orientation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.uplink.mowitnow.core.domain.Orientation;
import com.uplink.mowitnow.core.position.Position;
import com.uplink.mowitnow.core.position.PositionHandler;
import com.uplink.mowitnow.core.position.PositionHandlerFactory;
import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void simpleMoveToNorth(){

        PositionHandler northPositionHandler= PositionHandlerFactory.getPositionHandler(Orientation.N);
        Position newPosition = northPositionHandler.move(new Position(1, 1));
        assertThat(newPosition).isEqualsToByComparingFields(new Position(1,2));
    }

    @Test
    public void multipleMoveToNorth(){

        PositionHandler northPositionHandler= PositionHandlerFactory.getPositionHandler(Orientation.N);
        Position secondPosition = northPositionHandler.move(new Position(1, 1));
        Position thirdPosition = northPositionHandler.move(secondPosition);
        assertThat(thirdPosition).isEqualsToByComparingFields(new Position(1,3));
    }
    @Test
    public void simpleMoveToSouth(){

        PositionHandler northPositionHandler= PositionHandlerFactory.getPositionHandler(Orientation.S);
        Position newPosition = northPositionHandler.move(new Position(1, 1));
        assertThat(newPosition).isEqualsToByComparingFields(new Position(1,0));
    }

    @Test
    public void multipleMoveToSouth(){

        PositionHandler southPositionHandler = PositionHandlerFactory.getPositionHandler(Orientation.S);
        Position secondPosition = southPositionHandler.move(new Position(1, 2));
        Position thirdPosition = southPositionHandler.move(secondPosition);
        assertThat(thirdPosition).isEqualsToByComparingFields(new Position(1,0));
    }
    @Test
    public void simpleMoveToEast(){

        PositionHandler eastPositionHandler= PositionHandlerFactory.getPositionHandler(Orientation.E);
        Position newPosition = eastPositionHandler.move(new Position(1, 1));
        assertThat(newPosition).isEqualsToByComparingFields(new Position(2,1));
    }

    @Test
    public void multipleMoveToEast(){

        PositionHandler eastPositionHandler= PositionHandlerFactory.getPositionHandler(Orientation.E);
        Position secondPosition = eastPositionHandler.move(new Position(1, 1));
        Position thirdPosition = eastPositionHandler.move(secondPosition);
        assertThat(thirdPosition).isEqualsToByComparingFields(new Position(3,1));
    }
    @Test
    public void simpleMoveToWest(){

        PositionHandler eastPositionHandler = PositionHandlerFactory.getPositionHandler(Orientation.W);
        Position newPosition = eastPositionHandler.move(new Position(2 , 2));
        assertThat(newPosition).isEqualsToByComparingFields(new Position(1 , 2));
    }

    @Test
    public void multipleMoveToWest(){

        PositionHandler westPositionHandler = PositionHandlerFactory.getPositionHandler(Orientation.W);
        Position secondPosition = westPositionHandler.move(new Position(2, 2));
        Position thirdPosition = westPositionHandler.move(secondPosition);
        assertThat(thirdPosition).isEqualsToByComparingFields(new Position(0 , 2));
    }

}