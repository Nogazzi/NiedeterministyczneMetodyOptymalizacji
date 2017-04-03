package funkcje.testowe;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nogaz on 03.04.2017.
 */
public class FunkcjeAckley extends FunkcjeTestowe {
    public FunkcjeAckley(int experimentsAmount) {
        super(experimentsAmount);
    }
    public ArrayList<Individual> generatePopulation(final int amountOfIndividuals){
        final RandomGenerator generator = new RozkladJednostajny();
        final ArrayList<Individual> population = new ArrayList<Individual>();
        for( int i = 0 ; i < amountOfIndividuals ; ++i ){
            Individual individual = new Individual(n);
            individual.evaluateByAckley();
            population.add(individual);
            counter++;
        }
        return population;
    }

    public ArrayList<Individual> mutatePopulation(final ArrayList<Individual> population){
        final ArrayList<Individual> mutatedPopulation = new ArrayList<Individual>();
        Random random = new Random();

        for ( int i = 0 ; i < population.size() ; ++i ) {
            if( random.nextDouble() > mutationProbability ) {
                mutatedPopulation.add(mutateIndividual(population.get(i)));
            }else{
                Individual individual = new Individual(n);
                individual.evaluateByAckley();
                mutatedPopulation.add(individual);
                counter++;
            }
        }
        return mutatedPopulation;
    }

    public Individual mutateIndividual(final Individual individual){
        Random generator = new Random();
        final Individual newIndividual;
        sigma = sigma * Math.exp(tau*generator.nextGaussian());
        if( sigma < epsilon ){
            sigma = epsilon;
        }
        newIndividual = new Individual(individual, sigma);
        newIndividual.evaluateByAckley();
        counter++;
        return newIndividual;
    }
}
