package ccs.neu.edu.andang;

import javax.persistence.Entity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import java.lang.Override;


public class ContainmentId {
 
  private int contains;
 
  private int isContainedIn;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContainmentId that = (ContainmentId) o;

    if (contains != that.contains) return false;
    if (isContainedIn != that.isContainedIn) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = contains;
    result = 31 * result + isContainedIn;
    return result;
  }
}
