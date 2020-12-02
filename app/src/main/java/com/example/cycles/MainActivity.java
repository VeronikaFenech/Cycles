package com.example.cycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int[] ints = {1, 2, 3, 4, 5};
    long[] longs = {0, 1, 2, 3, 4, 5, 6};
    long[] longs1 = new long[2];
    String[] strings = new String[10];
    int[] arr1 = {1, 1, 1, 1, 1};
    int[] arr2 = {2, 2, 2, 2, 2};
    int[][] arrays = new int[5][5];
    int[][][] z = new int[2][2][2];
    int bricks1 = 13;
    int bricks2 = 4;
    int bricks3 = 2;
    int bricks4 = 1;


    int[] ints100 = new int[100];
    Integer[] ints10 = new Integer[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        System.out.println("Размер ints: "+ints.length);
        System.out.println("Размер longs1: "+longs.length);
        //Вывод всего массива
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(longs1));

        int i=ints[2];
        System.out.println(i);
        //запись в массив
        ints[2]=123;
        System.out.println(ints[2]);
        */
        //write();
        //randomNum();





        /*sorted1();
        System.out.println(Arrays.toString(ints100));
        sorted2();
        System.out.println(Arrays.toString(ints100));
         */
        //System.out.println(Arrays.toString(arrays));
        //printWall(createWall(5, 8));
        //check((createWall(5, 8)), bricks1, bricks2, bricks3, bricks4);
        //four3extr(createWall(5, 8), 3);
        //four3(createWall(5, 8), bricks4, bricks3, bricks2, 4);
        //System.out.println((int)Math.round(Math.random()));

    }

    void cycle1() {
        for (int i = 1; i <= 100; i++) {
            //начало с 0
            //100 раз пройдет цикл
            //каждый раз прибавляем к i 1
            System.out.println("Number:" + i);
        }
    }

    void threeFive() {
        for (int i = 0; i <= 200; i += 3) {
            if (i % 5 == 0) {
                System.out.println("Number:" + i);
            }
        }
    }

    void para() {
        for (int i = 0; i <= 200; i += 2) {
            System.out.println("Number:" + i);
        }
    }

    void cycle3() {
        int i = 0;
        while (i < 100) {
            System.out.println("Number:" + i);
            i++;
        }

    }

    void cycle4() {
        int i = 0;
        do {
            System.out.println("Number:" + i);
            i++;
        } while (i < 100);

    }

    void threeFive2() {
        int i = 0;
        while (i < 100) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Number:" + i);
            }
            i++;
        }
    }

    void threeFive3() {
        int i = 0;
        do {
            i++;
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Number:" + i);
            }
        } while (i < 100);
    }

    void write() {
        for (int i = 0; i < 100; i++) {
            ints100[i] = i + 1;
        }
    }

    void randomNum() {
        for (int i = 0; i < 100; i++) {
            ints100[i] = (int) (Math.random() * 100);
        }
    }


    void sorted1() {
        randomNum();
        Arrays.sort(ints100);

    }

    void sorted2() {
        randomNum();
        Arrays.sort(ints100);
        for (int i = 0; i < 100; i++) {
            ints100[i] = ints100[99 - i];

        }


    }

    int[][] createWall(int height, int width) {
        int[][] temp = new int[height][width];
        for (int i = 0; i < temp.length; i++) {
            for (int z = 0; z < temp[i].length; z++) {
                temp[i][z] = (int) Math.round(Math.random() + 0.2);
            }
        }
        return temp;
    }

    void printWall(int[][] wall) {
        String s = "";
        for (int i = 0; i < wall.length; i++) {
            for (int z = 0; z < wall[i].length; z++) {
                s += String.valueOf(wall[i][z]);
            }
            s += "\n\n";
        }
        System.out.println(s);


    }

    void four3extr(int[][] wall, int a) {
        //System.out.println("new");
        int b = 0;
        printWall(wall);
        System.out.println(a + "num");
        // for (int x;x!=dif;x++){
        for (int i = 0; i < wall[i].length; i++) {
            b = 0;

            for (int z = 0; z < wall.length; z++) {
                /*System.out.println("prom");
                System.out.println(wall[z-1][i]+"prom");
                System.out.println("prom");
                System.out.println(wall[z][i]+"prom");*/
                //System.out.print(wall[z][i]);
                if (wall[z][i] == 1) {
                    b++;

                    if (a == b) {
                        wall[z][i] = 9;
                        // System.out.println(wall[z][i] + "p");
                        wall[z - 1][i] = 9;
                        // printWall(wall);
                        //  System.out.println(wall[z - 1][i] + "o");
                        wall[z - a + 1][i] = 9;
                        wall[Math.round(((z - 1) - (z - a + 1)) / 2) + (z - a + 1)][i] = 9;

                        if (a == 2) {
                            printWall(wall);
                            System.out.println("true");
                            System.exit(0);
                        } else {
                            printWall(wall);
                            //System.exit(0);
                            four3(wall, bricks4, bricks3, bricks2, (a - 1));
                        }


                    }
                } else {
                    b = 0;

                }


            }
            if (i == wall.length-1 && a != b) {
                System.out.println("not found");
                four3(wall, bricks4, bricks3, bricks2, (a - 1));
            }
            //System.out.println("|");

        }
    }


    boolean four3(int[][] wall, int bricks4, int bricks3, int bricks2, int a) {
        int b = 0;
        int c = 0;
        int v = 0;
        boolean in = false;
        // printWall(wall);
        System.out.println("start");
        if (a==1){
            System.out.println("false");
            System.exit(0);
        }
        for (int i = 0; i < wall.length; i++) {
            b = 0;
            for (int z = 0; z < wall[i].length; z++) {
                if (wall[i][z] == 1) {
                    b++;
                    if (b == a) {
                        wall[i][z] = 9;
                        wall[i][z - 1] = 9;
                        wall[i][z - a + 1] = 9;
                        wall[i][Math.round(((z - 1) - (z - a + 1)) / 2 + (z - a + 1))] = 9;
                        if (a == 3) {

                            c++;
                            if (c == bricks3) {
                                four3(wall, bricks4, bricks3, bricks2, 2);
                                printWall(wall);
                            }
                        }
                        if (a == 4) {
                            c++;
                            if (c == bricks4) {
                                four3(wall, bricks4, bricks3, bricks2, 3);
                                printWall(wall);
                            }

                        }
                        if (a == 2) {
                            c++;
                            if (c == bricks2) {
                                printWall(wall);
                                System.out.println("true");
                                System.exit(0);

                            }

                        }

                    }

                }
                if (wall[i][z] != 1) {
                    b = 0;

                }


            }
            if (i == wall.length - 1 && a != b) {
                for (int l = 0; l < wall.length; l++) {
                    for (int m = 0; m < wall[l].length; m++) {
                        v += wall[l][m];
                    }
                }
                if (v >= bricks1) {
                    four3extr(wall, a);
                } else {
                    printWall(wall);
                    System.out.println("true");
                    System.exit(0);
                }
            }

            //метод

        }
        //System.out.println("false");dont
        return false;
    }

    void check(int[][] wall, int bricks1, int bricks2, int bricks3, int bricks4) {
        int a = 0;
        boolean check1 = false;
        for (int i = 0; i < wall.length; i++) {
            for (int z = 0; z < wall[i].length; z++) {
                a += wall[i][z];

            }
        }
        float b = ((bricks1 + (bricks2 * 2) + (bricks3 * 3) + (bricks4 * 4)) / a);
        System.out.println(b);

        if (b >= 1) {
            check1 = true;

        }

        printWall(wall);
        if (check1) {
            four3(wall, bricks4, bricks3, bricks2, 4);
            ;


        } else {
            System.out.println(check1);
        }

    }
}



