package controllers;

import play.Logger;
import play.mvc.Before;
import play.mvc.Controller;

public class GenericController extends Controller {

    @Before
    public static void log() {
        Logger.info( "Accessing " + request.method + " " + request.action + " {" + request.url +"}" );
    }

}
