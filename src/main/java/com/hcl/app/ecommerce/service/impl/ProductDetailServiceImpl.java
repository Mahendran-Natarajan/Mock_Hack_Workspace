package com.hcl.app.ecommerce.service.impl;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.exception.ProductNotFoundException;
import com.hcl.app.ecommerce.repository.ProductDetailRepository;
import com.hcl.app.ecommerce.repository.ProductRatingDetailRepository;
import com.hcl.app.ecommerce.service.ProductDetailService;
import com.hcl.app.ecommerce.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Product detail service.
 *
 * @author manatara
 * @version 1.0
 * @since 27 -11-2019
 */
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRatingDetailRepository productRatingDetailRepository;

    /**
     * Gets product.
     *
     * @param productId the product id
     * @return the product
     * @throws ProductNotFoundException the product not found exception
     */
    @Override
    public ProductDetail getProduct(String productId) throws ProductNotFoundException {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(Long.parseLong(productId));
        if (productDetail.isPresent()) {
            return productDetail.get();
        } else {
            throw new ProductNotFoundException(Constant.PRODUCT_NOT_FOUND);
        }
    }

    /**
     * Gets store ratings.
     *
     * @param productId the product id
     * @return the store ratings
     */
    @Override
    public List<RatingPojo> getStoreRatings(Long productId) {
        return this.productRatingDetailRepository.viewRatingsByStoreProduct(productId);

    }

    /**
     * Gets product by name.
     *
     * @param productName the product name
     * @return the product by name
     */
    @Override
    public List<ProductDetail> getProductByName(String productName) {
        return this.productDetailRepository.findAllByProductNameContains(productName);
    }

    /**
     * Save product details api response.
     *
     * @param productDetails the product details
     * @return the api response
     */
    @Override
    public ApiResponse saveProductDetails(ProductDetail productDetails) {
        productDetailRepository.save(productDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

}
