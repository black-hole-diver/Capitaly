import java.io.IOException;
import src.*;

public class Main
{
    public static void main(String[] args) throws NumberFormatException, IOException, OutOfDiceException{
        Program p = new Program("sample/sample4_big2.txt");
        System.out.print(p.progToString());
    }
}