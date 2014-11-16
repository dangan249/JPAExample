package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Id;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import java.util.List;
import java.util.ArrayList;
import  static javax.persistence.FetchType.EAGER;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Access(AccessType.FIELD)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("0")

public class Grouping {

  @Id @GeneratedValue
  public int id;
  private String type;


  @OneToMany(mappedBy="grouping", fetch=EAGER)
  public List<Containment> containments = new ArrayList();

// Add an employee to the project.
  // Create an association object for the relationship and set its data.
  public void addProduct(Product product) {
    Containment association = new Containment();
    association.grouping = this;
    association.product = product;
    association.count = association.count + 1;

    association.contains = product.getId();
    association.isContainedIn = this.getId();
 
    product.containments.add(association);
    this.containments.add(association);
  }

  public Grouping() { }

  public Grouping(int id, List<Containment> containments) { 
    this.id = id;
    this.containments = containments;
  }

  public Grouping(int id, List<Containment> containments, String type) { 
    this.id = id;
                    this.type = type;

    this.containments = containments;
  }

  public Grouping(List<Containment> containments, String type) { 
    this.containments = containments;
                    this.type = type;

  }

  public String toString() {
        return "Grouping " + id;
  }

  public int getId() {
    return this.id;
  }

    public void setId(int id) {
    this.id = id;
  }

    public void setType(String type) {
    this.type = type;
  }

  public void setContainments(List<Containment> containments) {
    this.containments = containments;
  }

}
 
