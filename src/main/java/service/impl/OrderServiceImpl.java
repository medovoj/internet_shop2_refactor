package service.impl;

import Entity.Product;
import Form.ProductForm;
import Model.ShoppingCart;
import jdbc.JDBCUtils;
import jdbc.ResultSetHandler;
import jdbc.ResultSetHandlerFactory;
import service.OrderService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import Exception.InternalServerErrorException;

class OrderServiceImpl implements OrderService {
    private static final ResultSetHandler<Product> productResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);


    private final DataSource dataSource;

    public OrderServiceImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart) {
        try (Connection c = dataSource.getConnection()) {
            Product product = JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from my_shop.product p, my_shop.producer pr, my_shop.category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer and p.id=?", productResultSetHandler, productForm.getIdProduct());
            if(product == null) {
                throw new InternalServerErrorException("Product not found by id="+productForm.getIdProduct());
            }
            shoppingCart.addProduct(product, productForm.getCount());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }



}

