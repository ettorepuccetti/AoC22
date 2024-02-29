package day05;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MovesProcessor {

    private final List<String> inputLines;
    private final HashMap<Integer, Stack<Character>> cranesAtPosition;
    private Strategy strategy;

    MovesProcessor(List<String> inputLines, HashMap<Integer, Stack<Character>> cranesInitialSetup) {
        this.inputLines = inputLines;
        this.cranesAtPosition = cranesInitialSetup;

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void processLines() {
        for (String line : inputLines) {
            processLine(line);
        }
    }

    private void processLine(@NotNull String line) {
        String[] lineTokens = line.split(" ");
        Move move = new Move(Integer.parseInt(lineTokens[1]), Integer.parseInt(lineTokens[3]) - 1, Integer.parseInt(lineTokens[5]) - 1);
        strategy.applyMove(move, cranesAtPosition);
    }

    public HashMap<Integer, Stack<Character>> getCranesFinalSetup() {
        return cranesAtPosition;
    }
}
