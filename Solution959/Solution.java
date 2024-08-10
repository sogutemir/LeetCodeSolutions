public class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * n * 4;
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j);
                char val = grid[i].charAt(j);

                if (val == '/') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                } else if (val == '\\') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                } else {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 1, root + 2);
                    uf.union(root + 2, root + 3);
                }

                if (j + 1 < n) {
                    uf.union(root + 1, 4 * (i * n + j + 1) + 3);
                }

                if (i + 1 < n) {
                    uf.union(root + 2, 4 * ((i + 1) * n + j) + 0);
                }
            }
        }

        int regions = 0;
        for (int i = 0; i < size; i++) {
            if (uf.find(i) == i) {
                regions++;
            }
        }

        return regions;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] grid1 = {" /", "/ "};
        System.out.println(sol.regionsBySlashes(grid1));

        String[] grid2 = {" /", "  "};
        System.out.println(sol.regionsBySlashes(grid2));

        String[] grid3 = {"/\\", "\\/"};
        System.out.println(sol.regionsBySlashes(grid3));
    }
}
