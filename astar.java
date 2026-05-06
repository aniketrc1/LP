import java.util.*;

class Node
{
    int vertex;
    int cost;

    Node(int v, int c)
    {
        vertex = v;
        cost = c;
    }
}

class AStar
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int graph[][] = {
            {0, 1, 4, 0},
            {1, 0, 2, 5},
            {4, 2, 0, 1},
            {0, 5, 1, 0}
        };

        int heuristic[] = {7, 6, 2, 0};

        int start = 0;
        int goal = 3;

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a,b) -> a.cost - b.cost);

        boolean visited[] = new boolean[4];

        pq.add(new Node(start, heuristic[start]));

        System.out.println("Path:");

        while(!pq.isEmpty())
        {
            Node current = pq.poll();

            int v = current.vertex;

            if(visited[v])
                continue;

            visited[v] = true;

            System.out.print(v + " ");

            if(v == goal)
                break;

            for(int i=0; i<4; i++)
            {
                if(graph[v][i] != 0 && !visited[i])
                {
                    int f = graph[v][i] + heuristic[i];
                    pq.add(new Node(i, f));
                }
            }
        }
    }
}