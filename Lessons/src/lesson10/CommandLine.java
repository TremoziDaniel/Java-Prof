package lesson10;

import java.util.Scanner;

public class CommandLine {
    public void exec() {
        Database db = new Database();
        db.init(DBInit.init());
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("# ");
            String cmd = scanner.next();
            switch(cmd.charAt(0)) {
                case 'c' :
                    db.create();
                    break;
                case 'r':
                    db.read();
                    break;
                case 'u':
                    db.update();
                    break;
                case 'd':
                    db.delete();
                    break;
                case 'x':
                    System.out.println("Finish / Exit of program");
                    return;
                default:
                    System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete], e[x]it");
            }
        }
    }
}
