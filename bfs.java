import java.util.*;

class Graph{

    private int vertices;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        vertices=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
       {
        adj[i]=new LinkedList<Integer>();
       } 
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bfs(int start)
    {
        boolean visited[]=new boolean[vertices];
        Queue<Integer> queue =new LinkedList<Integer>();

        visited[start]=true;

        queue.add(start);
        System.out.println("bfs traversal");
          

        while(!queue.isEmpty())
        {
          int node=queue.poll();

          System.out.println(node+" ");

          for(int neighbour:adj[node])
          {
              if(!visited[neighbour])
              {
                visited[neighbour]=true;
                queue.add(neighbour);
              }
          }




        }




    }

void  dfs(int start)
{
  boolean visited[]=new boolean[vertices];
  System.out.println("DFS traversal");

  dfsr(start,visited);
}
void dfsr(int node,boolean visited[])
{
    visited[node]=true;

    System.err.print(node+ " ");

    for(int neighbour:adj[node])
    {
        if(!visited[neighbour])
        {
            dfsr(neighbour, visited);
        }
    }
}














}


public class bfs {
    
public static void main(String[] args) {
    Graph g=new Graph(5);
    g.addEdge(0, 1);
    g.addEdge(1, 4);
     g.addEdge(0, 2);
    g.addEdge(2, 3);
    
       g.bfs(0);

       g.dfs(0);
}
}
