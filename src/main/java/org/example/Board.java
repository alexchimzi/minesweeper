package org.example;

import java.util.Random;

public class Board {
    private int [][] vBoard = new int[10][10];
    private int [][] inBoard = new int[10][10];


    public void init() {
        System.out.println("WELCOME\n");
        for (int x = 0; x < 9; x++) {
            Random r = new Random();
            int i = r.nextInt(6);
            int j = r.nextInt(6);
            inBoard [i][j] = 100;
            buildHidden();
            //System.out.println("i: " + i + " j: " + j);
        }
        //System.out.println(inBoard.);
    }
    public void buildHidden()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                int cnt=0;
                if(inBoard[i][j]!=100)
                {

                    if(i!=0)
                    {
                        if(inBoard[i-1][j]==100) cnt++;
                        if(j!=0)
                        {
                            if(inBoard[i-1][j-1]==100) cnt++;
                        }

                    }
                    if(i!=9)
                    {
                        if(inBoard[i+1][j]==100) cnt++;
                        if(j!=9)
                        {
                            if(inBoard[i+1][j+1]==100) cnt++;
                        }
                    }
                    if(j!=0)
                    {
                        if(inBoard[i][j-1]==100) cnt++;
                        if(i!=9)
                        {
                            if(inBoard[i+1][j-1]==100) cnt++;
                        }
                    }
                    if(j!=9)
                    {
                        if(inBoard[i][j+1]==100) cnt++;
                        if(i!=0)
                        {
                            if(inBoard[i-1][j+1]==100) cnt++;
                        }
                    }

                    inBoard[i][j] = cnt;
                }
            }
        }

    }
    public void displayVisible()
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(vBoard[i][j]==0)
                {
                    System.out.print("*");
                }
                else if(vBoard[i][j]==50)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(vBoard[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
}
