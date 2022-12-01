package lesson9;

public class StringVsStringBuilder {
    public static void main(String[] args) {
        final long COUNT = 512_000;

        // with String
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < COUNT; i++) {
            str += "x";
        }
        System.out.println("String: " + (System.currentTimeMillis() - startTime)/1000.);

        // with StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < COUNT; i++) {
            buf.append("x");
        }
        System.out.println("StringBuffer: " + (System.currentTimeMillis() - startTime)/1000.);
    }
}
