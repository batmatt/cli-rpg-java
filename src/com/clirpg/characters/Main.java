
package src.com.clirpg.characters;

import java.util.Scanner;

class Main {
    public static void main(String[] arguments) {
        Civillian c1 = new Civillian("brian", "welder");
        System.out.println(c1.toString());
        c1.talk();
    }
}