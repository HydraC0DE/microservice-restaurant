package hu.oe.yokudlela.restaurant.generated.rest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * MenuItemResponse
 */
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0")
public class MenuItemResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  @hu.oe.yokudlela.restaurant.validation.NameExists(message="error.menuitem.name.exists")
  private String name;

  @hu.oe.yokudlela.restaurant.validation.ValidOrderQuantity(message="error.quantity.invalid")
  private Integer quantity;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    MAIN_COURSE("MAIN_COURSE"),
    
    DESSERT("DESSERT"),
    
    DRINK("DRINK");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CategoryEnum category;

  private Boolean sugarFree;

  private Boolean glutenFree;

}

