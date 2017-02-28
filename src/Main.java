import com.sun.javafx.binding.StringFormatter;
import generatory.RandomGenerator;
import generatory.RozkladCauchyego;
import generatory.RozkladJednostajny;
import generatory.RozkladNormalny;

import java.io.*;
import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class Main {

    public static void main(String[] args){
        int iloscLiczb = 1000;
        RandomGenerator generator;

        generator = new RozkladNormalny();
        double[] rozkladNormalny = new double[iloscLiczb];
        for (int i = 0 ; i < rozkladNormalny.length ; ++i ) {
            rozkladNormalny[i] = generator.getRandomDouble();
        }
        saveArray(rozkladNormalny, "rozkladNormalny.txt");


        generator = new RozkladJednostajny();
        double[] rozkladJednostajny = new double[iloscLiczb];
        for (int i = 0 ; i < rozkladJednostajny.length ; ++i ) {
            rozkladJednostajny[i] = generator.getRandomDouble();
        }
        saveArray(rozkladJednostajny, "rozkladJednostajny.txt");



        generator = new RozkladCauchyego();
        double[] rozkladCauchyego = new double[iloscLiczb];
        for (int i = 0 ; i < rozkladCauchyego.length ; ++i ) {
            rozkladCauchyego[i] = generator.getRandomDouble();
        }
        saveArray(rozkladCauchyego, "rozkladCauchyego.txt");

    }


    public static void saveArray(double[] array, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for (double line: array) {
                //System.out.println(line);
                bw.println(String.format("%.8f", line));
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveArray(int[] array, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for (double line: array) {
                //System.out.println(line);
                bw.println(line);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
