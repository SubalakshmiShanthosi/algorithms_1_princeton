package unionfind;

public class WeightedQuickUnion{

    int[] id; 
    int[] size;

    WeightedQuickUnion(int N)
    {
        id=new int[N];
        size = new int[N];

        for(int i=0;i<id.length;i++)
            id[i]=i;
    }

    public int root(int p)
    {
        while(p!=id[p])
        {
            p=id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p,int q)
    {
        int i= root(p);
        int j = root(q);
        if(i == j)
            return;
        if(size[i]<size[j])
        {
            size[i]+=size[j];
            id[i] = j;
        }
        else
        {
            id[j]=i;
            size[j]+=size[i];
        }
    }
}