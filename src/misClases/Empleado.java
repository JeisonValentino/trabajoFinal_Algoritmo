package misClases;

public class Empleado extends Persona {

    private String rol;
    private String codigo;

    public Empleado(String rol, String codigo, String nombre, int edad, int DNI) {
        super(nombre, edad, DNI);
        this.rol = rol;
        this.codigo = codigo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
