package lab2;

/**
 * Test for debug
 * Created by xiangxingliu on 2017/7/22.
 */
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        //GPSR1
        stage1("100.in", 5.0);
        //stage1("test_in2", 1.1);
    }

    public static void stage1(String filename, double range){

        Program2 network = new Program2(filename);
        System.out.println("---------------------------");
        System.out.println("Results for the input graph");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println("Transmission Range = " + range + " meters.");
        System.out.println("");
        network.setTransmissionRange(range);
        network.gpsrAllPairs(true);
    }

}

