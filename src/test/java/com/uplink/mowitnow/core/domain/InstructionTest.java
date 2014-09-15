package com.uplink.mowitnow.core.domain;

import com.uplink.mowitnow.core.position.Position;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class InstructionTest {


        @Test
        public void testMoveFromNtoG(){

            LawnMower lawnMower = new LawnMower( 1 ,new Position(1 , 2) , Orientation.N);
            Instruction.G.move(lawnMower);
            assertThat(lawnMower.getOrientation()).isEqualTo(Orientation.W);
            assertThat(lawnMower.getPosition()).isEqualsToByComparingFields(new Position(1 , 2));
        }

        @Test
        public void testMoveFromNtoA(){

            LawnMower lawnMower = new LawnMower(1 ,new Position(1 , 2) , Orientation.N);
            Instruction.A.move(lawnMower);
            assertThat(lawnMower.getOrientation()).isEqualTo(Orientation.N);
            assertThat(lawnMower.getPosition()).isEqualsToByComparingFields(new Position(1 , 3));
        }
        @Test
        public void testManyInstructionsFromN(){

            LawnMower lawnMower = new LawnMower(1 ,new Position(1 , 2) , Orientation.N);
            List<Instruction> instructionses = Arrays.asList(Instruction.G, Instruction.A, Instruction.G,
                    Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A);
            instructionses.forEach(command -> command.move(lawnMower));
            assertThat(lawnMower.getOrientation()).isEqualTo(Orientation.N);
            assertThat(lawnMower.getPosition()).isEqualsToByComparingFields(new Position(1 , 3));
        }
        @Test
        public void testManyInstructionFromE(){

            LawnMower lawnMower = new LawnMower(1 ,new Position(3 , 3) , Orientation.E);
            List<Instruction> instructionses = Arrays.asList(Instruction.A , Instruction.A, Instruction.D, Instruction.A, Instruction.A,
                    Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A);
            instructionses.forEach(command -> command.move(lawnMower));
            assertThat(lawnMower.getOrientation()).isEqualTo(Orientation.E);
            assertThat(lawnMower.getPosition()).isEqualsToByComparingFields(new Position(5 , 1));
        }

    }