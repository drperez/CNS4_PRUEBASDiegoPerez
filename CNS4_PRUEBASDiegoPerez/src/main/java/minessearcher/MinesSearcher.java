package minessearcher;

import java.io.BufferedReader;
import java.io.FileReader;

public class MinesSearcher {

    public String[][] processMinesSearcher(String entryFile) {
        String[][] finalMap = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(entryFile));
            boolean isFirstTime = true;
            Integer lineCounter = 0;
            String line;
            String[] arraySize = null;
            while ((line = in.readLine()) != null) {
                if (isFirstTime) {
                    arraySize = line.split(" ");
                    finalMap = new String[Integer.valueOf(arraySize[0])][Integer.valueOf(arraySize[1])];
                    isFirstTime= false;
                    continue;
                }
                
                String[] columnsInLine = line.split("");
                for (int i = 0; i < columnsInLine.length; i++) {
                    finalMap[lineCounter][i] = columnsInLine[i];
                }
                
                lineCounter++;
            }
            in.close();
            
            return finalMap;
            
        } catch (Exception e) {
            return finalMap;
        }
    }

}
