package minessearcher;

public class Main {

    public static void main(String[] args) {
        MinesSearcher minesSearcher = new MinesSearcher();
        String[][] finalMap = minesSearcher.processMinesSearcher(args[0]);
        String finalResult = minesSearcher.getPrintString(finalMap);
        System.out.println(finalResult);
    }

}
