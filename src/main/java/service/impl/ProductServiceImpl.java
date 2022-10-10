package service.impl;

import Entity.Category;
import Entity.Producer;
import Entity.Product;
import Form.SearchForm;
import jdbc.JDBCUtils;
import jdbc.ResultSetHandler;
import jdbc.ResultSetHandlerFactory;
import service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Exception.InternalServerErrorException;

class ProductServiceImpl implements ProductService {
    private static final ResultSetHandler<List<Product>> productsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
    private final ResultSetHandler<List<Category>> categoryListResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.CATEGORY_RESULT_SET_HANDLER);
    private final ResultSetHandler<List<Producer>> producerListResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCER_RESULT_SET_HANDLER);

    private final ResultSetHandler<Integer> countResultSetHandler = ResultSetHandlerFactory.getCountResultSetHandler();

    private final DataSource dataSource;

    public ProductServiceImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> listAllProducts(int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from my_shop.product p, my_shop.producer pr, my_shop.category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer limit ? offset ?", productsResultSetHandler, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c,
                    "select p.*, c.name as category, pr.name as producer from my_shop.product p, my_shop.category c, my_shop.producer pr where c.url=? and pr.id=p.id_producer and c.id=p.id_category order by p.id limit ? offset ?",
                    productsResultSetHandler, categoryUrl, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Category> listAllCategories() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select * from my_shop.category order by id", categoryListResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Producer> listAllProducers() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select * from my_shop.producer order by id", producerListResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from my_shop.product p, my_shop.producer pr, my_shop.category c "
                    + "where (p.name ilike ? or p.description ilike ?) and c.id=p.id_category and pr.id=p.id_producer limit ? offset ?",
                    productsResultSetHandler, "%"+searchForm.getQuery()+"%", "%"+searchForm.getQuery()+"%", limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countProductsBySearchForm(SearchForm searchForm) {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select count(*) from my_shop.product p, my_shop.producer pr, my_shop.category c "
                            + "where (p.name ilike ? or p.description ilike ?) and c.id=p.id_category and pr.id=p.id_producer",
                    countResultSetHandler, "%"+searchForm.getQuery()+"%", "%"+searchForm.getQuery()+"%");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countAllProducts() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "select count(*) from my_shop.product", countResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countProductsByCategory(String categoryUrl) {
        return 0;
    }

    /**  @Override public List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit) {
    try (Connection c = dataSource.getConnection()) {
    int offset = (page - 1) * limit;
    return JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
    + "where (p.name ilike ? or p.description ilike ?) and c.id=p.id_category and pr.id=p.id_producer limit ? offset ?",
    productsResultSetHandler, "%"+searchForm.getQuery()+"%", "%"+searchForm.getQuery()+"%", limit, offset);
    } catch (SQLException e) {
    throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
    }
    }

     @Override public int countProductsBySearchForm(SearchForm searchForm) {
     try (Connection c = dataSource.getConnection()) {
     return JDBCUtils.select(c, "select count(*) from product p, producer pr, category c "
     + "where (p.name ilike ? or p.description ilike ?) and c.id=p.id_category and pr.id=p.id_producer",
     countResultSetHandler, "%"+searchForm.getQuery()+"%", "%"+searchForm.getQuery()+"%");
     } catch (SQLException e) {
     throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
     }
     }
     */

}