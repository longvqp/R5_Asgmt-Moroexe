package nash.moroexe.services.implement;

import nash.moroexe.data.entities.ProductEntity;
import nash.moroexe.data.repositories.ProductRepository;
import nash.moroexe.dto.response.MessageResponse;
import nash.moroexe.dto.response.ProductResponseDTO;
import nash.moroexe.exceptions.ResourceNotFoundException;
import nash.moroexe.services.ProductServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplement implements ProductServices {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductServiceImplement(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductResponseDTO findProductDtoById(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Did not find product with id = " + id)
        );
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public MessageResponse deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Did not find product with id = " + id)
        );
        productRepository.deleteById(id);
        return new MessageResponse("Deleted product with id= " + id);
    }

    @Override
    public ProductResponseDTO createProduct(ProductResponseDTO productDto) {
        java.util.Date d = new java.util.Date();

        productDto.setIsActive(true);
        productDto.setCreatedDate(new java.sql.Date(d.getTime()));
        ProductEntity product = productRepository
                .save(modelMapper.map(productDto, ProductEntity.class));
        return modelMapper.map(product, ProductResponseDTO.class);

    }

    @Override
    public ProductResponseDTO updateProduct(ProductResponseDTO productDto) {
        ProductEntity product = productRepository.findById(productDto.getProductId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Did not find product has id = " + productDto.getProductId())
                );
        modelMapper.map(productDto, product);
        product = productRepository.save(product);
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> findAllProduct() {
        List<ProductEntity> products = this.productRepository.findAll();
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find any account");
        } else {
            List<ProductResponseDTO> productsDTO = new ArrayList<>();
            for (ProductEntity product : products) {
                ProductResponseDTO accountDTO = modelMapper.map(product, ProductResponseDTO.class);
                productsDTO.add(accountDTO);
            }
            return productsDTO;
        }
    }
}
