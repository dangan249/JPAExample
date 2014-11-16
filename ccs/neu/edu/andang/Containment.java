package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;
import javax.persistence.ManyToOne;
	import javax.persistence.IdClass;
import static javax.persistence.FetchType.EAGER;
 import  static javax.persistence.CascadeType.ALL;

@Entity
@Access(AccessType.FIELD)
@IdClass(ContainmentId.class)
public class Containment {

  @Id
  public int contains;

  @Id
  public int isContainedIn;

  public int count;

  @ManyToOne(cascade=ALL, fetch=EAGER)
  @PrimaryKeyJoinColumn(name="contains", referencedColumnName="id")
  public Product product;


  @ManyToOne(cascade=ALL, fetch=EAGER)
  @PrimaryKeyJoinColumn(name="isContainedIn", referencedColumnName="id")
  public Grouping grouping;


  public Containment() {}
  public Containment(int contains, int isContainedIn, int count) {
		this.contains = contains;
		this.isContainedIn = isContainedIn;
    this.count = count;
  }

  public String toString() {
    return "Containment contains " + contains + ",isContainedIn " + isContainedIn 
    + ". count " + count;
  }
}
