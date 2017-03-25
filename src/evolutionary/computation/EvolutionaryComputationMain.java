package evolutionary.computation;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.util.ArrayList;

/**
 * Created by Nogaz on 25.03.2017.
 */
public class EvolutionaryComputationMain {

    public final int firstPopulationSize = 40;
    public final RandomGenerator generator = new RozkladJednostajny();

    public static void main(String[] args){
        ArrayList<Individual> population = new ArrayList<Individual>();

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
        for( int i = 0 ; i < population.size() ; ++i ){
            population.get(i);
        }
    }
}
