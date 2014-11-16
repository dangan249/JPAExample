package ccs.neu.edu.andang;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Override;
import java.lang.String;

@Entity(name = "CONTAINMENT")
@IdClass(ContainmentId.class)
public class Containment implements Serializable {

  @Id
  @Column(name = "contains", nullable = false)
  private int contains;

  @Id
  @Column(name = "isContainedIn", nullable = false)
  private int isContainedIn;

  @Column(name = "count")
  public int count;

  @ManyToOne(optional=false)
  @JoinColumn(name="contains",referencedColumnName="id")
  private Product product;

  @ManyToOne(optional=false)
  @JoinColumn(name="isContainedIn",referencedColumnName="id")
  private Grouping grouping;

  public int getContains() {
    return contains;
  }

  public void setContains(int contains) {
    this.contains = contains;
  }

  public int getIsContainedIn() {
    return isContainedIn;
  }

  public void setIsContainedIn(int isContainedIn) {
    this.isContainedIn = isContainedIn;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Grouping getGrouping() {
    return grouping;
  }

  public void setGrouping(Grouping grouping) {
    this.grouping = grouping;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Containment{" +
        "contains=" + contains +
        ", isContainedIn=" + isContainedIn +
        ", count=" + count
        ;
  }
}
