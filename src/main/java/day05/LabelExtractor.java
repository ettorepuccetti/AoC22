package day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LabelExtractor {

    private final HashMap<Integer, List<Character>> cranesAtPosition = new HashMap<>();
    private final HashMap<Integer, Stack<Character>> cranesAtPositionStack = new HashMap<>();

    LabelExtractor(List<String> inputLines) {
        for (String line : inputLines) {
            processLine(line);
        }
        creteStackFromList();
    }

    private void creteStackFromList() {
        for (int position : cranesAtPosition.keySet()) {
            List<Character> characterList = cranesAtPosition.get(position);
            Stack<Character> characterStack = new Stack<>();
            characterStack.addAll(characterList.reversed());
            cranesAtPositionStack.put(position, characterStack);
        }
    }

    private void processLine(String inputLine) {
        for (int i = 0; i < (inputLine.length() + 1) / 4; i = i + 1) {

            // read crane label
            int posToRead = (i * 4) + 1;
            Character craneLabel = inputLine.charAt(posToRead);

            // discard empty char
            if (craneLabel.equals(' ')) {
                continue;
            }

            // initialize list if not yet
            if (!cranesAtPosition.containsKey(i)) {
                cranesAtPosition.put(i, new ArrayList<>());
            }

            // access list at position and insert
            cranesAtPosition.get(i).add(craneLabel);
        }
    }

    public HashMap<Integer, Stack<Character>> getCranesInitialSetup() {
        return cranesAtPositionStack;
    }
}
