package basics.geekforgeeks.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphRepresentations {
    public static void main(String[] args) {
        AdjacencyList al = new AdjacencyList(4, true);
        al.addEdge(0, 1);
        al.addEdge(1, 0);
        al.addEdge(0, 2);
        al.addEdge(1, 2);
        al.addEdge(1, 3);
        al.addVertex();
        al.addEdge(3, 4);
        al.addVertex();
        al.addEdge(3, 5);
        al.addVertex();
        System.out.println(al);
    }
}

class AdjacencyMatrix {
    private List<List<Integer>> matrix;

}


class AdjacencyList {
    private List<List<Integer>> list;
    private boolean isDirected;

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

    @Override
    public String toString() {
        return "AdjacencyList{" +
                "list=" + list.stream().filter(i -> i.size() > 0).collect(Collectors.toList()) +
//                "list=" + list +
                '}';
    }
}
