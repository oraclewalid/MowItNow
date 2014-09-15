package com.uplink.mowitnow.core.context;

import com.uplink.mowitnow.core.Exception.OutOfAreaException;
import com.uplink.mowitnow.core.parser.MowItNowParser;
import com.uplink.mowitnow.core.position.Position;
import com.uplink.mowitnow.core.domain.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * Created by walid on 13/09/14.
 */
public abstract class AbstractMowItNowContext {

    private MowItNowParser parser;

    private Area area;

    private List<Paire<List<Instruction>, LawnMower>> listLawnMowerWithInstruction;

    public AbstractMowItNowContext(String commands) throws IOException {
        this.parser = new MowItNowParser(commands);
    }

    public void parse() {
        try {
            parseArea();
            parseLawnMowers();
        } catch (Exception e) {
            notify(NotificationType.ERROR , "parsing error");
        }
    }

    protected void parseArea() throws IOException {
        area = parser.getArea();
        notify(NotificationType.INIT , area.toString());
    }

    protected void parseLawnMowers() throws IOException {

        listLawnMowerWithInstruction = parser.getListLawnMowerWithInstruction();
        listLawnMowerWithInstruction.stream()
                .forEach(paire -> notify(NotificationType.UPDATE , paire.getRightElement().toString()));
    }


    public abstract void notify(NotificationType notificationType ,String message);

    public abstract void move();

    public void isInTheArea(Position position){
        if(!area.isInArea(position))
            throw new OutOfAreaException("the mower is out of area");
    }

    public List<Paire<List<Instruction>, LawnMower>> getListLawnMowerWithInstruction() {
        return listLawnMowerWithInstruction;
    }
}
