package nash.moroexe.services.implement;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.data.entities.CategoryEntity;
import nash.moroexe.data.repositories.CategoryRepository;
import nash.moroexe.dto.request.CategoryRequestDTO;
import nash.moroexe.dto.response.CategoryResponseDTO;
import nash.moroexe.exceptions.ResourceNotFoundException;
import nash.moroexe.services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplement implements CategoryServices {
    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImplement(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<CategoryEntity> categorys = categoryRepository.findAll();
        return modelMapper.map(categorys, new TypeToken<List<CategoryResponseDTO>>() {
        }.getType());
    }

    @Override
    public CategoryResponseDTO findCategoryById(Long id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Did not find category with id = " + id));
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO updateCategory(CategoryRequestDTO categoryDTO, Long id) {
        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.findById(id);
        if(categoryEntityOptional.isEmpty()){
            throw new ResourceNotFoundException("Can not found any account with ID= "+id);
        }else{
            CategoryEntity category = categoryEntityOptional.get();
            modelMapper.map(categoryDTO,category);
            this.categoryRepository.save(category);
            return modelMapper.map((Object) category, (Type) CategoryRequestDTO.class);
        }
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryDTO) {
        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.findById(categoryDTO.getId());

        if(categoryEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Conflicted wit category");
        }

        CategoryEntity category= categoryRepository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    @Override
    public void deleteCategory(int id) {

    }
}
