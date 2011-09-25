package com.firetruckbowl.apisample.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Starship")
@XmlAccessorType(XmlAccessType.FIELD)
public class Starship {

  @XmlElement(name = "Id")
  private String id;

  @XmlElement(name = "Name")
  private String name;

  @XmlElement(name = "Model")
  private String model;

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
