package ccs.neu.edu.andang;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;

import java.lang.Override;
import java.lang.String;
import java.sql.Date;
import java.util.Collection;

@Table(name="invoice")
@Entity(name = "INVOICE") //Name of the entity
@DiscriminatorValue("2")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class Invoice extends Grouping {

  private Date shippedOn;

  @OneToMany(mappedBy="invoice",targetEntity=Box.class,fetch=FetchType.EAGER)
  private Collection<Box> boxes;

  public Date getShippedOn() {
    return shippedOn;
  }

  public void setShippedOn(Date shippedOn) {
    this.shippedOn = shippedOn;
  }


  public Collection<Box> getBoxes() {
    return boxes;
  }

  public void setBoxes(Collection<Box> boxes) {
    this.boxes = boxes;
  }


  @Override
  public String toString() {
    return "Invoice{" +
        "shippedOn=" + shippedOn +
        '}';
  }


}
