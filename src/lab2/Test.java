package lab2;

/**
 * Test for debug
 * Created by xiangxingliu on 2017/7/22.
 */
import java.util.Vector;

public class Test {

    public static void main(String[] args) {

        double range = 10.0;
        String file = "80.in";
        boolean mode = false;

        //GPSR1
        stage1(file, range, mode);

        //Dijkstra 1
        stage2(file, range, mode);

        //Dijkstra 2
        stage3(file, range, mode);
    }

    public static void stage1(String filename, double range, boolean mode){

        Program2 network = new Program2(filename);
        System.out.println("---------------------------");
        System.out.println("Results for the input graph");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println("Transmission Range = " + range + " meters.");
        System.out.println("");
        network.setTransmissionRange(range);
        network.gpsrAllPairs(mode);
    }

    public static void stage2(String filename, double range, boolean mode){

        Program2 network = new Program2(filename);
        System.out.println("---------------------------");
        System.out.println("Results for the input graph");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println("Transmission Range = " + range + " meters.");
        System.out.println("");
        network.setTransmissionRange(range);
        network.dijkstraLatencyAllPairs(mode);

    }

    public static void stage3(String filename, double range, boolean mode){

        Program2 network = new Program2(filename);
        System.out.println("---------------------------");
        System.out.println("Results for the input graph");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println("Transmission Range = " + range + " meters.");
        System.out.println("");
        network.setTransmissionRange(range);
        network.dijkstraHopsAllPairs(mode);
    }

}

