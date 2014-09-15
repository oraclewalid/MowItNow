package com.uplink.mowitnow.core.parser;

import com.uplink.mowitnow.core.context.Paire;
import com.uplink.mowitnow.core.domain.Area;
import com.uplink.mowitnow.core.domain.Instruction;
import com.uplink.mowitnow.core.domain.LawnMower;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MowItNowParserTest {

    MowItNowParser parser ;

    List<String> inputDataList;

    @Before
    public void setup(){
        inputDataList = Lists.newArrayList("5 5" ,"1 2 N" ,"GAGAGAGAA","3 3 E","AADAADADDA");
        parser = new MowItNowParser(inputDataList);
    }

    @Test
    public void testGetArea() throws Exception {

        assertThat(parser.getArea()).isEqualsToByComparingFields(new Area(5,5));
    }

    @Test
    public void testGetListLawnMowerWithShortInstruction() throws Exception {

        inputDataList = Lists.newArrayList("5 5" ,"1 1 N" ,"A");
        parser = new MowItNowParser(inputDataList);

        List<Paire<List<Instruction>, LawnMower>> listLawnMowerWithInstruction = parser.getListLawnMowerWithInstruction();

        assertThat(listLawnMowerWithInstruction).hasSize(1);
        assertThat(listLawnMowerWithInstruction.get(0).getLeftElement()).containsSequence(Instruction.A);

    }
    @Test
    public void testGetListLawnMowerWithLongInstruction() throws Exception {

        List<Paire<List<Instruction>, LawnMower>> listLawnMowerWithInstruction = parser.getListLawnMowerWithInstruction();

        assertThat(listLawnMowerWithInstruction).hasSize(2);
        assertThat(listLawnMowerWithInstruction.get(0).getLeftElement()).containsSequence(Instruction.G, Instruction.A, Instruction.G,
                Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A);
        assertThat(listLawnMowerWithInstruction.get(1).getLeftElement()).containsSequence(Instruction.A , Instruction.A, Instruction.D, Instruction.A, Instruction.A,
                Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A);

    }
}