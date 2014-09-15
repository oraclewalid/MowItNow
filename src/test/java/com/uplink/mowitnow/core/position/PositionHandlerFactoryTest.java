package com.uplink.mowitnow.core.position;

import com.uplink.mowitnow.core.domain.Orientation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.uplink.mowitnow.core.domain.Orientation;
import com.uplink.mowitnow.core.position.PositionHandler;
import com.uplink.mowitnow.core.position.PositionHandlerFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionHandlerFactoryTest {


    @Test
    public void testGetOrientationOfNorth() throws Exception {

        assertThat(PositionHandlerFactory.getPositionHandler(Orientation.N)).isInstanceOf(PositionHandler.NorthPositionHandler.class);
        assertThat(PositionHandlerFactory.getPositionHandler(Orientation.S)).isInstanceOf(PositionHandler.SouthPositionHandler.class);
        assertThat(PositionHandlerFactory.getPositionHandler(Orientation.E)).isInstanceOf(PositionHandler.EastPositionHandler.class);
        assertThat(PositionHandlerFactory.getPositionHandler(Orientation.W)).isInstanceOf(PositionHandler.WestPositionHandler.class);
    }

}