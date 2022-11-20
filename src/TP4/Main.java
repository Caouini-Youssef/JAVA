package TP4;

import TP1.Integers.Integers;
import TP1.*;
import TP2.*;
import TP3.*;

import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void classInfo() {
        try {
            Scanner sc= new Scanner(System.in);
            System.out.print("Entrez un nom de classe : ");
            String str= sc.nextLine();
            System.out.println(str);
            Class<?> c = Class.forName(str);
            for (Field f : c.getFields()) System.out.println("Attribut : " + f.getName() + "Type : " + f.getType());
            System.out.println();
            System.out.println();
            for (Method x : c.getDeclaredMethods()) {
                System.out.println("Nom de la méthode : " + x.getName()  + " Type de retour : " + x.getReturnType());
                System.out.println(" Paramètres : ");
                for (Parameter p : x.getParameters())
                {
                    System.out.println("Paramètre : " + p.getName() + " Type : " + p.getType());
                }
                System.out.println();
            }

        }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur : Classe non trouvée / Nom incorrecte");
            System.exit(-1);
        }
    }

    public static void insertAndDelete() {
        try {
            Integers ints = new Integers(100);
            Scanner sc= new Scanner(System.in);
            String str, str2;
            do {
                System.out.print("insert / delete / Sortir ? : ");
                str= sc.nextLine();
                System.out.print("Entrez un nombre : ");
                str2= sc.nextLine();
                ints.getClass().getDeclaredMethod(str,int.class).invoke(ints,Integer.parseInt(str2));
                ints.print();
            } while (!Objects.equals(str, "Sortir"));
            ints.display();
        }
        catch (Exception e) {
            System.out.print("Erreur : ");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void resetAttribute() {
        try {
            Dot myDot = new Dot(5,5);
            System.out.println("myDot.X : " + myDot.getX() + " / myDot.Y : " + myDot.getY());
            Scanner sc= new Scanner(System.in);
            String str;
            System.out.print("Quel attribut souhaitez vous remettre à zéro ? ");
            str= sc.nextLine();
            Field f = myDot.getClass().getDeclaredField(str);
            f.setAccessible(true);
            f.setInt(myDot,0);
            System.out.println("myDot.X : " + myDot.getX() + " / myDot.Y : " + myDot.getY());
        }
        catch (Exception e) {
            System.out.print("Erreur : ");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static double compareClasses() throws ClassNotFoundException {
        Scanner sc= new Scanner(System.in);
        String str;
        System.out.print("Noms des classes à comparer");
        str= sc.nextLine();
        Class<?> c1 = Class.forName(str);
        str = sc.nextLine();
        Class<?> c2 = Class.forName(str);
        int cptFirst = 0;
        int cptSecond = 0;
        int cptSame = 0;
        HashMap<String, Boolean> myHash = new HashMap<String, Boolean>();
        for (Method m : c1.getDeclaredMethods()) {
            cptFirst++;
            myHash.put(m.getName(), false);
        }
        for (Method m : c2.getDeclaredMethods()) {
            cptSecond++;
            if (myHash.containsKey(m.getName()))
            {
                myHash.replace(m.getName(), false, true);
            }
        }
        for (Boolean b : myHash.values())
        {
            if (b)
                cptSame++;
        }
        if (cptFirst > cptSecond)
            return (double) cptSame/cptFirst;
        else
            return (double) cptSame/cptSecond;
    }

    public static void annotationListing() throws ClassNotFoundException {
        File f = new File("/Users/admin/IdeaProjects/TP1/src/TP2/Shapes");
        String [] fileList = f.list();
        ArrayList<Class<?>> classArray = new ArrayList<>();

        assert fileList != null;
        for (String s : fileList)
        {
            Class<?> c = Class.forName("TP2.Shapes." + s.substring(0, s.length()-5));
            classArray.add(c);
        }
        for (Class<?> c : classArray)
        {
            if (c.isAnnotationPresent(Infos.class))
            {
                Infos inf = c.getAnnotation(Infos.class);
                if (inf.Date() > 2012)
                    System.out.println(c.getName() + ", créée en " + inf.Date());
            }
        }
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        try {
            classInfo();
            System.out.println("-------------------------------------");
            insertAndDelete();
            System.out.println("-------------------------------------");
            resetAttribute();
            System.out.println("-------------------------------------");
            System.out.println("Pourcentage de ressemblance : " + df.format(compareClasses()*100) + "%");
            System.out.println("-------------------------------------");
            annotationListing();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}