package controllers;

import com.google.gson.Gson;
import models.Factory;
import org.apache.commons.io.IOUtils;
import play.mvc.Controller;

import java.util.List;

public class Factories extends GenericController {

    public static void list() {
        List<Factory> factories = Factory.findAll();
        renderJSON( new Gson().toJson(factories) );
    }

    public static void create() throws Exception {
        Factory factory = new Gson().fromJson(IOUtils.toString(request.body), Factory.class );
        factory.save();

        renderJSON( new Gson().toJson(factory) );
    }

    public static void update( Long id ) throws Exception {
        Factory factory = Factory.findById( id );
        Factory uFactory = new Gson().fromJson(IOUtils.toString(request.body), Factory.class );
        factory.name = uFactory.name;

        factory.save();

        renderJSON( new Gson().toJson(factory) );
    }

    public static void delete( Long id ) throws Exception {
        int count = Factory.delete("id=?", id);
        if( count == 1 ) {
            ok();
        } else {
            notFound( "Factory.id = " + id );
        }
    }

}
