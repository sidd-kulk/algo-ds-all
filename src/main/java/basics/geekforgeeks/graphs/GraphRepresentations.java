package basics.geekforgeeks.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class GraphRepresentations {
    public static void main(String[] args) {

    }

    static void testBFS() {
        AdjacencyList al = new AdjacencyList(4);
        al.addEdge(0, 1);
        al.addEdge(0, 2);
        al.addEdge(1, 2);
        al.addEdge(1, 3);
        al.addEdge(2, 3);
        al.addVertex();
        System.out.println(al);
        al.bfsTraversal();
    }
}

class AdjacencyMatrix {
    private List<List<Integer>> matrix;

}


class AdjacencyList {
    private final List<List<Integer>> list;
    private final boolean isDirected;

    AdjacencyList(int vertexes) {
        this(vertexes, false);
    }

    AdjacencyList(int vertexes, boolean isDirected) {
        this.list = new ArrayList<>(vertexes);
        for (int i = 0; i < vertexes; i++) {
            this.list.add(new ArrayList<>());
        }
        this.isDirected = isDirected;
    }

    void addEdge(Integer from, Integer to) {
        list.get(from).add(to);
        if (!isDirected) {
            list.get(to).add(from);
        }
    }

    void addVertex() {
        list.add(new ArrayList<>());
    }

    void bfsTraversal() {
        Set<Integer> visitedVertices = new HashSet<>();
        int size = this.list.size();
        for (int i = 0; i < size; i++) {// Because of disconnected vertices
            if (!visitedVertices.contains(i)) {
                this.bfsTraversal(i, visitedVertices);
            }
        }
    }

    private void bfsTraversal(Integer source, Set<Integer> visitedVertices) {
        var queue = new LinkedList<Integer>();
        queue.add(source);
        visitedVertices.add(source);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var inList = this.list.get(node);
            System.out.print(node + " ,");
            for (Integer i : inList) {
                if (!visitedVertices.contains(i)) {
                    visitedVertices.add(i);
                    queue.add(i);
                }
            }

        }
    }

    @Override
    public String toString() {
        return "AdjacencyList{" +
                "list=" + list.stream().filter(i -> i.size() > 0).collect(Collectors.toList()) +
//                "list=" + list +
                '}';
    }
}
