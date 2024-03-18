import java.io.*;
import java.util.ArrayList;
import java.util.List;



// Class DelivA does the work for deliverable DelivA of the Prog340

public class DelivA {

    File inputFile;
    File outputFile;
    PrintWriter output;
    Graph g;

    public DelivA( File in, Graph gr ) {
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
        System.out.println("There are " + g.getNodeList().size() + " nodes on the graph.");
        System.out.println("There are " + g.getEdgeList().size() + " edges on the graph.");
        System.out.println("Nodes " + g.ME() + " have the most outgoing edges " + g.ME2());
        System.out.println("The longest edge is " + g.LE());
        output.println("There are " + g.getNodeList().size() + " nodes on the graph.");
        output.println("There are " + g.getEdgeList().size() + " edges on the graph.");
        output.println("Nodes " + g.ME() + " have the most outgoing edges " + g.ME2());
        output.println("The longest edge is " + g.LE());
        output.flush();
    }
}


