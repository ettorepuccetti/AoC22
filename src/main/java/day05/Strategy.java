package day05;

import java.util.HashMap;
import java.util.Stack;

public interface Strategy {
    void applyMove(Move move, HashMap<Integer, Stack<Character>> cranesSetup);
}
