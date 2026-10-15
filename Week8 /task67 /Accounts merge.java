
import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Map each email to its neighboring emails
        Map<String, List<String>> graph = new HashMap<>();

        // Map each email to the account owner's name
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                graph.putIfAbsent(email, new ArrayList<>());
                emailToName.put(email, name);

                // Connect all emails in the same account
                if (i > 1) {
                    String previousEmail = account.get(i - 1);

                    graph.get(email).add(previousEmail);
                    graph.get(previousEmail).add(email);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        // Visit each connected component
        for (String email : graph.keySet()) {
            if (visited.contains(email)) {
                continue;
            }

            List<String> mergedEmails = new ArrayList<>();
            dfs(email, graph, visited, mergedEmails);

            Collections.sort(mergedEmails);

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(email));
            mergedAccount.addAll(mergedEmails);

            result.add(mergedAccount);
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> mergedEmails) {

        visited.add(email);
        mergedEmails.add(email);

        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, mergedEmails);
            }
        }
    }
}



Input
accounts =
[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output
[["John","johnnybravo@mail.com"],["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"]]
Expected
[["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
