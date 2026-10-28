class Solution {
    public class UnionFind {
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public UnionFind(int n){
            rank = new HashMap<>();
            parent = new HashMap<>();

            for(int i = 1; i <= n; i++){
                rank.put(i, 1);
                parent.put(i, i);
            }
        }

        public int find(int i){
            if(parent.get(i) != i){
                parent.put(i, find(parent.get(i)));
            }

            return parent.get(i);
        }

        public boolean union(int i, int j){
            int parentI = find(i);
            int parentJ = find(j);

            if(parentI == parentJ){
                return false;
            }

            if(rank.get(parentI) > rank.get(parentJ)){
                parent.put(parentJ, parentI);
            }else if (rank.get(parentJ) > rank.get(parentI)){
                parent.put(parentI, parentJ);
            }else {
                parent.put(parentJ,parentI);
                rank.put(parentI, rank.get(parentI) + 1);
            }

            return true;
        }

    }


    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for(int [] edge: edges){
            if(!unionFind.union(edge[0], edge[1])){
                return edge;
            }
        }
        
        return new int[]{};
    }
}
