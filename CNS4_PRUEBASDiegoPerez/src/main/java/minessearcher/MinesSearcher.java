package minessearcher;

import java.io.BufferedReader;
import java.io.FileReader;

public class MinesSearcher {

    public String[][] processMinesSearcher(String entryFile) {
        String[][] finalMap = null;

        try {
            BufferedReader in = new BufferedReader(new FileReader(entryFile));
            Integer rowsNumber = 0;
            Integer columnsNumber = 0;
            boolean isFirstTime = true;
            Integer lineCounter = 0;
            String line;
            String[] arraySize = null;
            while ((line = in.readLine()) != null) {

                if ("".equals(line))
                    throw new RuntimeException("El Archivo contiene lineas en blanco");

                if (isFirstTime) {
                    arraySize = line.split(" ");
                    rowsNumber = Integer.valueOf(arraySize[0]);
                    columnsNumber = Integer.valueOf(arraySize[1]);
                    finalMap = new String[rowsNumber][columnsNumber];
                    isFirstTime = false;
                    continue;
                }

                finalMap = fillMatrix(line, lineCounter, finalMap);

                lineCounter++;
            }

            in.close();

            finalMap = searchMines(rowsNumber, columnsNumber, finalMap);

        } catch (NumberFormatException e) {
            finalMap = new String[1][1];
            finalMap[0][0] = "Error: " + e.toString();
        } catch (Exception e) {
            finalMap = new String[1][1];
            finalMap[0][0] = "Error: " + e.toString();
        }

        return finalMap;
    }

    public String getPrintString(String[][] finalMap) {
        StringBuilder sb = new StringBuilder();
        String inLineValues = "";

        for (int i = 0; i < finalMap.length; i++) {
            for (int j = 0; j < finalMap[i].length; j++) {
                inLineValues += finalMap[i][j];
            }
            sb.append(inLineValues + " ");
            inLineValues = "";
        }
        return sb.toString();
    }
    
    private String[][] fillMatrix(String fileLine, Integer lineCounter, String[][] finalMap) {
        String[] columnsInLine = fileLine.split("");
        for (int i = 0; i < columnsInLine.length; i++) {
            if ("*".equals(columnsInLine[i]))
                finalMap[lineCounter][i] = columnsInLine[i];
            else if (".".equals(columnsInLine[i]))
                finalMap[lineCounter][i] = "0";
            else
                throw new RuntimeException("El Archivo contiene caracteres no válidos");

        }
        return finalMap;
    }

    private String[][] searchMines(Integer rowsNumber, Integer columnsNumber, String[][] finalMap) {
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if ("0".equals(finalMap[i][j])) {
                    finalMap = searchRightPosition(i, j, columnsNumber, finalMap);
                    finalMap = searchLeftPosition(i, j, columnsNumber, finalMap);

                    if ((i + 1) < rowsNumber) {
                        finalMap = addMineValue(i + 1, j, i, j, finalMap);

                        if ((j + 1) < columnsNumber) {
                            finalMap = addMineValue(i + 1, j + 1, i, j, finalMap);
                        }
                        if ((j - 1) > -1) {
                            finalMap = addMineValue(i + 1, j - 1, i, j, finalMap);
                        }

                    }

                    if ((i - 1) > -1) {
                        finalMap = addMineValue(i - 1, j, i, j, finalMap);

                        if ((j + 1) < columnsNumber) {
                            finalMap = addMineValue(i - 1, j + 1, i, j, finalMap);
                        }
                        if ((j - 1) > -1) {
                            finalMap = addMineValue(i - 1, j - 1, i, j, finalMap);
                        }
                    }
                }

            }
        }
        return finalMap;
    }

    private String[][] searchLeftPosition(Integer row, Integer column, Integer columnsNumber, String[][] finalMap) {
        if ((column - 1) > -1) {
            finalMap = addMineValue(row, column - 1, row, column, finalMap);
        }
        return finalMap;
    }

    private String[][] searchRightPosition(Integer row, Integer column, Integer columnsNumber, String[][] finalMap) {
        if ((column + 1) < columnsNumber) {
            finalMap = addMineValue(row, column + 1, row, column, finalMap);
        }
        return finalMap;
    }

    private String[][] addMineValue(Integer evaluatedRow, Integer evaluatedColumn, Integer actualRow, Integer actualColumn, String[][] finalMap) {
        if ("*".equals(finalMap[evaluatedRow][evaluatedColumn])) {
            finalMap[actualRow][actualColumn] = String.valueOf((Integer.valueOf(finalMap[actualRow][actualColumn]) + 1));
        }
        return finalMap;
    }

}
