package percolation;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
     private boolean[][] grid; // grid[i][j] == 0 for blocked, 1 for open
     
     private boolean [] sites;

     private WeightedQuickUnionUF uf; // for percolates()
     
     private WeightedQuickUnionUF ufBack; // for isFull()

     private int openSites;

     private int size;
     private int N;
    
    public Percolation(int n){
        if(n<0)
            throw new java.lang.IllegalArgumentException();
        grid = new boolean[n][n];
        sites = new boolean[n*n+2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=false;
        }
        N=n;
        int NSq = n*n;
        size= NSq+2;
        uf = new WeightedQuickUnionUF(size);
        ufBack = new WeightedQuickUnionUF(NSq+1);

        for (int i = 1; i <= N; ++i) {
            uf.union(0, i);
            uf.union(size-1, NSq+1-i);
            ufBack.union(0, i);
        }   
        openSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        validateArgs(row,col);
        grid[row-1][col-1] = true;
        openSites++;
        int idx = posToIndex(row, col);
        
        if(row>1 && isOpen(row-1, col)){
            uf.union(posToIndex(row-1, col), idx);
            ufBack.union(posToIndex(row-1, col), idx);
        }

        if(row<N && isOpen(row+1, col)){
            uf.union(posToIndex(row+1, col), idx);
            ufBack.union(posToIndex(row+1, col), idx);
        }

        if(col > 1 && isOpen(row, col-1)){
            uf.union(posToIndex(row, col-1), idx);
            ufBack.union(posToIndex(row, col-1), idx);
        }
        
        if(col <N && isOpen(row, col+1)){
            uf.union(posToIndex(row, col+1), idx);
            ufBack.union(posToIndex(row, col+1), idx);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        validateArgs(row,col);
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        validateArgs(row,col);
        return isOpen(row,col) && ufBack.connected(posToIndex(row,col), 0);
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return openSites;

    }

    // does the system percolate?
    public boolean percolates(){
        if (N == 1) 
        return isOpen(1,1); // corner case N = 1
    return uf.connected(0, size-1);
    }

    // test client (optional)
    public static void main(String[] args){

    }


    private void validateArgs(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N)
            throw new java.lang.IllegalArgumentException();
    }
    
    private int posToIndex(int row,int col)
    {
        return (row-1)*N+col;
    }
}
