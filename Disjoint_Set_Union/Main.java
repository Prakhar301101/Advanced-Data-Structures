package Disjoint_Set_Union;

public class Main {
    public static void main(String[] args) {
        DSU ds=new DSU(10);
        if(ds.find(0)==ds.find(1)){
            System.out.println("They are in same set");
        }
        else{
            System.out.println("Not in same component");
        }
        ds.union(0, 1);
        if(ds.find(0)==ds.find(1)){
            System.out.println("They are in same set");
        }
        else{
            System.out.println("Not in same component");
        }

    }
}
