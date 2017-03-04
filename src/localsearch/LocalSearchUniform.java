package localsearch;

import generatory.RozkladJednostajny;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class LocalSearchUniform  extends LocalSearchImpl {

    public LocalSearchUniform(){
        super();
        generator = new RozkladJednostajny();
    }


}
