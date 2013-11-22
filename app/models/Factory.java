package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Factory extends Model {
    public String name;
}
