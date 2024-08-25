package Disjoint_Set_Union;
/*
 * DSU has 2 operations 
 * 1)Combine sets(UNION)
 * 2)Tell whether 2 elements are in the same set or not(FIND)
 * 
 */

import java.util.ArrayList;

public class DSU {
    
    //consider index and list contains parent of index
    ArrayList<Integer> parents;
    ArrayList<Integer> ranks;
    public DSU(int n){
        parents=new ArrayList<>();
        ranks=new ArrayList<>();
        for(int i=0;i<n;i++){
            parents.add(i);
            ranks.add(1);
        }
    }

    public int find(int el){
        if(el==parents.get(el)) 
            return el;
        //without path compression     
        // return find(parents.get(el));
        
        //with path-compression
        return parents.set(el,find(parents.get(el)));

    }
    public void union(int x,int y){
        int x_parent=find(x);
        int y_parent=find(y);
        //without Ranks
        // if(x_parent!=y_parent){
        //     parents.set(parents.get(x_parent),y_parent);
        // }

        //With Ranks
        if(x_parent==y_parent) return;
        else{
            if(ranks.get(x_parent)>ranks.get(y_parent)){
                parents.set(parents.get(y_parent),x_parent);
            }
            else if(ranks.get(y_parent)>ranks.get(x_parent)){
                parents.set(parents.get(x_parent),y_parent);
            }
            else{
                parents.set(parents.get(y_parent),x_parent);
                ranks.set(ranks.get(x_parent),ranks.get(x_parent)+1);
            }
        }
    }
}
