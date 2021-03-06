package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Deposit
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-27T13:17:09.505Z[GMT]")


public class Deposit   {
  @JsonProperty("DepositAmount")
  private Integer depositAmount = null;

  public Deposit depositAmount(Integer depositAmount) {
    this.depositAmount = depositAmount;
    return this;
  }

  /**
   * Get depositAmount
   * @return depositAmount
   **/
  @Schema(example = "20", required = true, description = "")
      @NotNull

    public Integer getDepositAmount() {
    return depositAmount;
  }

  public void setDepositAmount(Integer depositAmount) {
    this.depositAmount = depositAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) o;
    return Objects.equals(this.depositAmount, deposit.depositAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(depositAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Deposit {\n");
    
    sb.append("    depositAmount: ").append(toIndentedString(depositAmount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
