package CH4;

import java.io.IOException;
import java.util.*;

public class Digraph<V> {

    public static class Edge<V>
    {
        private V vertex;
        private int cost;

        public Edge(V v, int c)
        {
            vertex = v;
            cost = c;
        }

        public V getVertex() {
            return vertex;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "Edge [vertex=" + vertex + ", cost=" + cost + "]";
        }

    }

    /**
     * A Map is used to map each vertex to its list of adjacent vertices.
     */

    private Map<V, List<Edge<V>>> neighbors = new HashMap<V, List<Edge<V>>>();

    private int nr_edges;

    /**
     * String representation of graph.
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (V v : neighbors.keySet())
            s.append("\n    " + v + " -> " + neighbors.get(v));
        return s.toString();
    }

    /**
     * Add a vertex to the graph. Nothing happens if vertex is already in graph.
     */
    public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<Edge<V>>());
    }

    public int getNumberOfEdges(){
        int sum = 0;
        for(List<Edge<V>> outBounds : neighbors.values())
        {
            sum += outBounds.size();
        }
        return sum;
    }

    /**
     * True iff graph contains vertex.
     */
    public boolean contains(V vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Add an edge to the graph; if either vertex does not exist, it's added.
     * This implementation allows the creation of multi-edges and self-loops.
     */
    public void add(V from, V to, int cost)
    {
        this.add(from);
        this.add(to);
        neighbors.get(from).add(new Edge<V>(to, cost));
    }

    //how many arrows point to vertex
    public int outDegree(int vertex)
    {
        //return the edges arraylist size for a specific vertex
        return neighbors.get(vertex).size();
    }

    //how many arrows point from vertex to another
    public int inDegree(V vertex)
    {
        //return size of a list with each inbound neighbor
        return inboundNeighbors(vertex).size();
    }


    public List<V> outboundNeighbors(V vertex)
    {
        //creating a new array list
        List<V> list = new ArrayList<V>();

        //loop through the given vertex edge & add each edge's vertex to the list
        for(Edge<V> e: neighbors.get(vertex))
            list.add(e.vertex);
        return list;
    }


    //getting all the vertex that have inbound vertex in its edge
    public List<V> inboundNeighbors(V inboundVertex)
    {
        //creating a new array list
        List<V> inList = new ArrayList<V>();
        //loop through the vertex
        for (V to : neighbors.keySet())
        {
            //loop through each vertex edge
            for (Edge e : neighbors.get(to))
                //if the vertex you are looking for is in the egde add it to the list
                if (e.vertex.equals(inboundVertex))
                    inList.add(to);
        }
        //send list
        return inList;
    }

    //finding if there's an edge between two vector
    public boolean isEdge(V from, V to)
    {
        //loop through the list of edges in vertex from
        for(Edge<V> e :  neighbors.get(from))
        {
            //if you find a vertex that's equal to vertex to, return true
            if(e.vertex.equals(to))
                return true;
        }
        return false;
    }


    public int getCost(V from, V to)
    {
        //loop through the list of edges in vertex from
        for(Edge<V> e :  neighbors.get(from))
        {
            //if you find a vertex that's equal to vertex to, get the cost
            if(e.vertex.equals(to))
                return e.cost;
        }
        //if not return a negative number
        return -1;
    }


    //breadth-first search, visit all your neighbors before your neighbor's neighbors
    public void bfs (V start)
    {
        //BFS uses Queue, to keep track of nodes to visit,
        // nodes are visited based FIFO order
        Queue q = new LinkedList();

        Boolean [] visited=new Boolean[10];


        //put your first node on the queue
        q.add(start);

        // mark it as visited
        //visited[(int)start]=true;

        while (!q.isEmpty())
        {
            V vertexVisited;
            int n= (int) q.peek();
            //h = remove the first node from queue Q
            q.remove(n);


            //Put all of h's unvisited neighbor nodes in a queue Q
           // for (V v :inboundNeighbors(vertexVisited))
            ///{
                //Mark all inserted nodes as visited

//            }




        }


    }

    //depth-first search
    public void dfs (V from, V to)
    {


        //after you hit a vertex's edge go to the next vertex

    }

    //Ch 4.1 is route
    public  Boolean isRoute (V from, V to)
    {
        Boolean isRoute=false;


        //for every vertex's edge you want to hit every edge
        return isRoute;
    }

    enum State { Unvisited, Visited, Visiting;}

    //public boolean search (Digraph g, Edge start, Edge end)
    //{
      //  if (start == end)
        //    return true;
        //operates as Queue
        LinkedList<Edge> q = new LinkedList<Edge>();

        //for (Edge u : g.getNodes())
        //{
          //  u.state = State.Unvisited;
        //}
        //start.state = State.Visiting;
        //q.add(start);
        //Edge u;
        //while (!q.isEmpty())
        //{
          //  u = q.removeFirst(); //i.e., dequeue()
            //if (u != null)
            //{
              //  for (Edge v : u.getAdjacent()) {
            //}

        //}

   // }





    public static void main(String[] args) throws IOException {

        Digraph<Integer> graph = new Digraph<Integer>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);

        graph.add(0, 1, 1);
        graph.add(1, 2, 2);
        graph.add(2, 3, 2);
        graph.add(3, 0, 2);
        graph.add(1, 3, 1);
        graph.add(2, 1, 5);


        System.out.println("The nr. of vertices is: " + graph.neighbors.keySet().size());
        System.out.println("The nr. of edges is: " + graph.getNumberOfEdges()); // to be fixed
        System.out.println("The current graph: " + graph);
        System.out.println("In-degrees for 0: " + graph.inDegree(0));
        System.out.println("Out-degrees for 0: " + graph.outDegree(0));
        System.out.println("In-degrees for 1: " + graph.inDegree(1));
        System.out.println("Out-degrees for 1: " + graph.outDegree(1));
        System.out.println("In-degrees for 2: " + graph.inDegree(2));
        System.out.println("Out-degrees for 2: " + graph.outDegree(2));
        System.out.println("In-degrees for 3: " + graph.inDegree(3));
        System.out.println("Out-degrees for 3: " + graph.outDegree(3));
        System.out.println("Outbounds for 1: "+ graph.outboundNeighbors(1));
        System.out.println("Inbounds for 1: "+ graph.inboundNeighbors(1));
        System.out.println("(0,2)? " + (graph.isEdge(0, 2) ? "It's an edge" : "It's not an edge"));
        System.out.println("(1,3)? " + (graph.isEdge(1, 3) ? "It's an edge" : "It's not an edge"));
        System.out.println("Cost for (1,3)? "+ graph.getCost(1, 3));





    }
}