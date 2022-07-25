package nash.moroexe.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter

public class CategoryRequestDTO {
    private Long id;
    @NotNull
    private String name;
    private String description;
}
