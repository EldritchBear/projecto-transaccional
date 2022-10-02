public class RegionException extends Exception {
    public RegionException() {
        super("La región introducida no existe");
    }
}