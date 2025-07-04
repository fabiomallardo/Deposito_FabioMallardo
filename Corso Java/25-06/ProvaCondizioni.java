public class ProvaCondizioni {

    public static void main(String[] args) {

        // Espressione booleana (false)
        int x = 10;
        int y = 20;
        System.out.println((x >= y));

        // Espressione booleana (true)
        int a = 10;
        int b = 20;
        System.out.println((a <= b));

        // Blocchi if
        if (20 > 18) {
            System.out.println("20 is greater than 18");
        }

        int x2 = 20;
        int y2 = 18;
        if (x2 > y2) {
            System.out.println(x2 + " is greater than " + y2);
        }

        // Blocco if and else
        int time = 20;
        if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        // Blocco if, else if and else
        int time2 = 22;
        if (time2 < 10) {
            System.out.println("Good morning.");
        } else if (time2 < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        // Operatore ternario
        int time3 = 20;
        String result = (time3 < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

        // Switch
        int day = 4;
        switch (day) {
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            case 3:
            System.out.println("Wednesday");
            break;
            case 4:
            System.out.println("Thursday");
            break;
            case 5:
            System.out.println("Friday");
            break;
            case 6:
            System.out.println("Saturday");
            break;
            case 7:
            System.out.println("Sunday");
            break;
        }
    }
}