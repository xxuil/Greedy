package lab2;

/**
 * Test for debug
 * Created by xiangxingliu on 2017/7/22.
 */
import java.util.Vector;

public class Test {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.exit(1);
        }


        String filename = args[0];

        Program2 network = new Program2(filename);
        System.out.println("---------------------------");
        System.out.println("Results for the input graph");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println("Transmission Range = " + 1 + " meters.");
        System.out.println("");
        network.setTransmissionRange(1);
        network.gpsrAllPairs(true);
    }

}

