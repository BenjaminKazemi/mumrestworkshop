package controllers;

import com.google.gson.Gson;
import models.Factory;
import models.Product;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class Products extends GenericController {
    public static void create( long id ) throws IOException {
        Factory f = Factory.findById( id );
        Product p = new Gson().fromJson(IOUtils.toString(request.body), Product.class);
        p.factory = f;
        p.save();

        renderJSON( new Gson().toJson(p) );
    }
}
