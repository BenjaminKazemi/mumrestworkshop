package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends Model {
    public String name;
    @ManyToOne
    public models.Factory factory;
}
