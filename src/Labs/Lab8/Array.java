package Labs.Lab8;

public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[8];

        System.arraycopy(tokens, 0, customerName, 0, tokens.length);

        displayNames(customerName);

        customerName[6] = customerName[4];
        customerName[7] = customerName[5];
        customerName[4] = "Rick";
        customerName[5] = "Jessica";

        displayNames(customerName);

        String[] namesReversed = reverseNames(customerName);
        displayNames(namesReversed);

        for (int i = 0; i < namesReversed.length; i++) {
            if (namesReversed[i] != null) {
                while (namesReversed[i].equals("Rick")) {
                    for (int j = i; j < namesReversed.length - 1; j++) {
                        namesReversed[j] = namesReversed[j + 1];
                    }
                    namesReversed[namesReversed.length - 1] = null;
                }
            }
        }

        displayNames(namesReversed);
    }

    public static void displayNames(String[] names) {
        for (String n : names) {
            System.out.println(n);
        }
        System.out.println();
    }

    public static String[] reverseNames(String[] names) {
        String[] namesReversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            namesReversed[i] = names[names.length - i - 1];
        }
        return namesReversed;
    }
}
