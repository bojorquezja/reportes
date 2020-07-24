package pe.edu.utp.reportes.dto;

public class ReciboDatos {
    private String empresa;
    private String direccion;
    private String codigo;
    private int item;
    private String producto;
    private int cantidad;
    private double precio;
    private double subTotal;

    public ReciboDatos(String empresa, String direccion, String codigo, int item, String producto, int cantidad, double precio, double subTotal) {
        this.empresa = empresa;
        this.direccion = direccion;
        this.codigo = codigo;
        this.item = item;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public ReciboDatos() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "ReciboDatos{" + "empresa=" + empresa + ", direccion=" + direccion + ", codigo=" + codigo + ", item=" + item + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ", subTotal=" + subTotal + '}';
    }
    
}
