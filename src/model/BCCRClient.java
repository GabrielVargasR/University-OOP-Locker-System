package model;

/**
 *
 * @author Gabriel
 */
public class BCCRClient {
    
    private static BCCRClient singleton;

    private BCCRClient() {}
    
    public static BCCRClient getInstance(){
        if (singleton == null){
            singleton = new BCCRClient();
        }
        return singleton;
    }
    
    public double getCompra(){
        return 581.49;
    }
    
    public double getVenta(){
        return 586.66;
    }

}
