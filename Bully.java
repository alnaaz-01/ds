import java.util.Scanner;

public class Bully {
    static boolean[] state = new boolean[5]; // true = up, false = down
    static int coordinator = 5; // Initially, process 5 is the coordinator

    public static void bringUp(int processNum) {
        if (state[processNum - 1]) {
            System.out.println("Process " + processNum + " is already up.");
        } else {
            state[processNum - 1] = true;
            System.out.println("Process " + processNum + " held election.");

            for (int i = processNum + 1; i <= 5; i++) {
                if (state[i - 1]) {
                    System.out.println("Election message sent from process " + processNum + " to process " + i);
                }
            }

            for (int i = 5; i > processNum; i--) {
                if (state[i - 1]) {
                    System.out.println("Alive message sent from process " + i + " to process " + processNum);
                    coordinator = i;
                    break;
                }
            }
        }
    }

    public static void bringDown(int processNum) {
        if (!state[processNum - 1]) {
            System.out.println("Process " + processNum + " is already down.");
        } else {
            state[processNum - 1] = false;
            System.out.println("Process " + processNum + " is now down.");
            if (processNum == coordinator) {
                System.out.println("Coordinator is down.");
            }
        }
    }

    public static void sendMessage(int processNum) {
        if (!state[processNum - 1]) {
            System.out.println("Process " + processNum + " is down.");
            return;
        }

        if (state[coordinator - 1]) {
            System.out.println("Process " + processNum + " sends message to coordinator " + coordinator + ": OK");
        } else {
            System.out.println("Coordinator " + coordinator + " is down.");
            System.out.println("Process " + processNum + " initiates election.");

            for (int i = processNum + 1; i <= 5; i++) {
                if (state[i - 1]) {
                    System.out.println("Election message sent from process " + processNum + " to process " + i);
                }
            }

            for (int i = 5; i >= 1; i--) {
                if (state[i - 1]) {
                    coordinator = i;
                    System.out.println("Coordinator message sent from process " + i + " to all.");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Initially all processes are up
        for (int i = 0; i < 5; i++) {
            state[i] = true;
        }

        System.out.println("5 active processes are:");
        System.out.println("Processes up = P1 P2 P3 P4 P5");
        System.out.println("Process 5 is the coordinator.");

        do {
            System.out.println("\n---------");
            System.out.println("1. Bring up a process");
            System.out.println("2. Bring down a process");
            System.out.println("3. Send a message");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter process number to bring up (1-5): ");
                    int upProc = sc.nextInt();
                    if (upProc < 1 || upProc > 5) {
                        System.out.println("Invalid process number.");
                    } else {
                        bringUp(upProc);
                    }
                    break;

                case 2:
                    System.out.print("Enter process number to bring down (1-5): ");
                    int downProc = sc.nextInt();
                    if (downProc < 1 || downProc > 5) {
                        System.out.println("Invalid process number.");
                    } else {
                        bringDown(downProc);
                    }
                    break;

                case 3:
                    System.out.print("Enter process number to send a message (1-5): ");
                    int msgProc = sc.nextInt();
                    if (msgProc < 1 || msgProc > 5) {
                        System.out.println("Invalid process number.");
                    } else {
                        sendMessage(msgProc);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 4);

        sc.close();
    }
}

//cd Desktop
//cd folder-name
//javac f-name.java
//java f-name
