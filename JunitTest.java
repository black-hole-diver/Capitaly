import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.io.IOException;
import java.io.FileNotFoundException;

// import static org.junit.Assert;
import src.*;

public class JunitTest{
    public static final double EPSILON = 0.000001;

    /**
     * @throws IOException
     * Case1: Test for big field
     */
    @Test
    public void testResultBig() throws IOException, OutOfDiceException{
        Program pbig = new Program("sample/sample3_big.txt");
        String demo = "Type: Greedy Player Player name: Geralt_Of_Rivia Current position: 16 Balance: 14900 Owned fields: 3 Property 10 Kaer_Mohen House BuiltProperty 16 Nilfgardian_Palace House BuiltProperty 1 Whoreson_Junior's_mansion House Built";
        assertEquals(demo, pbig.progToString());
    }

    /**
     * @throws IllegalArgumentException
     * @throws IOException
     * Case2: Test for no field
     */
    @Test(expected = IllegalArgumentException.class)
    public void testResultSample1_no_field() throws IllegalArgumentException, IOException, OutOfDiceException
    {
        Program pSamp1 = new Program("sample/sample1_no_field.txt");
        pSamp1.progToString();
        
    }

    /**
     * @throws IllegalArgumentException
     * @throws IOException
     * Case3: Test for no player
     */
    @Test(expected = IllegalArgumentException.class)
    public void testResultSample2_no_player() throws IllegalArgumentException, IOException, OutOfDiceException
    {
        Program pSamp2 = new Program("sample/sample2_no_player.txt");
        pSamp2.progToString();
        
    }

    /**
     * @throws IOException
     * Case4: Test for no file
     */
    @Test(expected = FileNotFoundException.class)
    public void testResultNoFile() throws IOException, OutOfDiceException{
        Program no = new Program("sample/NoFile.txt");
        no.progToString();
    }

    /**
     * @throws IOException
     * @throws OutOfDiceException
     * Case5: Test for big file 2
     */
    @Test
    public void testResultBig2() throws IOException, OutOfDiceException{
        Program pSamp4 = new Program("sample/sample4_big2.txt");
        assertEquals("Type: Tactical Player Player name: Yennefer_Of_Vangerburg Current position: 5 Balance: 14100 Owned fields: 1 Property 7 Vegelbud_Residence House Built", pSamp4.progToString());
    }


    /**
     * @throws IOException
     * @throws OutOfDiceException
     * Case6: Test for file with only tactical players
     */
    @Test
    public void testResultTactical() throws IOException, OutOfDiceException, FileNotFoundException{
        Program pT = new Program("sample/sample5_only_tactical.txt");
        assertEquals("Type: Tactical Player Player name: Princess_Cirilla Current position: 7 Balance: 2000 Owned fields: 3 Property 3 Vegelbud_Residence House BuiltProperty 7 Touissant_Troll_House House NOT builtProperty 9 Empty_Brothel House NOT built", pT.progToString());
    }

    /**
     * @throws IOException
     * @throws OutOfDiceException
     * @throws FileNotFoundException
     * Case7: Test for file with only property fields
     */
    @Test
    public void testResultOnlyProperty() throws IOException, OutOfDiceException, FileNotFoundException{
        Program pH = new Program("sample/sample6_only_property.txt");
        String h = "Type: Tactical Player Player name: Geralt_Of_Rivia Current position: 4 Balance: 3000 Owned fields: 5 Property 3 Vegelbud_Residence House BuiltProperty 8 Haunted_Rat_Towers House NOT builtProperty 9 Rich_People_Houses House NOT builtProperty 2 Seven_Cats_Inn House BuiltProperty 6 Kovir_Mansion House NOT built";
        assertEquals(h, pH.progToString());
    }

    /**
     * @throws IOException
     * @throws OutOfDiceException
     * @throws FileNotFoundException
     * Case8: Test for file with one player
     */
    @Test
    public void testResultOnePlayer() throws IOException, OutOfDiceException, FileNotFoundException{
        Program p1 = new Program("sample/sample7_one_player.txt");
        String h = "Type: Greedy Player Player name: Geralt_Of_Rivia Current position: 1 Balance: 10000 No property";
        assertEquals(h, p1.progToString());
    }

    /**
     * @throws IOException
     * @throws OutOfDiceException
     * @throws FileNotFoundException
     * Case9: Test for file with not enough dice to determine the winner
     */
    @Test(expected = OutOfDiceException.class)
    public void testResultOutOfDice() throws IOException, OutOfDiceException, FileNotFoundException{
        Program no = new Program("sample/sample8_not_enough_dice.txt");
        no.progToString();
    }
}
