package Constants;

public final class Constants {

    public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";

    public static final int MAX_PRODUCTS_CART_CAPACITY = 20;

    public static final int MAX_PRODUCTS_COUNT = 10;

    public static final String ACCOUNT_ACTIONS_HISTORY = "ACCOUNT_ACTIONS_HISTORY";



    public enum Cookie {
        SHOPPING_CART("cc", 60 * 60 * 24 * 365);

        private final String name;
        private final int ttl;

        public int getTtl() {
            return ttl;
        }

        public String getName() {
            return name;
        }

        Cookie(String name, int ttl) {
            this.name = name;
            this.ttl = ttl;
        }
    }
}
