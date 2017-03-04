package localsearch;

import generatory.RozkladNormalny;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class LocalSearchNormal extends LocalSearchImpl {


    public LocalSearchNormal(){
        super();
        generator = new RozkladNormalny();
    }


}
