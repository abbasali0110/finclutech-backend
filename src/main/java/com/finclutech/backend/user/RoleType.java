package com.finclutech.backend.user;

public enum RoleType {

  USER("USER"),
  ADMIN("ADMIN"),
  MODERATE("MODERATE");

  private String value;

  RoleType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
