package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.DiscriminatorValue;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Access(AccessType.FIELD)
@DiscriminatorValue("1")

public class Box extends Grouping {

  private Double maximumWeight;
  private Double volume;
  private int fulfills;

  public Box() {}
  public Box(Double maximumWeight, Double volume,int fulfills) {
		this.maximumWeight = maximumWeight;
		this.volume = volume;
		this.fulfills = fulfills;
  }
  public String toString() {
		return "Box " + id + " " + maximumWeight + " " + volume + " " + fulfills 
		+ "\n" + super.toString();
  }
}
