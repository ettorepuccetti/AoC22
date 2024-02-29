package day05;

import java.util.ArrayList;
import java.util.List;

public class InputFileSplitter {

    private final List<String> cranesSetup = new ArrayList<>();
    private final List<String> listOfMoves = new ArrayList<>();


    public InputFileSplitter(List<String> inputLines) {
        boolean breakingLineFound = false;
        for (String line : inputLines) {
            if (line.startsWith(" 1") || line.isBlank()) {
                breakingLineFound = true;
                continue;
            }
            if (!breakingLineFound) {
                cranesSetup.add(line);
            } else {
                listOfMoves.add(line);
            }
        }
    }

    public List<String> getCranesSetupLines() {
        return cranesSetup;
    }

    public List<String> getMovesLines() {
        return listOfMoves;
    }
}
