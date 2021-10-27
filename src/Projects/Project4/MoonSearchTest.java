package Projects.Project4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MoonSearchTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    String[] moonNames = {"Phobus","Deimos","Adrastea","Aitne","Amalthea","Ananke","Aoede","Arche"};
    double[] moonRadii = {11.3,6.2,68.9,33.6,71.2,26.8,255.9,47.4};
    double[] moonDensity = {1.8,1.4,14.2,33.3,16.4,68.1,121.3,38.2};
    double[] moonDistance = {3.7,23.4,550391.6,227894.9,778893.6,143323.5,287223.5,449655.1};

    String[] newMoonNames = {"Tethys","Enceladus","Mimas","Hyperion","Phoebe","Janus","Epimetheus","Prometheus"};
    double[] newMoonRadii = {6330.01,4589.59,8066.68,3566.37,6603.78,8234.77,4947.55,7263.94};
    double[] newMoonDensity = {1.6,7.5,4.4,9.6,3.9,9.5,5.1,5.4};
    double[] newMoonDistance = {60582.70,72583.18,25530.51,61319.31,43982.57,61139.03,34399.97,5920.41};



    @Test
    public void calcAvgGivenRadiiDataTest(){
        double actual = MoonSearch.calcAvg(moonRadii);
        double expected = 65.1625;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void calcAvgUnknownDataTest(){
        double actual = MoonSearch.calcAvg(newMoonRadii);
        double expected = 6200.3362;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void findHighValueGivenDistanceDataTest(){
        double actual = MoonSearch.findHighValue(moonDistance);
        double expected = 778893.6;
        assertEquals("When checking the result of findHighValue we",expected,actual,.001);
    }

    @Test
    public void findHighValueUnknownDataTest(){
        double actual = MoonSearch.findHighValue(newMoonDistance);
        double expected = 72583.18;
        assertEquals("When checking the result of findHighValue we",expected,actual,.001);
    }

    @Test
    public void findLeastValueGivenRadiiDataTest(){
        double actual = MoonSearch.findLeastValue(moonRadii);
        double expected = 6.2;
        assertEquals("When checking the result of findLeastValue we",expected,actual,.001);
    }

    @Test
    public void findLeastValueUnknownDataTest(){
        double actual = MoonSearch.findLeastValue(newMoonRadii);
        double expected = 3566.37;
        assertEquals("When checking the result of findLeastValue we",expected,actual,.001);
    }

    @Test
    public void findHighestTwoGivenDensityDataTest(){
        String[] actual = MoonSearch.findHighestTwo(moonNames,moonDensity);
        assertEquals("When checking the result of findHighestTwo we expected the first element of the resulting array to be","Aoede",actual[0]);
        assertEquals("When checking the result of findHighestTwo we expected the second element of the array to be", "Ananke",actual[1]);
    }

    @Test
    public void findHighestTwoUnknownDataTest(){
        String[] actual = MoonSearch.findHighestTwo(newMoonNames,newMoonDensity);
        assertEquals("When checking the result of findHighestTwo we expected the first element of the resulting array to be","Hyperion",actual[0]);
        assertEquals("When checking the result of findHighestTwo we expected the second element of the array to be", "Janus",actual[1]);
    }

    @Test
    public void findLowestTwoValuesGivenRadiiDataTest(){
        String[] actual = MoonSearch.findLowestTwo(moonNames,moonRadii);
        assertEquals("When checking the result of findLowestTwo we expected the first element of the resulting array to be","Deimos",actual[0]);
        assertEquals("When checking the result of findLowestTwo we expected the second element of the array to be", "Phobus",actual[1]);
    }

    @Test
    public void findLowestTwoValuesUnknownDataTest(){
        String[] actual = MoonSearch.findLowestTwo(newMoonNames,newMoonRadii);
        assertEquals("When checking the result of findLowestTwo we expected the first element of the resulting array to be","Hyperion",actual[0]);
        assertEquals("When checking the result of findLowestTwo we expected the second element of the array to be", "Enceladus",actual[1]);
    }

    @Test
    public void findMoonGivenDataTest(){
        boolean actual = MoonSearch.findMoon(moonNames,"Deimos");
        assertTrue("When checking the result of findMoon the given array contained \"Deimos\" and should return true",actual);

        actual = MoonSearch.findMoon(moonNames,"Moon X");
        assertFalse("When checking the result of findMoon the given array does not contain \"Moon X\" and should return false",actual);
    }

    @Test
    public void findMoonUnknownDataTest(){
        boolean actual = MoonSearch.findMoon(newMoonNames,"Phoebe");
        assertTrue("When checking the result of findMoon the given array contained \"Phoebe\" and should return true",actual);

        actual = MoonSearch.findMoon(newMoonNames,"Julien");
        assertFalse("When checking the result of findMoon the given array does not contain \"Julien\" and should return false",actual);
    }

    @Test
    public void mainMethodValidCity(){
        String input = "Deimos";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        MoonSearch.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average radius is: 65.2",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average density is: 36.8",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest radius is: 255.9",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The lowest distance is: 3.7",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The highest two moons for radii are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","Aoede",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","Amalthea",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","The lowest two moons for density are:",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","Deimos",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","Phobus",rawOutput[9].trim());
        assertEquals("When checking the eleventh line of output we","Enter a moon:",rawOutput[10].trim());

        assertEquals("When checking the twelfth line of output we","Deimos is a moon in the array.",rawOutput[11].trim());
    }

    @Test
    public void mainMethodInvalidCity(){
        String input = "Moon X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        MoonSearch.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average radius is: 65.2",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average density is: 36.8",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest radius is: 255.9",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The lowest distance is: 3.7",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The highest two moons for radii are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","Aoede",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","Amalthea",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","The lowest two moons for density are:",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","Deimos",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","Phobus",rawOutput[9].trim());
        assertEquals("When checking the eleventh line of output we","Enter a moon:",rawOutput[10].trim());

        assertEquals("When checking the twelfth line of output we","Moon X is not a moon in the array.",rawOutput[11].trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


}
