import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    public GraphTraversal(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfsRec(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        GraphTraversal graph = new GraphTraversal(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);
        graph.dfs(0);
    }
}
