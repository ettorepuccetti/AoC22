package day05;

import java.util.HashMap;
import java.util.Stack;

public class AllTogetherStrategy implements Strategy {
    @Override
    public void applyMove(Move move, HashMap<Integer, Stack<Character>> cranesSetup) {
        Stack<Character> stackFrom = cranesSetup.get(move.from);
        Stack<Character> stackTo = cranesSetup.get(move.to);
        Stack<Character> aux = new Stack<>();
        for (int i = 0; i < move.numberOfElement; i++) {
            Character element = stackFrom.pop();
            aux.push(element);
        }

        for (int i = 0; i < move.numberOfElement; i++) {
            stackTo.push(aux.pop());
        }
    }
}
