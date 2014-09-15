package com.uplink.mowitnow.core.parser;

import com.uplink.mowitnow.core.context.Paire;
import com.uplink.mowitnow.core.domain.Area;
import com.uplink.mowitnow.core.domain.Instruction;
import com.uplink.mowitnow.core.domain.LawnMower;
import com.uplink.mowitnow.utils.StringUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by walid on 13/09/14.
 */
public class MowItNowParser {

    public static final String RETOURN_LINE_PATTERN = "\\r?\\n";


    private List<String> inputDataList;

    public MowItNowParser(String commands) throws IOException {
        inputDataList = Arrays.asList(commands.split(RETOURN_LINE_PATTERN));
    }

    public MowItNowParser(List<String> inputDataList) {
        this.inputDataList = inputDataList;
    }

    private List<String> parseCommandFile(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

    public Area getArea(){

        List<String> collect = StringUtil.getStringsAsListOfCharacter(inputDataList.get(0).trim());
        return new Area(
                Integer.parseInt(collect.get(0)) ,
                Integer.parseInt(collect.get(1))
        );
    }

    public List<Paire<List<Instruction>, LawnMower>> getListLawnMowerWithInstruction(){

        List<Paire<List<Instruction> , LawnMower>> listLawnMowerWithInstruction = new ArrayList<>();

        for (int i = 1 ; i < inputDataList.size()  ; i +=2){

            List<String> collect = StringUtil.getStringsAsListOfCharacter(inputDataList.get(i));
            if(collect.isEmpty())
                break;
            LawnMower lawnMower = new LawnMower.LawnMowerBuilder()
                    .setId(i)
                    .setX(collect.get(0))
                    .setY(collect.get(1))
                    .setOrientation(collect.get(2))
                    .createLawnMower();

            List<Instruction> instructions = getCommands(inputDataList.get(i+1).trim());

            listLawnMowerWithInstruction.add(new Paire<List<Instruction> , LawnMower>(instructions , lawnMower));
        }

        return listLawnMowerWithInstruction;
    }

    private List<Instruction> getCommands(String fistLine) {

        List<String> collect = StringUtil.getStringsAsListOfCharacter(fistLine);
        return collect.stream()
                .map(command -> Instruction.valueOf(command))
                .collect(Collectors.toList());
    }
}

