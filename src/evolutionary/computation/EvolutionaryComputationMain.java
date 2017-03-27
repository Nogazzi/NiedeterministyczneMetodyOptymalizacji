package evolutionary.computation;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nogaz on 25.03.2017.
 */
public class EvolutionaryComputationMain {

    
    private static double sigma = 1.0d;
    private static double tau = 1.0d;
    final static int genrationsAmount = 1000;
    final static int firstPopulationSize = 40;

    public static void main(String[] args){

        simulate();
    }

    private static void simulate(){
        //generate population
        ArrayList<Individual> population = generatePopulation(firstPopulationSize);
        for( int i = 0 ; i < genrationsAmount ; ++i ){

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
        }
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

}
