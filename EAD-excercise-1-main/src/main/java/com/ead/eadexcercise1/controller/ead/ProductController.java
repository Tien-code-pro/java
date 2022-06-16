package com.ead.eadexcercise1.controller.ead;

import com.ead.eadexcercise1.dto.ProductDTO;
import com.ead.eadexcercise1.entity.ead.Product;
import com.ead.eadexcercise1.entity.ead.enums.ProductSimpleStatus;
import com.ead.eadexcercise1.repository.ead.ProductRepository;
import com.ead.eadexcercise1.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/ead-products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSlug(StringHelper.toSlug(productDTO.getSlug()));
        product.setStatus(ProductSimpleStatus.ACTIVE);
        productRepository.save(product);
        productDTO.setId(product.getId());
        productDTO.setCreatedAt(product.getCreatedAt() == null ? "" : product.getCreatedAt().toString());
        productDTO.setUpdatedAt(product.getUpdatedAt() == null ? "" : product.getUpdatedAt().toString());
        productDTO.setStatus(product.getStatus().name());
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
