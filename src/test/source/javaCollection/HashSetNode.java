package source.javaCollection;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: mengxiangxing
 * @description:用链表去实现hashset
 * @create: 2021-07-31 14:44
 **/

@SpringBootTest
public class HashSetNode {

  int base = 769;

  Node[] nodes = new Node[10009];

  /** Initialize your data structure here. */
  public HashSetNode() {

  }

  @Test
  public void test() {
    this.add(14);
    this.add(783);
    this.contains(783);
    this.contains(3);
    this.add(2);
    this.contains(2);
    this.remove(2);
    this.contains(2);
  }

  public void add(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];
    if (tempNode == null) {
      nodes[index] = new Node(key);
      return;
    }

    while (tempNode != null) {
      if (tempNode.key == key) {
        return;
      }
      tempNode = tempNode.next;
    }
    tempNode = new Node(key);
    System.out.println("add后的值" + nodes.toString());
    return;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];

    if (tempNode == null) {
      return false;
    }

    while (tempNode != null) {
      if (key == tempNode.key) {
        return true;
      }
      tempNode = tempNode.next;
    }
    System.out.println("contians后的值" + nodes.toString());
    return false;
  }

  public void remove(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];

    if (tempNode == null) {
      return;
    }

    Node preNode = null;
    while (tempNode != null) {
      if (key == tempNode.key) {
        if (preNode == null) {
          nodes[index] = tempNode.next;
        } else {
          preNode.next = tempNode.next;
        }
        return;
      }
      preNode = tempNode;
      tempNode = tempNode.next;
    }

  }

  private int getIndex(int val) {
    return val % base;
  }

  class Node {
    int key;
    Node next;

    public Node(int key) {
      this.key = key;
    }
  }

}
