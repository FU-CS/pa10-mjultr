package pa10;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class GraphTest {
    @Test
    void testTopologicalSortWithDFS() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        List<Integer> expectedOrder = List.of(0, 1, 2, 3);
        assertEquals(expectedOrder, g.topologicalSort());
    }

    @Test
    void testTopologicalSortWithKahn() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        String expectedOrder = "[0, 1, 2, 3]";
        assertEquals(expectedOrder, g.kahn());
    }

    @Test
    void testGraphWithCycle() {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // Creates a cycle

        assertEquals("Graph has a cycle", g.kahn());
    }

@Test
void testDisconnectedGraph() {
    Graph g = new Graph(6);
    g.addEdge(0, 1);
    g.addEdge(2, 3);
    g.addEdge(4, 5);

    // Verify the size of the result from DFS
    List<Integer> topologicalOrderDFS = g.topologicalSort();
    assertEquals(6, topologicalOrderDFS.size());

    // Verify the size of the result from Kahn's algorithm
    String topologicalOrderKahn = g.kahn();
    assertFalse(topologicalOrderKahn.equals("Graph has a cycle"));
    assertTrue(topologicalOrderKahn.contains("0"));
    assertTrue(topologicalOrderKahn.contains("1"));
    assertTrue(topologicalOrderKahn.contains("2"));
    assertTrue(topologicalOrderKahn.contains("3"));
    assertTrue(topologicalOrderKahn.contains("4"));
    assertTrue(topologicalOrderKahn.contains("5"));
}


}
