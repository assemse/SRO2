import java.util.*;

public class SocialNetworkGraph {

    private final Map<String, List<String>> graph;

    public SocialNetworkGraph() {
        this.graph = new HashMap<>();
    }

    public void addUser(String user) {
        if (!graph.containsKey(user)) {
            graph.put(user, new ArrayList<>());
        } else {
            System.out.println("Пользователь " + user + " уже существует.");
        }
    }

    public void addFriendship(String user1, String user2) {
        // Если одного из пользователей нет, добавляем его
        addUser(user1);
        addUser(user2);

        graph.get(user1).add(user2);
        graph.get(user2).add(user1);
    }

    public void showNetwork() {
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            String user = entry.getKey();
            List<String> friends = entry.getValue();
            System.out.println("Пользователь " + user + " -> Друзья: " + (friends.isEmpty() ? "Нет друзей" : String.join(", ", friends)));
        }
    }

    public static void main(String[] args) {
        SocialNetworkGraph network = new SocialNetworkGraph();

        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");

        network.addFriendship("Alice", "Bob");
        network.addFriendship("Alice", "Charlie");
        network.addFriendship("Bob", "Charlie");

        network.showNetwork();
    }
}
