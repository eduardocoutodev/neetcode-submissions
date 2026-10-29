class Solution {
    public class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean union (int i, int j){
            int parentI = find(i);
            int parentJ = find(j);

            if(parentI == parentJ){
                // same parent
                return false;
            }

            if(rank[parentI] >= rank[parentJ]){
                parent[parentJ]=parentI;
                rank[parentI] = rank[parentI] + 1;
            } else {
                parent[parentI]=parentJ;
                rank[parentJ]=rank[parentJ] + 1;
            }

            return true;
        }

    }


    public int countComponents(int n, int[][] edges) {
        int result = n;
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){

            if(uf.union(edge[0], edge[1])){
                result--;
            }
        }

        return result;
    }
}
