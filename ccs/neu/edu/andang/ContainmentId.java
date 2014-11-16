package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.Access;
import javax.persistence.AccessType;


public class ContainmentId {
 
  private int contains;
 
  private int isContainedIn;
 
  public int hashCode() {
    return (int)(contains + isContainedIn);
  }
 
  public boolean equals(Object object) {
    if (object instanceof ContainmentId) {
      ContainmentId otherId = (ContainmentId) object;
      return (otherId.contains == this.contains) && (otherId.isContainedIn == this.isContainedIn);
    }
    return false;
  }
 
}
