package com.uplink.mowitnow.utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by walid on 14/09/14.
 */
public class StringUtil {

    public static int BLANC_SPACE_INT_CODE = (int)' ';

    static public List<String> getStringsAsListOfCharacter(String fistLine) {

        return fistLine.trim()
                .chars()
                .filter(i -> i != BLANC_SPACE_INT_CODE)
                .mapToObj(i -> Character.toString((char) i))
                .collect(Collectors.toList());
    }
}
