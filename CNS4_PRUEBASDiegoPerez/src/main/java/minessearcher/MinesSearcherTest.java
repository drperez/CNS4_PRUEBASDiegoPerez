package minessearcher;

import org.junit.Assert;
import org.junit.Test;

public class MinesSearcherTest {

    MinesSearcher minesSearcher = new MinesSearcher();
    
    @Test
    public void validateFileNotEmpty() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
    }
    
}
