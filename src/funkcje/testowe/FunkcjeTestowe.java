package funkcje.testowe;

import evolutionary.computation.*;
import evolutionary.computation.Individual;
import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class FunkcjeTestowe {
    private final int experimentsAmount;
    private final int terminationCondition = 1000;
    private final int populationSize = 40;
    private final double mutationProbability = 0.7d;
    private double sigma = 0.8d;
    private final double epsilon = 0.002d;
    private double tau = 0.01d;

    private int counter;

    private ArrayList<Individual> population;
    private final ArrayList<Double> results = new ArrayList<Double>();

    public FunkcjeTestowe(int experimentsAmount){
        this.experimentsAmount = experimentsAmount;
    }

    public void doSimulation(){
        counter = 0;
        population = generatePopulation(populationSize);
        while( counter < terminationCondition ){

            //selection
            ArrayList<evolutionary.computation.Individual> selectedPopulation = selectPopulation(population);
            //recombination

            //mutation
            ArrayList<evolutionary.computation.Individual> mutatedPopulation = mutatePopulation(selectedPopulation);
            //new population
            population = new ArrayList<evolutionary.computation.Individual>();
            population.addAll(selectedPopulation);
            population.addAll(mutatedPopulation);
            //get result
            results.add(getPopulationBestResult(population));

        }
    }

    private ArrayList<Individual> generatePopulation(final int amountOfIndividuals){
        final RandomGenerator generator = new RozkladJednostajny();
        final ArrayList<Individual> population = new ArrayList<Individual>();
        for( int i = 0 ; i < amountOfIndividuals ; ++i ){
            population.add(new Individual(generator.getRandomDouble()*5, generator.getRandomDouble()*5));
            counter++;
        }
        return population;
    }

    private ArrayList<Individual> selectPopulation(final ArrayList<Individual> population){
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

    private ArrayList<Individual> mutatePopulation(final ArrayList<Individual> population){
        final ArrayList<Individual> mutatedPopulation = new ArrayList<Individual>();
        Random random = new Random();

        for ( int i = 0 ; i < population.size() ; ++i ) {
            if( random.nextDouble() > mutationProbability ) {
                mutatedPopulation.add(mutateIndividual(population.get(i)));
            }else{
                mutatedPopulation.add(new Individual(random.nextDouble()*10-5, random.nextDouble()*10-5));
                counter++;
            }
        }
        return mutatedPopulation;
    }

    private Individual mutateIndividual(final Individual individual/*, final double sigma*/){
        Random generator = new Random();
        final Individual newIndividual;
        sigma = sigma * Math.exp(tau*generator.nextGaussian());
        if( sigma < epsilon ){
            sigma = epsilon;
        }
        double newX1 = individual.getX1() + generator.nextGaussian()*sigma;
        double newX2 = individual.getX2() + generator.nextGaussian()*sigma;
        newIndividual = new Individual(newX1, newX2);
        counter++;
        return newIndividual;
    }

    private double getPopulationBestResult(final ArrayList<Individual> population){
        double result = population.get(0).getResult();
        for (Individual individual: population) {
            if( individual.getResult() < result ){
                result = individual.getResult();
            }
        }
        return result;
    }

    public ArrayList<Double> getExperimentResult(){
        return results;
    }
}
