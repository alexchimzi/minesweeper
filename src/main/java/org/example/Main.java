package org.example;

public class Main {
    public static void main(String[] args) {

        Board B = new Board();
        B.init();
        B.displayVisible();
        boolean flag = true;
        while(flag)
        {
            B.displayVisible();
            flag = B.playMove();
            if(B.checkResult())
            {
                B.displayHidden();
                System.out.println("\n================You WON!!!================");
                break;
            }
        }

    }
}