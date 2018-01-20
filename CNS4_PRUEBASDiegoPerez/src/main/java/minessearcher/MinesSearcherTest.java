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
    
    @Test
    public void validateFileContainsMatrixSize() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals(4, finalMap[0].length);
        Assert.assertEquals(4, finalMap[1].length);
        Assert.assertEquals(4, finalMap[2].length);
        Assert.assertEquals(4, finalMap[3].length);
    }
    
    
    @Test
    public void validateFileContainsMines() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals("*", finalMap[0][0]);
    }
    
}
