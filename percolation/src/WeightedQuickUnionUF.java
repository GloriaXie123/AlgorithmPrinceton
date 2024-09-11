public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N){
        for(int i =0; i < N;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int i){
        while(id[i] != i){
            //with path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootp = root(p);
        int rootq = root(q);
        if(sz[p] <= sz[q]) {
            id[rootp] = rootq;
            sz[q] += sz[p];
        }else{
            id[rootq] = rootp;
            sz[p] += sz[q];
        }
    }

}
