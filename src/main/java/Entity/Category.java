package Entity;

import framework.annotation.jdbc.Column;

public class Category extends AbstractEntity<Integer> {

    private String name;
    private String url;
    @Column("product_count")
    private Integer productCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return String.format("Category [id=%s, name=%s, url=%s, productCount=%s]", getId(), name, url, productCount);
    }
}
