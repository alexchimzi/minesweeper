package org.example;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private int [][] vBoard = new int[10][10];
    private int [][] inBoard = new int[10][10];

    public boolean playMove()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i= sc.nextInt();
        System.out.print("Enter Column Number: ");
        int j= sc.nextInt();

        if(i<0 || i>9 || j<0 || j>9 || vBoard[i][j]!=0)
        {
            System.out.print("\nIncorrect Input!!");
            return true;
        }

        if(inBoard[i][j]==100)
        {
            displayHidden();
            System.out.print("Oops! You stepped on a mine!\n============GAME OVER============");
            return false;
        }
        else if(inBoard[i][j]==0)
        {
            fixVisible(i, j);
        }
        else
        {
            fixNeighbours(i, j);
        }

        return true;
    }
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
    public void fixVisible(int i, int j)
    {
        vBoard[i][j] = 50;
        if(i!=0)
        {
            vBoard[i-1][j] = inBoard[i-1][j];
            if(vBoard[i-1][j]==0) vBoard[i-1][j] = 50;
            if(j!=0)
            {
                vBoard[i-1][j-1] = inBoard[i-1][j-1];
                if(vBoard[i-1][j-1]==0) vBoard[i-1][j-1]=50;

            }
        }
        if(i!=9)
        {
            vBoard[i+1][j]=inBoard[i+1][j];
            if(vBoard[i+1][j]==0) vBoard[i+1][j]=50;
            if(j!=9)
            {
                vBoard[i+1][j+1]= inBoard[i+1][j+1];
                if(vBoard[i+1][j+1]==0) vBoard[i+1][j+1] = 50;
            }
        }
        if(j!=0)
        {
            vBoard[i][j-1]=inBoard[i][j-1];
            if(vBoard[i][j-1]==0) vBoard[i][j-1] = 50;
            if(i!=9)
            {
                vBoard[i+1][j-1]=inBoard[i+1][j-1];
                if(vBoard[i+1][j-1]==0) vBoard[i+1][j-1] = 50;
            }
        }
        if(j!=9)
        {
            vBoard[i][j+1]=inBoard[i][j+1];
            if(vBoard[i][j+1]==0) vBoard[i][j+1] = 50;
            if(i!=0)
            {
                vBoard[i-1][j+1]=inBoard[i-1][j+1];
                if(vBoard[i-1][j+1]==0) vBoard[i-1][j+1] = 50;
            }
        }
    }

    public void fixNeighbours(int i, int j)
    {
        Random random = new Random();
        int x = random.nextInt()%4;

        vBoard[i][j] = inBoard[i][j];

        if(x==0)
        {
            if(i!=0)
            {
                if(inBoard[i-1][j]!=100)
                {
                    vBoard[i-1][j] = inBoard[i-1][j];
                    if(vBoard[i-1][j]==0)  vBoard[i-1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(inBoard[i][j-1]!=100)
                {
                    vBoard[i][j-1] = inBoard[i][j-1];
                    if(vBoard[i][j-1]==0)  vBoard[i][j-1] = 50;
                }

            }
            if(i!=0 && j!=0)
            {
                if(inBoard[i-1][j-1]!=100)
                {
                    vBoard[i-1][j-1] = inBoard[i-1][j-1];
                    if(vBoard[i-1][j-1]==0)  vBoard[i-1][j-1] = 50;
                }

            }
        }
        else if(x==1)
        {
            if(i!=0)
            {
                if(inBoard[i-1][j]!=100)
                {
                    vBoard[i-1][j] = inBoard[i-1][j];
                    if(vBoard[i-1][j]==0)  vBoard[i-1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(inBoard[i][j+1]!=100)
                {
                    vBoard[i][j+1] = inBoard[i][j+1];
                    if(vBoard[i][j+1]==0)  vBoard[i][j+1] = 50;
                }

            }
            if(i!=0 && j!=9)
            {
                if(inBoard[i-1][j+1]!=100)
                {
                    vBoard[i-1][j+1] = inBoard[i-1][j+1];
                    if(vBoard[i-1][j+1]==0)  vBoard[i-1][j+1] = 50;
                }
            }
        }
        else if(x==2)
        {
            if(i!=9)
            {
                if(inBoard[i+1][j]!=100)
                {
                    vBoard[i+1][j] = inBoard[i+1][j];
                    if(vBoard[i+1][j]==0)  vBoard[i+1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(inBoard[i][j+1]!=100)
                {
                    vBoard[i][j+1] = inBoard[i][j+1];
                    if(vBoard[i][j+1]==0)  vBoard[i][j+1] = 50;
                }

            }
            if(i!=9 && j!=9)
            {
                if(inBoard[i+1][j+1]!=100)
                {
                    vBoard[i+1][j+1] = inBoard[i+1][j+1];
                    if(vBoard[i+1][j+1]==0)  vBoard[i+1][j+1] = 50;
                }
            }
        }
        else
        {
            if(i!=9)
            {
                if(inBoard[i+1][j]!=100)
                {
                    vBoard[i+1][j] = inBoard[i+1][j];
                    if(vBoard[i+1][j]==0)  vBoard[i+1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(inBoard[i][j-1]!=100)
                {
                    vBoard[i][j-1] = inBoard[i][j-1];
                    if(vBoard[i][j-1]==0)  vBoard[i][j-1] = 50;
                }

            }
            if(i!=9 && j!=0)
            {
                if(inBoard[i+1][j-1]!=100)
                {
                    vBoard[i+1][j-1] = inBoard[i+1][j-1];
                    if(vBoard[i+1][j-1]==0)  vBoard[i+1][j-1] = 50;
                }
            }
        }
    }
    public void displayHidden()
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
                if(inBoard[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(inBoard[i][j]==100)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(inBoard[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
    public boolean checkResult()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                if(vBoard[i][j]==0)
                {
                    if(inBoard[i][j]!=100)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
