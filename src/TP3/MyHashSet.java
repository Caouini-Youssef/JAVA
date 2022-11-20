package TP3;

import TP2.Dot;

import java.util.HashSet;
import java.util.Random;

public class MyHashSet<E> extends HashSet<E> {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet<Dot>();
        hashSet.add(new Dot(2,10));
        hashSet.add(new Dot(1,11));
        hashSet.add(new Dot(5,7));
        hashSet.add(new Dot(3,9));
        hashSet.add(new Dot(6,6));
        hashSet.add(new Dot(4,8));
        MyHashSet hashSet1;
        hashSet1 = hashSet.subHashRand(5);
        Object[] arrDot = hashSet1.toArray();
        for(int i = 0; i < hashSet1.size(); ++i) {
            System.out.println(i + " --> " + arrDot[i]);
        }
    }
    public MyHashSet<E> subHashRand(int n) {
        MyHashSet<E> myHashSet = new MyHashSet<E>();
        int randInt = 0;
        Random rand;
        E[] arr = (E[]) this.toArray();
        while(n > 0)
        {
            rand = new Random();
            randInt = rand.nextInt(super.size() - 1);
            if (arr[randInt] != null)
            {
                myHashSet.add(arr[randInt]);
                arr[randInt] = null;
                n--;

            }
        }
        return myHashSet;
    }
}
