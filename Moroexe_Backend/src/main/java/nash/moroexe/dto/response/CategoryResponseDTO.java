package nash.moroexe.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class CategoryResponseDTO {
    private Long id;
    @NotNull
    private String name;
    private String description;
}
