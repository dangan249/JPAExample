package ccs.neu.edu.andang;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;

@Table(name="grouping")
@Entity(name = "GROUPING")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING,length=1)
@DiscriminatorValue("0")

public class Grouping implements Serializable {

  @Id //signifies the primary key
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "type", length = 1)
  private String type;

  @OneToMany(mappedBy="grouping",targetEntity=Containment.class,fetch=FetchType.EAGER)
  private Collection<Containment> containments;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Grouping{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", containments=" + containments +
        '}';
  }
}
 
