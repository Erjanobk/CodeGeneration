package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets userType
 */
public enum UserTypeEnum {
  EMPLOYEE("Employee"),

  CUSTOMER("Customer");

  private String value;

  UserTypeEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UserTypeEnum fromValue(String text) {
    for (UserTypeEnum b : UserTypeEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
