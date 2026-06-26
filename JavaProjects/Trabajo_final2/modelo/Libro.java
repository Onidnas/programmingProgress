package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {

    private static final long serialVersionUID = 101L;

    private String    isbn;
    private String    titulo;
    private String    autor;
    private String    genero;
    private double    precio;
    private int       ejemplares;
    private LocalDate fechaAlta;

    public Libro(String isbn, String titulo, String autor,
                 String genero, double precio, int ejemplares) {
        this.isbn       = isbn;
        this.titulo     = titulo;
        this.autor      = autor;
        this.genero     = genero;
        this.precio     = precio;
        this.ejemplares = ejemplares;
        this.fechaAlta  = LocalDate.now();
    }

    public String    getIsbn()       { return isbn; }
    public String    getTitulo()     { return titulo; }
    public String    getAutor()      { return autor; }
    public String    getGenero()     { return genero; }
    public double    getPrecio()     { return precio; }
    public int       getEjemplares() { return ejemplares; }
    public LocalDate getFechaAlta()  { return fechaAlta; }

    public void setEjemplares(int e) { this.ejemplares = e; }
    public void setPrecio(double p)   { this.precio = p; }

    @Override
    public String toString() {
        return String.format(
            "[%s] \"%s\" — %s | %s | $%.2f | Ejemplares: %d | Alta: %s",
            isbn, titulo, autor, genero, precio, ejemplares, fechaAlta
        );
    }
}
