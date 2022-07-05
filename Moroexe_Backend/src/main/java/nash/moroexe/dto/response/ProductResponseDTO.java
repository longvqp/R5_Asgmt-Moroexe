package nash.moroexe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class ProductResponseDTO {
    private Long productId;
    private String name;
    private String description;
    private double rating;
    private int price;
    private int size;
    private int stock;
    private Date createdDate;
    private Boolean isActive;
    private String image;
}
