package funkcje.testowe;

import java.util.ArrayList;

/**
 * Created by Nogaz on 03.04.2017.
 */
public interface FunkcjeTestoweInterface {
    public ArrayList<Individual> generatePopulation(final int amountOfIndividuals);
    public Individual mutateIndividual(Individual individual);
    public ArrayList<Individual> mutatePopulation(final ArrayList<Individual> population);
    public ArrayList<Individual> selectPopulation(final ArrayList<Individual> population);
    public void doSimulation(final int n, final int terminationCondition);
    public double getPopulationBestResult();
}
