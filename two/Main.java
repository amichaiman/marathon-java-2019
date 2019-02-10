package two;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        LinkedList<A> alist = new LinkedList<>();

        alist.add(a);
        alist.add(b);

        LinkedList<B> blist = new LinkedList<>();

        alist.add(a);
        alist.add(b);

        ((B) a).print();
        ((A) b).print();

        A.printAll(alist);
        b.printAll(blist);
        A.printAll(blist);
        a.printObject(b);
        b.printObject((B) a);
        b.printObject((A) b);


    }
}
