package lesson8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Lesson8 {
    public static void main(String[] args) {
        RubberList<Integer> rl = new RubberList<>();
        rl.add(12);
//        rl.add(2);
//        rl.add(99);
//        rl.add(3);
//        rl.add(4);

//        System.out.println(rl.remove(12));
        System.out.println(rl.remove(4));
        System.out.println(rl.remove(99));

        System.out.println(rl);
    }
}
