import java.util.Scanner;

// nullenese translator

 class Caesar {
    static final int SHIFT = 8;

    static String shift(String text, int amount) {
        StringBuilder out = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                out.append((char) ('A' + Math.floorMod(c - 'A' + amount, 26)));
            } else if (c >= 'a' && c <= 'z') {
                out.append((char) ('a' + Math.floorMod(c - 'a' + amount, 26)));
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println("Nullense Translator");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("\n(e)ncrypt, (d)ecrypt, or (q)uit: ");
            String choice = in.nextLine().trim().toLowerCase();

            if (choice.equals("q")) {
                break;
            } else if (choice.equals("e") || choice.equals("d")) {
                System.out.print("Text: ");
                String text = in.nextLine();
                int amount = choice.equals("e") ? SHIFT : -SHIFT;
                System.out.println("Result: " + shift(text, amount));
            } else {
                System.out.println("Enter e, d, or q.");
            }
        }
        in.close();
    }
}