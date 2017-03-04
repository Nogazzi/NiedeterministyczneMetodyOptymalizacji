package localsearch;

import generatory.RozkladCauchyego;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class LocalSearchCauchy extends LocalSearchImpl {

    public LocalSearchCauchy(){
        generator = new RozkladCauchyego();
    }



}
