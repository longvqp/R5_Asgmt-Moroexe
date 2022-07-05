package nash.moroexe.services;

import nash.moroexe.dto.response.MessageResponse;
import nash.moroexe.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductServices {
    ProductResponseDTO findProductById(Long id);
//Setting Message Respone
    MessageResponse deleteProduct(Long id);

    ProductResponseDTO createProduct(ProductResponseDTO productDto);

    ProductResponseDTO updateProduct(ProductResponseDTO productDto);

    List<ProductResponseDTO> findAllProduct();
}
