
    import java.util.*;
    import java.util.Collections;
    public class Graph {

        ArrayList<Node> nodeList;
        ArrayList<Edge> edgeList;


        public Graph() {
            nodeList = new ArrayList<Node>();
            edgeList = new ArrayList<Edge>();
        }

        public ArrayList<Node> getNodeList() {
            return nodeList;
        }

        public ArrayList<Edge> getEdgeList() {
            return edgeList;
        }

        public void addNode(Node n) {
            nodeList.add(n);
        }

        public void addEdge(Edge e) {
            edgeList.add(e);
        }

        public String toString() {
            return nodeList + " " + edgeList;
        }

        public int LE() {
            List edg = new ArrayList();
            Edge largest = new Edge(null, null, 0);
            for (Edge i : edgeList)
                if (largest.getDist() < i.getDist())
                    largest.setDist(i.getDist());
            return largest.getDist();
        }

        public String LE2() {
            Edge largest = new Edge(null, null, 0);
            for (Edge i : edgeList)
                if (largest.getDist() < i.getDist())
                    largest.setDist(i.getDist());
            return null;

        }

        public List ME() {
            Node nod2 = new Node(null);
            Edge edg2 = new Edge(null, null, 0);
            List MEL = new ArrayList();
            int s = 0;
            for (Node i : nodeList)
                if (s < i.getOutgoingEdges().size())
                    s = i.getOutgoingEdges().size();
            for (Node j : nodeList)
                if (j.getOutgoingEdges().size() == s)
                    MEL.add(j.getAbbrev());
            return MEL;
        }

        public int ME2() {
            Node nod2 = new Node(null);
            Edge edg2 = new Edge(null, null, 0);
            List MEL = new ArrayList();
            int s = 0;
            for (Node i : nodeList)
                if (s < i.getOutgoingEdges().size())
                    s = i.getOutgoingEdges().size();
            return s;
        }

        public List<Integer> list_of_coins() {
            List strval = new ArrayList();
            List<Integer> coins = new ArrayList<Integer>();

            //This created the list of integer for the coins
            for (Node i : nodeList)
                strval.add(i.getVal());
            for (int i = 0; i < strval.size(); i++) {
                int t = Integer.valueOf((String) strval.get(i));
                coins.add(t);
            }
            return coins;

            //This created the list of integer for the coins
        }
        public Node find_start_Node(){
            Node start = null;
            for(Node i: nodeList){
                if (i.getVal().equals("S"))
                    start = i;
            }
            return start;
        }

        public Node find_end_Node(){
            Node goal = null;
            for(Node i: nodeList){
                if (i.getVal().equals("G"))
                    goal = i;
            }
            return goal;
        }
    }

