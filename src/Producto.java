public class Producto {

    //2-ATRIBUTOS
    private int idProducto;
    private String nombreProducto;
    private String categoria;
    double precio;
    private int cantidadDisponible;

    //3-CONSTRUCTOR
        public Producto (int idProducto, String nombreProducto, String categoria, double precio, int cantidadDisponibl) {

            this.idProducto = idProducto;
            this.nombreProducto = nombreProducto;
            this.categoria = categoria;
            this.precio = precio;
            this.cantidadDisponible = cantidadDisponible;
    }
    public Producto(){
    }
    //4-METODOS GETTER-SETTER

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
        public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}

