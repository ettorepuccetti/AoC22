package day05;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        firstSolver();
        secondSolver();
    }

    private static void secondSolver() {
        List<String> fileInput = FileReader.readFile("src/main/java/day05/input.txt");
        InputFileSplitter inputFileSplitter = new InputFileSplitter(fileInput);
        LabelExtractor labelExtractor = new LabelExtractor(inputFileSplitter.getCranesSetupLines());
        HashMap<Integer, Stack<Character>> cranesInitialConfig = labelExtractor.getCranesInitialSetup();
        MovesProcessor movesProcessor = new MovesProcessor(inputFileSplitter.getMovesLines(), cranesInitialConfig);
        movesProcessor.setStrategy(new AllTogetherStrategy());
        movesProcessor.processLines();
        HashMap<Integer, Stack<Character>> cranesFinalConfig = movesProcessor.getCranesFinalSetup();
        StringBuilder result = new StringBuilder();
        for (int pos : cranesFinalConfig.keySet()) {
            result.append(cranesFinalConfig.get(pos).pop());
        }
        System.out.println("Second Problem: " + result);
    }

    static void firstSolver() {
        List<String> fileInput = FileReader.readFile("src/main/java/day05/input.txt");
        InputFileSplitter inputFileSplitter = new InputFileSplitter(fileInput);
        LabelExtractor labelExtractor = new LabelExtractor(inputFileSplitter.getCranesSetupLines());
        HashMap<Integer, Stack<Character>> cranesInitialConfig = labelExtractor.getCranesInitialSetup();
        MovesProcessor movesProcessor = new MovesProcessor(inputFileSplitter.getMovesLines(), cranesInitialConfig);
        movesProcessor.setStrategy(new OneAtTimeStrategy());
        movesProcessor.processLines();
        HashMap<Integer, Stack<Character>> cranesFinalConfig = movesProcessor.getCranesFinalSetup();

        StringBuilder result = new StringBuilder();
        for (int pos : cranesFinalConfig.keySet()) {
            result.append(cranesFinalConfig.get(pos).pop());
        }
        System.out.println("First problem: " + result);
    }
}