package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.DiscriminatorValue;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Access(AccessType.FIELD)
@DiscriminatorValue("2")

public class Invoice extends Grouping {

  public Invoice() {}
  public Invoice(Date shippedOn) {
  	this.shippedOn = shippedOn;
  }

  private Date shippedOn;

  public String toString() {
		return "Invoice " + id + " " + shippedOn
				+ "\n" + super.toString();
  }
}
