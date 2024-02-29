package day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class AllTogetherStrategyTest {

    @Test
    public void applyMove() {
        //given
        Move move = new Move(2, 0, 1);
        Stack<Character> stackOne = new Stack<>();
        stackOne.push('C');
        stackOne.push('B');
        stackOne.push('A');

        Stack<Character> stackTwo = new Stack<>();
        stackTwo.push('E');
        stackTwo.push('D');

        HashMap<Integer, Stack<Character>> craneSetup = new HashMap<>();
        craneSetup.put(0, stackOne);
        craneSetup.put(1, stackTwo);

        //when
        Strategy allTogetherStrategy = new AllTogetherStrategy();
        allTogetherStrategy.applyMove(move, craneSetup);

        //then
        assertEquals(List.of('C'), craneSetup.get(0));
        assertEquals(List.of('E', 'D', 'B', 'A'), craneSetup.get(1));

    }
}