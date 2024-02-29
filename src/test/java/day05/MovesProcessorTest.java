package day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class MovesProcessorTest {

    @Test
    public void processLine() {
        //given
        HashMap<Integer, Stack<Character>> cranesAtPosition = new HashMap<>();

        Stack<Character> stackZero = new Stack<>();
        stackZero.push('A');
        stackZero.push('B');
        stackZero.push('C');
        cranesAtPosition.put(0, stackZero);

        Stack<Character> stackOne = new Stack<>();
        stackOne.push('D');
        stackOne.push('E');
        cranesAtPosition.put(1, stackOne);

        //when
        MovesProcessor movesProcessor = new MovesProcessor(List.of("move 2 from 1 to 2"), cranesAtPosition);
        movesProcessor.setStrategy(new OneAtTimeStrategy());
        movesProcessor.processLines();

        //then
        assertEquals(List.of('A'), movesProcessor.getCranesFinalSetup().get(0));
        assertEquals(List.of('D', 'E', 'C', 'B'), movesProcessor.getCranesFinalSetup().get(1));
    }
}