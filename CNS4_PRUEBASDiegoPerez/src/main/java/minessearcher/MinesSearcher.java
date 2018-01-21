package minessearcher;

import java.io.BufferedReader;
import java.io.FileReader;

public class MinesSearcher {

    public String[][] processMinesSearcher(String entryFile) {
        String[][] finalMap = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(entryFile));
            boolean isFirstTime = true;
            boolean isValidMatrix = true;
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
                    if ("*".equals(columnsInLine[i]))
                        finalMap[lineCounter][i] = columnsInLine[i];
                    else if (".".equals(columnsInLine[i]))
                        finalMap[lineCounter][i] = "0";
                    else
                        isValidMatrix = false;
                    
                }
                
                lineCounter++;
            }
            
            in.close();
            
            Integer rowsNumber = Integer.valueOf(arraySize[0]);
            Integer columnsNumber = Integer.valueOf(arraySize[1]);
            
            for (int i = 0; i < rowsNumber; i++) {
                for (int j = 0; j < columnsNumber; j++) {
                    if ("0".equals(finalMap[i][j])) {
                        if ((j + 1) < columnsNumber) {
                            if("*".equals(finalMap[i][j + 1])) {
                                finalMap[i][j] = String.valueOf((Integer.valueOf(finalMap[i][j]) + 1));
                            }
                        }
                        continue;
                    }
                    
                    
                }
            }
            
            return finalMap;
            
        } catch (Exception e) {
            return finalMap;
        }
    }

}
