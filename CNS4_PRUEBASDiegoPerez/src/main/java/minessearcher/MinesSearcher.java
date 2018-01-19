package minessearcher;

import java.io.BufferedReader;
import java.io.FileReader;

public class MinesSearcher {

    public String[][] processMinesSearcher(String entryFile) {
        String[][] finalMap = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(entryFile));
            String line;
            while((line = in.readLine()) != null)
            {
                finalMap = new String[1][1];
            }
            in.close();
            return finalMap;
        } catch (Exception e) {
            return finalMap;
        }
    }

}
