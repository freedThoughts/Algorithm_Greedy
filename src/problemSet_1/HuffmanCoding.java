package problemSet_1;

import java.util.*;

public class HuffmanCoding {
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int numberOfChar = Integer.valueOf(s.split(" ")[0]);
        s = in.nextLine();
        String[] c = s.split(" ");
        s = in.nextLine();
        String[] fre = s.split(" ");
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for(int i = 0; i < numberOfChar; i++)
            queue.add(new Node(Character.valueOf(c[i].charAt(0)), Integer.valueOf(fre[i])));

        while(queue.size()>1){
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            Character k = (node1.c);
            queue.add(new Node('-', node1.frequency + node2.frequency, node1, node2));
        }
        Node root = queue.poll();
        HuffmanCoding.printIt(root, "");
    }

    private static void printIt(Node root, String code){
        if(root.left == null && root.right == null){
            System.out.println(root.c + " :- " + code);
            return;
        }
        printIt(root.left, code + "0");
        printIt(root.right, code + "1");
    }

    private static class Node implements Comparable{
        private Character c;
        private Integer frequency;
        Node left;
        Node right;
        Node(Character c, Integer frequency){
            this.c = c;
            this.frequency = frequency;
        }
        Node(Character c, Integer frequency, Node left, Node right){
            this.c = c;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Object o) {
            return this.frequency.compareTo(((Node)o).frequency);
        }
    }
}
