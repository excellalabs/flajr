package com.excella.flajr.domain;

public class Variant {
  private int id;
  private String key;
  private Object attachment;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Object getAttachment() {
    return attachment;
  }

  public void setAttachment(Object attachment) {
    this.attachment = attachment;
  }
}