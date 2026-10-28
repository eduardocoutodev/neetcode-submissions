class Solution {
    public class UnionFind {
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public UnionFind(int n){
            parent = new HashMap<>();
            rank = new HashMap<>();

            for(int i = 0; i < n; i++){
                parent.put(i, i);
                rank.put(i, 0);
            }
        }

        public int find(int i){
            if(parent.get(i) != i){
                parent.put(i, find(parent.get(i)));
            }
            return parent.get(i);
        }

        public boolean union (int i, int j){
            int parentI = find(i);
            int parentJ = find(j);

            if(parentI == parentJ){
                // same parent
                return false;
            }

            if(rank.get(parentI) > rank.get(parentJ)){
                parent.put(parentJ, parentI);
            } else if(rank.get(parentJ) > rank.get(parentI)){
                parent.put(parentI, parentJ);
            } else {
                rank.put(parentI, rank.get(parentI) + 1);
                parent.put(parentJ, parentI);
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
