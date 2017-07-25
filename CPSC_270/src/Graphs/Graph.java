package Graphs;

/**
 * @author Raymond Sutton
 * @version ...
 */
public class Graph implements GraphADT {
    private int[][] matrix;
    private Object[] nodeValues;
    private int numEdge;

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#init(int)
     */
    @Override
    public void init(int n) {
        matrix = new int[n][n];
        nodeValues = new Object[n];
        numEdge = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#nodeCount()
     */
    @Override
    public int nodeCount() {
        return nodeValues.length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#edgeCount()
     */
    @Override
    public int edgeCount() {
        return numEdge;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#getValue(int)
     */
    @Override
    public Object getValue(int v) {
        return nodeValues[v];
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#setValue(int, java.lang.Object)
     */
    @Override
    public void setValue(int v, Object val) {
        nodeValues[v] = val;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#addEdge(int, int, int)
     */
    @Override
    public void addEdge(int v, int w, int wgt) {
        if (wgt == 0)
            return; // Can't store weight of 0
        matrix[v][w] = wgt;
        numEdge++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#weight(int, int)
     */
    @Override
    public int weight(int v, int w) {
        return matrix[v][w];
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#removeEdge(int, int)
     */
    @Override
    public void removeEdge(int v, int w) {
        matrix[v][w] = 0;
        numEdge--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#hasEdge(int, int)
     */
    @Override
    public boolean hasEdge(int v, int w) {
        return matrix[v][w] != 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Graphs.GraphADT#neighbors(int)
     */
    @Override
    public int[] neighbors(int v) {
        int i;
        int count = 0;
        int[] temp;

        for (i = 0; i < nodeValues.length; i++)
            if (matrix[v][i] != 0)
                count++;
        temp = new int[count];
        for (i = 0, count = 0; i < nodeValues.length; i++)
            if (matrix[v][i] != 0)
                temp[count++] = i;
        return temp;
    }
}
