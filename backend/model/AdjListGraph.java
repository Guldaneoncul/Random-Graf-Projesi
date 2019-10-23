
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjListGraph { private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private boolean[][] adj;

    
    public AdjListGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("köşe işin fazla değer");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    
    public AdjListGraph(int V, int E) {
        this(V);
        if (E > (long) V*(V-1)/2 + V) throw new IllegalArgumentException("çok fazla bir değer kenar için");
        if (E < 0)                    throw new IllegalArgumentException("çok fazla bir değer kenar için");

        
        while (this.E != E) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            addEdge(v, w);
        }
    }

    
    public int V() { return V; }
    public int E() { return E; }


   
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    
    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }


    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println("node sayısı? ");
        Scanner scanner = new Scanner(System.in);
        String node= scanner.nextLine();
        System.out.println("komşuluk sayısı ");
        Scanner scanners = new Scanner(System.in);
        String komsu= scanners.nextLine();
        int V = Integer.parseInt(node);
        int E = Integer.parseInt(komsu);
        AdjListGraph G = new AdjListGraph(V, E);
        System.out.println(G);
    }

}

