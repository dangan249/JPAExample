package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.OneToMany;
import  static javax.persistence.FetchType.EAGER;


@Entity
@Access(AccessType.FIELD)
public class Product {

  @Id @GeneratedValue
  private int id;
  private Double weight;
  private Double volume;

  @OneToMany(mappedBy="product",fetch=EAGER)
  public List<Containment> containments = new ArrayList();;

  public Product() {}
  public Product(Double weight, Double volume) {
		this.weight = weight;
		this.volume = volume;
  }

  public Product(int id, Double weight, Double volume) {
  	this.id = id;
		this.weight = weight;
		this.volume = volume;
  }

  public Product(int id, Double weight, Double volume, List<Containment> containments) {
  	this.id = id;
		this.weight = weight;
		this.volume = volume;
		this.containments = containments;
  }

  public Product(Double weight, Double volume, List<Containment> containments) {
		this.weight = weight;
		this.volume = volume;
		this.containments = containments;
  }

  public String toString() {
		return "Product " + id + " " + weight + " " + volume;
  }

  public int getId() {
  	return this.id;
  }
  
  public void setId(int id) {
  	this.id = id;
  }

  public void setContainments(List<Containment> containments) {
  	this.containments = containments;
  }
}
