package service.impl;

import Entity.Account;
import Entity.Product;
import Form.ProductForm;
import Model.CartItem;
import Model.CurrentAccount;
import Model.ShoppingCart;
import Model.SocialAccount;
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
    private static final ResultSetHandler<Account> accountResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.ACCOUNT_RESULT_SET_HANDLER);


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

    @Override
    public void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart) {
            shoppingCart.removeProduct(form.getIdProduct(), form.getCount());
        }



    @Override
    public String serializeShoppingCart(ShoppingCart shoppingCart) {
        StringBuilder res = new StringBuilder();
        for (CartItem item : shoppingCart.getItems()) {
            res.append(item.getProduct().getId()).append("-").append(item.getCount()).append("|");
        }
        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    @Override
    public ShoppingCart deserializeShoppingCart(String string) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = string.split("\\|");
        for (String item : items) {
            try {
                String data[] = item.split("-");
                int idProduct = Integer.parseInt(data[0]);
                int count = Integer.parseInt(data[1]);
                addProductToShoppingCart(new ProductForm(idProduct, count), shoppingCart);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return shoppingCart.getItems().isEmpty() ? null : shoppingCart;
    }

    @Override
    public CurrentAccount authenticate(SocialAccount socialAccount) {
        try (Connection c = dataSource.getConnection()) {
            Account account = JDBCUtils.select(c, "select * from my_shop.account where email=?", accountResultSetHandler, socialAccount.getEmail());
            if (account == null) {
                account = new Account(socialAccount.getName(), socialAccount.getEmail());
                account = JDBCUtils.insert(c, "insert into account values (nextval('account_seq'),?,?)", accountResultSetHandler, account.getName(), account.getEmail());
                c.commit();
            }
            return account;
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
