package solved;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int sum = 0;
    public int getResult() {
        //implement this

        return sum;
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() == -1) return;
        //implement this

    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getDepth() == -1) return;
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long sum = 1;
    private final int M = 1000000007;
    public int getResult() {
        //implement this
        return (int) sum;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            sum = (sum * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            sum = (sum * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    int evenNodesSum = 0;
    int greenLeafsSum = 0;
    public int getResult() {
        //implement this
        return Math.abs(evenNodesSum-greenLeafsSum);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            evenNodesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            greenLeafsSum += leaf.getValue();
        }
    }
}


public class VisitorPattern {

    static Map<Integer, Integer> values = new HashMap<>();
    static Map<Integer, Color> colors = new HashMap<>();
    static Map<Integer, Set<Integer>> edges = new HashMap<>();

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] valuesSplit = sc.nextLine().split(" ");
        String[] colorsSplit = sc.nextLine().split(" ");

        for (int i = 1; i <= n; i++) {
            values.put(i, Integer.parseInt(valuesSplit[i-1]));
            colors.put(i, Integer.parseInt(colorsSplit[i-1]) == 0 ? Color.RED : Color.GREEN);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            edges.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            edges.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        sc.close();

        return buildTree(1, 0);
    }

    private static Tree buildTree(int nodeId, int depth) {
        Set<Integer> children = edges.get(nodeId);

        if (children.isEmpty()) return new TreeLeaf(values.get(nodeId), colors.get(nodeId), depth);

        TreeNode node = new TreeNode(values.get(nodeId), colors.get(nodeId), depth);

        children.forEach(childId -> {
            edges.get(childId).remove(nodeId);
            node.addChild(buildTree(childId, depth + 1));
        });

        return node;
    }



    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}