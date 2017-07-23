/*
 * Name: Xiangxing Liu
 * EID: xl5587
 */

package lab2;


import java.util.*;

/* Your solution goes in this file.
 *
 * Please do not modify the other files we have provided for you, as we will use
 * our own versions of those files when grading your project. You are
 * responsible for ensuring that your solution works with the original version
 * of all the other files we have provided for you.
 * 
 * That said, please feel free to add additional files and classes to your
 * solution, as you see fit. We will use ALL of your additional files when
 * grading your solution.
 */

public class Program2 extends VertexNetwork {
    /* DO NOT FORGET to add a graph representation and 
       any other fields and/or methods that you think 
       will be useful. 
       DO NOT FORGET to modify the constructors when you 
       add new fields to the Program2 class. */

    private HashMap<Vertex, HashMap<Vertex, Edge>> Graph;
    
    Program2() {
        super();
        buildMap();
    }
    
    Program2(String locationFile) {
        super(locationFile);
        buildMap();
    }
    
    Program2(String locationFile, double transmissionRange) {
        super(locationFile, transmissionRange);
        buildMap();

    }
    
    Program2(double transmissionRange, String locationFile) {
        super(transmissionRange, locationFile);
        buildMap();
    }

    private void buildMap(){
        Graph = new HashMap<Vertex, HashMap<Vertex, Edge>>();

        for(Vertex vertex : location){
            Graph.put(vertex, new HashMap<Vertex, Edge>());
        }

        for(Edge edge : edges){
            Vertex u = location.get(edge.getU());
            Vertex v = location.get(edge.getV());

            if(u.distance(v) <= transmissionRange){
                Graph.get(u).put(v, edge);
                Graph.get(v).put(u, edge);
            }
        }
    }

    public Vector<Vertex> gpsrPath(int sourceIndex, int sinkIndex) {
        /* This method returns a path from a source at location sourceIndex 
           and a sink at location sinkIndex using the GPSR algorithm. An empty 
           path is returned if the GPSR algorithm fails to find a path. */
        /* The following code is meant to be a placeholder that simply 
           returns an empty path. Replace it with your own code that 
           implements the GPSR algorithm. */

        Vertex source = location.get(sourceIndex);
        Vertex sink = location.get(sinkIndex);
        Vector<Vertex> trackPath = new Vector<>();
        trackPath.add(source);

        if(gprsHelper(source, sink, trackPath))
            return trackPath;

        return new Vector<Vertex>(0);
    }

    private boolean gprsHelper(Vertex source, Vertex dest, Vector<Vertex> trace){
        double dis = source.distance(dest);

        //if sink is in range
        if(dis <= this.transmissionRange){
            trace.add(dest);
            return true;
        }

        //if not in direct range, get the closest vertex to the sink
        Vertex next = findNext(source, dest);
        if(next != null){
            trace.add(next);
            if(gprsHelper(next, dest, trace))
                return true;
        }
        return false;
    }

    private HashMap<Vertex, Edge> getMap(Vertex source) {
        return Graph.get(source);
    }

    private Vertex findNext(Vertex source, Vertex dest){
        HashMap<Vertex, Edge> nextMap = Graph.get(source);
        double dis = source.distance(dest);
        Vertex nextVertex = null;

        for(Vertex next : nextMap.keySet()){
            double nextDis = next.distance(dest);

            if(nextDis < dis){
                dis = nextDis;
                nextVertex = next;
            }
        }

        return nextVertex;
    }
    
    public Vector<Vertex> dijkstraPathLatency(int sourceIndex, int sinkIndex) {
        /* This method returns a path (shortest in terms of latency) from a source at
           location sourceIndex and a sink at location sinkIndex using Dijkstra's algorithm.
           An empty path is returned if Dijkstra's algorithm fails to find a path. */
        /* The following code is meant to be a placeholder that simply 
           returns an empty path. Replace it with your own code that 
           implements Dijkstra's algorithm. */
        return new Vector<Vertex>(0);
    }
    
    public Vector<Vertex> dijkstraPathHops(int sourceIndex, int sinkIndex) {
        /* This method returns a path (shortest in terms of hops) from a source at
           location sourceIndex and a sink at location sinkIndex using Dijkstra's algorithm.
           An empty path is returned if Dijkstra's algorithm fails to find a path. */
        /* The following code is meant to be a placeholder that simply 
           returns an empty path. Replace it with your own code that 
           implements Dijkstra's algorithm. */
        return new Vector<Vertex>(0);
    }
    
}

