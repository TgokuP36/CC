import java.io.*;
import java.util.*;

// Class DelivB does the work for deliverable DelivB of the Prog340

public class DelivB {

    File inputFile;
    File outputFile;
    PrintWriter output;
    Graph g;

    public DelivB(File in, Graph gr) {
        inputFile = in;
        g = gr;

        // Get output file name.
        String inputFileName = inputFile.toString();
        String baseFileName = inputFileName.substring(0, inputFileName.length() - 4); // Strip off ".txt"
        String outputFileName = baseFileName.concat("_out.txt");
        outputFile = new File(outputFileName);
        if (outputFile.exists()) {    // For retests
            outputFile.delete();
        }

        try {
            output = new PrintWriter(outputFile);
        } catch (Exception x) {
            System.err.format("Exception: %s%n", x);
            System.exit(0);
        }
        System.out.println("Change  coins ");
        System.out.println(counter()+" \n"+amount_of_coins_DP());
        output.println("Change  coins ");
        output.println(counter()+" \n"+amount_of_coins_DP());
        output.flush();
    }
    public String amount_of_coins_DP() {
        int memory[] = new int[61 + 1];
        List<Integer> x = g.list_of_coins();
        List<Integer> coins = x;// this creates the new list with the values of the coins
        int amount_of_coins = coins.size();
        int Amount = 61;

        for (int i = x.size() - 1; i >= 0; i--)
            memory[0] = 0;
        for (int i = 1; i <= Amount; i++)
            memory[i] = Amount + 1; // this the storing the values of the amount of coins
        for (int i = 1; i <= Amount; i++) {
            for (int j = 0; j < amount_of_coins; j++)
                if (coins.get(j) <= i) {
                    int sub_res = memory[i - coins.get(j)];
                    if (sub_res != Amount + 1 && sub_res + 1 < memory[i])//This Dynamic Programing is representing Bottom-Up
                        memory[i] = sub_res + 1;
                }
        }
        List change = new ArrayList();
        for (int i = 1; i <= Amount; i++) {
            change.add(memory[i]);//Creates a new list to be able to return
        }
        return change.toString();
    }
    public Object counter() {
        List count = new ArrayList();// keeps track of the amount of change need to be exchanged
        for (int i = 1; i <= 61; i++)
            count.add(i);
        return count.toString();
    }

}
