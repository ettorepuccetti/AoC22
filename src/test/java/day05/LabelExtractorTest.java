package day05;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LabelExtractorTest {

    @Test
    public void processLineBasic() {
        //given
        String input = "[D]";
        LabelExtractor labelExtractor = new LabelExtractor(List.of(input));

        //when
        HashMap<Integer, Stack<Character>> result = labelExtractor.getCranesInitialSetup();

        //then
        assertEquals(List.of('D'), result.get(0));
        assertEquals(1, result.size());
    }

    @Test
    public void processLineEmptyBeforeAndAfter() {
        //given
        String input = "    [D] [N]    ";
        LabelExtractor labelExtractor = new LabelExtractor(List.of(input));

        //when
        HashMap<Integer, Stack<Character>> result = labelExtractor.getCranesInitialSetup();

        //then
        assertNull(result.get(0));
        assertEquals(List.of('D'), result.get(1));
        assertEquals(List.of('N'), result.get(2));
        assertEquals(2, result.size());
    }

    @Test
    public void processLineNoEmpty() {
        //given
        String input = "[D] [N]";
        LabelExtractor labelExtractor = new LabelExtractor(List.of(input));

        //when
        HashMap<Integer, Stack<Character>> result = labelExtractor.getCranesInitialSetup();

        //then
        assertEquals(List.of('D'), result.get(0));
        assertEquals(List.of('N'), result.get(1));
        assertEquals(2, result.size());
    }

    @Test
    public void addMultiLines() {
        String[] input = {"[A] [B]", "[C] [D]"};
        LabelExtractor labelExtractor = new LabelExtractor(Arrays.stream(input).toList());

        //when
        HashMap<Integer, Stack<Character>> result = labelExtractor.getCranesInitialSetup();

        //then
        assertEquals(2, result.size());
        assertEquals(List.of('C', 'A'), result.get(0));
        assertEquals(List.of('D', 'B'), result.get(1));
    }
}