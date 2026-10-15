
import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Assign a unique group to every ungrouped item
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Graphs and indegree arrays
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        // Build item and group graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {

                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        // Topologically sort groups
        List<Integer> sortedGroups =
            topologicalSort(groupGraph, groupIndegree);

        if (sortedGroups.size() != m) {
            return new int[0];
        }

        // Topologically sort items
        List<Integer> sortedItems =
            topologicalSort(itemGraph, itemIndegree);

        if (sortedItems.size() != n) {
            return new int[0];
        }

        // Store sorted items by group
        List<List<Integer>> itemsInGroup = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            itemsInGroup.add(new ArrayList<>());
        }

        for (int item : sortedItems) {
            itemsInGroup.get(group[item]).add(item);
        }

        // Combine groups in sorted order
        int[] result = new int[n];
        int index = 0;

        for (int g : sortedGroups) {
            for (int item : itemsInGroup.get(g)) {
                result[index++] = item;
            }
        }

        return result;
    }

    private List<Integer> topologicalSort(
        List<List<Integer>> graph, int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order;
    }
}

Input
n =
8
m =
2
group =
[-1,-1,1,0,0,1,0,-1]
beforeItems =
[[],[6],[5],[6],[3,6],[],[],[]]
Output
[6,3,4,5,2,0,7,1]
Expected
[6,3,4,1,5,2,0,7]


                           
