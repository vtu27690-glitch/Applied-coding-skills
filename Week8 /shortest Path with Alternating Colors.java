
import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // 0 = red, 1 = blue
        List<Integer>[][] graph = new ArrayList[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = new ArrayList<>();
            graph[i][1] = new ArrayList<>();
        }

        // Add red edges
        for (int[] edge : redEdges) {
            graph[edge[0]][0].add(edge[1]);
        }

        // Add blue edges
        for (int[] edge : blueEdges) {
            graph[edge[0]][1].add(edge[1]);
        }

        int[][] dist = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Start from node 0 with either color as the next edge
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        dist[0][0] = 0;
        dist[0][1] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int color = current[1];

            // Next edge must have the opposite color
            int nextColor = 1 - color;

            for (int next : graph[node][nextColor]) {
                if (dist[next][nextColor] == -1) {
                    dist[next][nextColor] =
                        dist[node][color] + 1;

                    queue.offer(new int[]{next, nextColor});
                }
            }
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1) {
                answer[i] = dist[i][1];
            } else if (dist[i][1] == -1) {
                answer[i] = dist[i][0];
            } else {
                answer[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }

        return answer;
    }
}



Input
n =
3
redEdges =
[[0,1],[1,2]]
blueEdges =
[]
Output
[0,1,-1]
Expected
[0,1,-1]
