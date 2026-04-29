import p1.vinutha.muraleed.ExceptionDemo;

class FinallyDemo {
    private static ExceptionDemo ExceptionDemo;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            ExceptionDemo.generateException(i);
            System.out.println();
        }
    }
}
