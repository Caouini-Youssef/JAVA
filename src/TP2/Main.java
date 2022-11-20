package TP2;

import TP1.Integers.Integers;
import TP1.List.List;
import TP1.List.Node;
import TP1.Structure;
import TP2.Shapes.Circle;
import TP2.Shapes.Image;
import TP2.Shapes.Segment;
import TP4.Infos;

public class Main {
    public static void main(String[] args) throws Exception {
        TransformStack myStack = new TransformStack(100);
        Dot myDot = new Dot();
        Circle myCircle = new Circle(new Dot(),5);
        Segment mySegment = new Segment(new Dot(1,1), new Dot(10,10));
        myStack.stack(myDot);
        mySegment.draw(myStack);
        myCircle.draw(myStack);
        myCircle.move(new Dot(2,2));
        mySegment.move(new Dot(2,2));
        Image myImage = new Image();
        myImage.add(myCircle);
        myImage.add(mySegment);
        myImage.draw(myStack);
        myImage.move(new Dot(4,3));
        myImage.draw(myStack);
        myStack.unstack();

        System.out.println("-----------------------------------------------------------");


        Dot p1 = new Dot(2, 4);
        Dot p2 = new Dot(3, 5);
        Dot p3 = new Dot(4, 6);
        Dot p4 = new Dot(5, 7);
        TransformStack pt = new TransformStack(10);
        pt.stack(p3);
        Segment s1 = new Segment(p1, p2);
        Circle c1 = new Circle(p3, 3);
        s1.draw(pt);
        c1.draw(pt);
        s1.move(p1);
        c1.move(p1);
        Image i1 = new Image(p4);
        i1.add(s1);
        i1.add(c1);
        i1.draw(pt);
        i1.move(p2);
        i1.draw(pt);
        pt.unstack();
        System.out.println("-----------------------------------------------------------");

        Segment s2 = new Segment(p3, p4);
        Circle c2 = new Circle(p4, 4);
        Image i2 = new Image(p3);
        Image i3 = new Image(p2);
        Image i4 = new Image(p1);
        pt.stack(p1);
        i2.add(s1);
        i2.add(c1);
        i3.add(s2);
        i3.add(c2);
        i2.draw(pt);
        i3.draw(pt);
        i2.move(p1);
        i4.add(i2);
        i4.add(i3);
        i4.draw(pt);
        System.out.println("------------------------------------------------------------");

        Structure[] myStructure = new Structure[10];
        myStructure[0] = new List(new Node(0,null));
        myStructure[1] = new Integers(10);
    }
}
