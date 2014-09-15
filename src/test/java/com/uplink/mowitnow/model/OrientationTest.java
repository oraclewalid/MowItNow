package com.uplink.mowitnow.model;

import com.uplink.mowitnow.core.domain.Instruction;
import com.uplink.mowitnow.core.domain.Orientation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class OrientationTest{

    @Test
    public void testGetOrientationOfNorth() throws Exception {

        assertThat(Orientation.N.getOrientation(Instruction.D)).isEqualTo(Orientation.E);
        assertThat(Orientation.N.getOrientation(Instruction.G)).isEqualTo(Orientation.W);
    }

    @Test
    public void testGetOrientationOfEast() throws Exception {

        assertThat(Orientation.E.getOrientation(Instruction.D)).isEqualTo(Orientation.S);
        assertThat(Orientation.E.getOrientation(Instruction.G)).isEqualTo(Orientation.N);
    }

    @Test
    public void testGetOrientationOfSouth() throws Exception {

        assertThat(Orientation.S.getOrientation(Instruction.D)).isEqualTo(Orientation.W);
        assertThat(Orientation.S.getOrientation(Instruction.G)).isEqualTo(Orientation.E);
    }

    @Test
    public void testGetOrientationOfWest() throws Exception {

        assertThat(Orientation.W.getOrientation(Instruction.D)).isEqualTo(Orientation.N);
        assertThat(Orientation.W.getOrientation(Instruction.G)).isEqualTo(Orientation.S);
    }
    @Test
    public void testWrongCommand() throws Exception {

        assertThat(Orientation.W.getOrientation(Instruction.A)).isNull();
    }

}