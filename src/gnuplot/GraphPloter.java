package gnuplot;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.plot.Graph;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.terminal.ImageTerminal;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class GraphPloter {


    public static void createGraph(double[][] resultsTab, String graphName){



        //zapis do pliku
        ImageTerminal png = new ImageTerminal();
        File file = new File("C:\\Users\\Nogaz\\NiedeterministyczneMetodyOptymalizacji\\" + graphName + ".png");
        try{
            file.createNewFile();
            png.processOutput(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaPlot p = new JavaPlot("C:\\Program Files (x86)\\gnuplot\\bin/gnuplot.exe");
        p.setTerminal(png);
        p.getAxis("x").setLabel("step");
        p.getAxis("x").setBoundaries(1,1000);
        p.getAxis("y").setLabel("value");
        p.getAxis("y").setBoundaries(0,200);
        DataSetPlot[] dataSetPlot = new DataSetPlot[resultsTab.length];
        for( int i = 0 ; i < 7/*resultsTab.length*/ ; ++i ){
            dataSetPlot[i] = new DataSetPlot( createDataSet(resultsTab[i]));
            PlotStyle plotStyle = new PlotStyle();
            plotStyle.setLineType(i);

            p.addPlot(dataSetPlot[i]);
        }
        /*
        dataSetPlot[0] = new DataSetPlot( createDataSet(resultsTab[0]));
        PlotStyle plotStyle = new PlotStyle();
        plotStyle.setLineType(0);

        p.addPlot(dataSetPlot[0]);*/
        p.setTitle(graphName);
        p.plot();

        try{
            ImageIO.write(png.getImage(), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createGraph(double[] resultsTab, String graphName){



        //zapis do pliku
        ImageTerminal png = new ImageTerminal();
        File file = new File("C:\\Users\\Nogaz\\NiedeterministyczneMetodyOptymalizacji\\" + graphName + ".png");
        try{
            file.createNewFile();
            png.processOutput(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaPlot p = new JavaPlot("C:\\Program Files (x86)\\gnuplot\\bin/gnuplot.exe");
        p.setTerminal(png);
        p.getAxis("x").setLabel("step");
        p.getAxis("x").setBoundaries(1,1000);
        p.getAxis("y").setLabel("value");
        p.getAxis("y").setBoundaries(0,20000);
        DataSetPlot dataSetPlot = new DataSetPlot( createDataSet(resultsTab) );
        PlotStyle plotStyle = new PlotStyle();
        plotStyle.setLineType(1);

        p.addPlot(dataSetPlot);

        /*
        dataSetPlot[0] = new DataSetPlot( createDataSet(resultsTab[0]));
        PlotStyle plotStyle = new PlotStyle();
        plotStyle.setLineType(0);

        p.addPlot(dataSetPlot[0]);*/
        p.setTitle(graphName);
        p.plot();

        try{
            ImageIO.write(png.getImage(), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static double[][] createDataSet(double[] data){
        double[][] dataSet = new double[data.length][2];
        for(int i = 0 ; i < data.length ; ++i ){
            dataSet[i][0] = i+1;
            dataSet[i][1] = data[i];
        }
        return dataSet;
    }

}
