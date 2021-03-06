package minessearchertest;

import org.junit.Assert;
import org.junit.Test;

import minessearcher.MinesSearcher;

public class MinesSearcherTest {

    MinesSearcher minesSearcher = new MinesSearcher();
    
    @Test
    public void testFileNotEmpty() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
    }
    
    @Test
    public void testFileContainsMatrixSize() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals(4, finalMap[0].length);
        Assert.assertEquals(4, finalMap[1].length);
        Assert.assertEquals(4, finalMap[2].length);
        Assert.assertEquals(4, finalMap[3].length);
    }
    
    
    @Test
    public void testFileContainsMines() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals("*", finalMap[0][0]);
    }
    
    @Test
    public void testConvertDotsToZero() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals("*", finalMap[0][0]);
    }
    
    @Test
    public void testAllQuadrantMine() {
        String entryFile = "D:\\prueba1.txt";
        String[][] finalMap = minesSearcher.processMinesSearcher(entryFile);
        Assert.assertNotEquals(null, finalMap);
        Assert.assertEquals("*", finalMap[0][0]);
        Assert.assertEquals("2", finalMap[0][1]);
        Assert.assertEquals("1", finalMap[0][2]);
        Assert.assertEquals("0", finalMap[0][3]);
        Assert.assertEquals("2", finalMap[1][0]);
        Assert.assertEquals("*", finalMap[1][1]);
        Assert.assertEquals("1", finalMap[1][2]);
        Assert.assertEquals("0", finalMap[1][3]);
        Assert.assertEquals("1", finalMap[2][0]);
        Assert.assertEquals("1", finalMap[2][1]);
        Assert.assertEquals("1", finalMap[2][2]);
        Assert.assertEquals("0", finalMap[2][3]);
        Assert.assertEquals("0", finalMap[3][0]);
        Assert.assertEquals("0", finalMap[3][1]);
        Assert.assertEquals("0", finalMap[3][2]);
        Assert.assertEquals("0", finalMap[3][3]);
    }
    
}
