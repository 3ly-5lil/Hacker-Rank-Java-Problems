import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

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

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    public int getResult() {
        //implement this

        return 0;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class FancyVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

public class Solution {


    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> values = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            values.put(i+1, sc.nextInt());
        }

        Map<Integer, Color> colors = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            colors.put(i+1, sc.nextInt() == 0 ? Color.RED : Color.GREEN);
        }

        Map<Integer, List<Integer>> children = new HashMap<>(n - 1);
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();

            children.computeIfAbsent(parent, k -> new ArrayList<>())
                    .add(sc.nextInt());
        }
        sc.close();

        int depth = 0;

        TreeNode root = new TreeNode(values.get(1), colors.get(1), depth);
        processChildren(1, root, values, colors, children);

        return root;
    }

    private static void processChildren(int index, TreeNode node, Map<Integer, Integer> values, Map<Integer,Color> colors, Map<Integer, List<Integer>> children) {
        int newDepth = node.getDepth()+1;

        children.get(index).forEach((integer -> {
            if (children.containsKey(integer)) {
                TreeNode childNode = new TreeNode(values.get(integer), colors.get(integer), newDepth);

                processChildren(integer, childNode, values, colors, children);

                node.addChild(childNode);
            } else {
                node.addChild(new TreeLeaf(values.get(integer), colors.get(integer), newDepth));
            }
        }));
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