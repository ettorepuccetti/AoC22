package day05;

import java.util.HashMap;
import java.util.Stack;

public class OneAtTimeStrategy implements Strategy {
    @Override
    public void applyMove(Move move, HashMap<Integer, Stack<Character>> cranesSetup) {
        Stack<Character> stackFrom = cranesSetup.get(move.from);
        Stack<Character> stackTo = cranesSetup.get(move.to);
        for (int i = 0; i < move.numberOfElement; i++) {
            Character element = stackFrom.pop();
            stackTo.push(element);
        }
    }
}
