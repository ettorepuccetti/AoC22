package day05;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputFileSplitterTest {


    @Test
    public void InputFileSplitter() {
        List<String> inputFile = List.of(
                "[Z] [M] [P]\n",
                " 1   2   3\n",
                "\n",
                "move 1 from 2 to 1"
        );

        InputFileSplitter inputFileSplitter = new InputFileSplitter(inputFile);

        assertEquals(List.of("[Z] [M] [P]\n"), inputFileSplitter.getCranesSetupLines());
        assertEquals(List.of("move 1 from 2 to 1"), inputFileSplitter.getMovesLines());
    }
}