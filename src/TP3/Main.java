package TP3;

import TP2.Dot;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void treeMaps() {
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        File f = new File("/Users/admin/IdeaProjects/TP1/src/TP3/Main.java");
        try {
            Scanner sc = new Scanner(f);
            String tmp;
            while(sc.hasNext())
            {
                tmp = sc.next();
                if(treeMap.containsKey(tmp))
                {
                    treeMap.replace(tmp, treeMap.get(tmp)+1);
                }
                else
                {
                    treeMap.put(tmp, 1);
                }
            }
            sc.close();
            for(String key: treeMap.keySet())  {
                System.out.println(key + " --> " + treeMap.get(key));
            }
            System.out.println("-------------------------------------------------");
            SortedMap<String,Integer> treeMap1;
            treeMap1 = treeMap.headMap("milieu");
            for(String key: treeMap1.keySet())  {
                System.out.println(key + " --> " + treeMap1.get(key));
            }
            System.out.println("-------------------------------------------------");
            TreeMap<String,Integer> treeMap2 = new TreeMap<>();
            Set keys = treeMap.keySet();
            for (Object o : keys) {
                String key = (String) o;
                Integer value = treeMap.get(key);
                if (value >=3 && value <= 5)
                    treeMap2.put(key, value);
            }
            for(String key: treeMap2.keySet())  {
                System.out.println(key + " --> " + treeMap2.get(key));
            }
        }
        catch (IOException e)
        {
            System.out.println("Erreur");
        }

    }

    public static void iteratorsTest() {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 20; ++i) {
            arr.add(i);
        }
        ListIterator<Integer> it = arr.listIterator();
        Random rand = new Random();
        int randInt = rand.nextInt(arr.size() - 1);
        while (it.hasNext()) {
            if (randInt == 0) {
                it.add(50);
                it.add(50);
                it.add(50);
                it.add(50);
                it.add(50);
                break;
            }
            it.next();
            randInt--;
        }
    }

    public static void iteratorsTestList() {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 20; ++i) {
            list.add(i);
        }
        ListIterator<Integer> it = list.listIterator();
        Random rand = new Random();
        int randInt = rand.nextInt(list.size() - 1);
        while (it.hasNext()) {
            if (randInt == 0) {
                it.add(50);
                it.add(50);
                it.add(50);
                it.add(50);
                it.add(50);
                break;
            }
            it.next();
            randInt--;
        }
    }


    public static void hashSets() {
        HashSet<Dot> hashSet = new HashSet<>();
        hashSet.add(new Dot(2,5));
        hashSet.add(new Dot(2,5));
        System.out.println(hashSet);
    }

    public static void main(String[] args) {
        hashSets();
        System.out.println("------------------------------------");
        iteratorsTest();
        System.out.println("------------------------------------");
        iteratorsTestList();
        System.out.println("------------------------------------");
        treeMaps();
    }
}
