package ccs.neu.edu.andang;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;

import javax.persistence.OneToMany;
import java.util.Collection;

@Entity(name = "PRODUCT")
public class Product implements Serializable {

  @Id //signifies the primary key
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "weight")
  private Double weight;

  @Column(name = "volume")
  private Double volume;

  @OneToMany(mappedBy="product",targetEntity=Containment.class,fetch=FetchType.EAGER)
  private Collection<Containment> containments;


  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Collection<Containment> getContainments() {
    return containments;
  }

  public void setContainments(Collection<Containment> containments) {
    this.containments = containments;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", weight=" + weight +
        ", volume=" + volume +
        ", containments=" + containments +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    if (id != product.id) return false;
    if (containments != null ? !containments.equals(product.containments) : product.containments != null) return false;
    if (volume != null ? !volume.equals(product.volume) : product.volume != null) return false;
    if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (weight != null ? weight.hashCode() : 0);
    result = 31 * result + (volume != null ? volume.hashCode() : 0);
    result = 31 * result + (containments != null ? containments.hashCode() : 0);
    return result;
  }
}
