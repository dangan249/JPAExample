package ccs.neu.edu.andang;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;


@Table(name="box")
@Entity(name = "BOX") //Name of the entity
@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class Box extends Grouping {

  private Double maximumWeight;
  private Double volume;
  private int fulfills;

  @ManyToOne(optional=false)
  @JoinColumn(name="fulfills",referencedColumnName="id")
  private Invoice invoice;

  public Double getMaximumWeight() {
    return maximumWeight;
  }

  public void setMaximumWeight(Double maximumWeight) {
    this.maximumWeight = maximumWeight;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public int getFulfills() {
    return fulfills;
  }

  public void setFulfills(int fulfills) {
    this.fulfills = fulfills;
  }


  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  @Override
  public String toString() {
    return "Box{" +
        "maximumWeight=" + maximumWeight +
        ", volume=" + volume +
        ", fulfills=" + fulfills +
        '}';
  }
}
