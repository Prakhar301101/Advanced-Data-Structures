package Disjoint_Set_Union;
/*
 * DSU has 2 operations 
 * 1)Combine sets(UNION)
 * 2)Tell whether 2 elements are in the same set or not(FIND)
 * 
 */

import java.util.ArrayList;

public class DSU {

    // consider index and list contains parent of index
    ArrayList<Integer> parents;
    ArrayList<Integer> ranks;

    public DSU(int n) {
        parents = new ArrayList<>();
        ranks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parents.add(i);
            ranks.add(1);
        }
    }

    public int find(int el) {
        if (el == parents.get(el))
            return el;
        // without path compression
        // return find(parents.get(el));

        // with path-compression
        int parent = find(parents.get(el));
        parents.set(el, parent); // Path compression
        return parent;

    }

    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        // without Ranks
        // if(x_parent!=y_parent){
        // parents.set(parents.get(x_parent),y_parent);
        // }

        // With Ranks

        if (x_parent == y_parent)
            return;

        if (ranks.get(x_parent) > ranks.get(y_parent)) {
            parents.set(y_parent, x_parent); // y's root points to x's root
        } else if (ranks.get(y_parent) > ranks.get(x_parent)) {
            parents.set(x_parent, y_parent); // x's root points to y's root
        } else {
            parents.set(y_parent, x_parent); // Either one can be chosen as the root
            ranks.set(x_parent, ranks.get(x_parent) + 1); // Increase rank of new root
        }

    }
}
