package evolutionary.computation;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nogaz on 25.03.2017.
 */
public class EvolutionaryComputationMain {

    
    private static double sigma = 1.0d;
    private static double tau = 1.0d;
    final static int generationsAmount = 1000;
    final static int populationSize = 40;

    public static void main(String[] args){

        simulate();
    }

    private static void simulate(){
        //generate population
        ArrayList<Individual> population = generatePopulation(populationSize);
        double[] results = new double[generationsAmount];
        for( int i = 0 ; i < generationsAmount ; ++i ){

            //recombinate population - weź tych lepszych
            ArrayList<Individual> selectedPopulation = selectPopulation(population);
            //mutate selected - stworz potomkow wybrancow
            ArrayList<Individual> mutatedPopulation = mutatePopulation(selectedPopulation);
            //populacja wybranych i ich potomkow
            ArrayList<Individual> newPopulation = new ArrayList<Individual>();
            newPopulation.addAll(selectedPopulation);
            newPopulation.addAll(mutatedPopulation);

            //replace population
            population = newPopulation;
            results[i] = 0;
            for( int j = 0 ; j < populationSize ; ++j ){
                results[i] += population.get(j).getResult();
            }
        }
        saveArray(results, "evolutionaryComputation.txt");

    }

    private static ArrayList<Individual> generatePopulation(final int amountOfIndividuals){
        final RandomGenerator generator = new RozkladJednostajny();
        final ArrayList<Individual> population = new ArrayList<Individual>();
        for( int i = 0 ; i < amountOfIndividuals ; ++i ){
            population.add(new Individual(generator.getRandomDouble()*5, generator.getRandomDouble()*5));
        }
        return population;
    }

    private static ArrayList<Individual> recombinatePopulation(final ArrayList<Individual> population){
        for( int i = 0 ; i < population.size() ; i++ ){
            population.get(i);
        }
        return null;
    }

    private static ArrayList<Individual> selectPopulation(final ArrayList<Individual> population){
        final ArrayList<Individual> newPopulation = new ArrayList<Individual>();
        for( int i = 0 ; i < population.size() ; i+=2 ){
            if( population.get(i).getResult() < population.get(i+1).getResult() ){
                newPopulation.add(population.get(i));
            }else{
                newPopulation.add(population.get(i+1));
            }
        }
        return newPopulation;
    }

    private static ArrayList<Individual> mutatePopulation(final ArrayList<Individual> population){
        final ArrayList<Individual> mutatedPopulation = new ArrayList<Individual>();
        for ( Individual individual: population) {
            mutatedPopulation.add(mutateIndividual(individual));
        }
        return mutatedPopulation;
    }

    private static Individual mutateIndividual(final Individual individual/*, final double sigma*/){
        Random generator = new Random();
        final Individual newIndividual;
        sigma = sigma * Math.exp(tau*generator.nextGaussian());
        double newX1 = individual.getX1() + generator.nextGaussian()*sigma;
        double newX2 = individual.getX2() + generator.nextGaussian()*sigma;
        newIndividual = new Individual(newX1, newX2);
        return newIndividual;
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

}
