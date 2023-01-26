package remoteService;

public interface ShopServiceEndpoints {
    final String BASE_URL = "http://localhost:6363/shop" ;

    final String VEHICLES = "/vehicles";

    final String VEHICLES_ID = "/vehicles/{id}";
}
