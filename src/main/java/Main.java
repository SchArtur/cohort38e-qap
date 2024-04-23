public class Main {

    public static void main(String[] args) {
        String s = "(3)";
        int qtyBefore = Integer.parseInt(s.replace("(", "").replace(")", ""));
        System.out.println(qtyBefore);
    }
}
