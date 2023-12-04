// Du spielst dieses Spiel im Terminal-Fenster.
// Anweisungen: 
// Du bist ein Hai "^" und musst zuerst das Futter "°" holen und dann das Ziel "Z" erreichen. 
// Du darfst dich aber nicht im Fischernetz "#" verfangen!
// Du kannst dich mit der folgenden Steuerung bewegen:
// Nach oben = "w"
// Nach unten = "s"
// Links = "a"
// Recht = "d"


// Abstract Window Toolkit
import java.awt.Point;
import java.util.Scanner;

public class HaiSpiel {
    public static void main(String[] args) {
        //Objekte und Spieldfeld erstellen
        Point spielerPosition = new Point (10, 9);
        Point fischnetzPosition = new Point (20, 2);
        Point futterPosition = new Point(6, 3);
        Point zielPosition = new Point(2, 5);
        boolean weiter = true;
        boolean futterEingesammelt = false;

        //10x30
        while(weiter) {
        // System.out.print("\033[H\033[2J");
        for (int y = 0; y < 10; y++) {
        for (int x = 0; x < 30; x++) {
            Point p = new Point(x, y);
            if (p.equals(spielerPosition))
                System.out.print("^");
            else if (p.equals(fischnetzPosition)) 
                System.out.print("#");
            else if (p.equals(futterPosition)) 
                System.out.print("°");
            else if (p.equals(zielPosition))
            System.out.print("Z");
            else
                System.out.print("~");
        }
        System.out.println();
    }
    //Spiellogik
    if (fischnetzPosition.equals(spielerPosition)) {
        weiter = false;
        System.out.println("Ätsch! Du wurdest erwischt..");
    }
    if (spielerPosition.equals(futterPosition)) {
        futterEingesammelt = true;
        futterPosition = new Point(-1, -1);
    }
    if (spielerPosition.equals(zielPosition) && futterEingesammelt) {
        weiter = false;
        System.out.println("Gewonnen! Du bist entkommen");
    }
    bewegeSpieler(spielerPosition);
    bewegeNetz(fischnetzPosition, spielerPosition);
        }
}

    private static void bewegeNetz(Point fischnetzPosition, Point spielerPosition) {
        if (spielerPosition.x < fischnetzPosition.x)
        fischnetzPosition.x--;
        else if (spielerPosition.x > fischnetzPosition.x) 
            fischnetzPosition.x++;
        if (spielerPosition.y < fischnetzPosition.y)
        fischnetzPosition.y--;
        else if (spielerPosition.y > fischnetzPosition.y) 
            fischnetzPosition.y++;
    }
    private static void bewegeSpieler(Point spielerPosition) {
        Scanner scan = new Scanner(System.in);
            String input = scan.next();

            //w,a,s,d
            if (input.equals("w")) {
                if (spielerPosition.y > 0)
                spielerPosition.y--;
            } else if (input.equals("s")) {
                if (spielerPosition.y < 9)
                spielerPosition.y++;
            } else if (input.equals("a")) {
                if (spielerPosition.x > 0)
                spielerPosition.x--;
            } else if (input.equals("d")) {
                if (spielerPosition.x < 29)
                spielerPosition.x++;
            }
        }
    }
