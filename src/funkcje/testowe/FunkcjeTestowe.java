package funkcje.testowe;


import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Nogaz on 02.04.2017.
 */
public abstract class FunkcjeTestowe implements FunkcjeTestoweInterface{
    private final int experimentsAmount;
    private final int terminationCondition = 1000;
    private final int populationSize = 40;
    protected final double mutationProbability = 0.7d;
    protected double sigma = 0.8d;
    protected final double epsilon = 0.002d;
    protected double tau = 0.01d;

    protected int counter;

    protected int n;

    protected double ackleyBound = 32.768d;
    protected double levyBound = 10.0d;
    protected double whitleyBound = 10.24d;

    protected ArrayList<Individual> population;


    private double bestResult;

    public FunkcjeTestowe(int experimentsAmount){
        this.experimentsAmount = experimentsAmount;
    }

    public void doSimulation(final int n){
        this.n = n;
        counter = 0;
        population = generatePopulation(populationSize);
        while( counter < terminationCondition ){

            //selection
            ArrayList<Individual> selectedPopulation = selectPopulation(population);
            //recombination

            //mutation
            ArrayList<Individual> mutatedPopulation = mutatePopulation(selectedPopulation);
            //new population
            population = new ArrayList<Individual>();
            population.addAll(selectedPopulation);
            population.addAll(mutatedPopulation);
            Collections.shuffle(population);
            //get result
        }
        bestResult = getPopulationBestResult();
    }


    public ArrayList<Individual> selectPopulation(final ArrayList<Individual> population){
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

    public double getBestResult(){
        return bestResult;
    }



    public double getPopulationBestResult(){
        double result = population.get(0).getResult();
        for (Individual individual: population) {
            if( individual.getResult() < result ){
                result = individual.getResult();
            }
        }
        return result;
    }

}
