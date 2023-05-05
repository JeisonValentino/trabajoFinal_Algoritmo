package misClases;

public class Cliente extends Persona {
    public int telefono;
    public String Usuario;
    public String Contraseña;

    public int getTelefono() {
        return telefono;
    }

    public Cliente(int telefono, String Usuario, String Contraseña, String nombre, int edad, int DNI) {
        super(nombre, edad, DNI);
        this.telefono = telefono;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Cliente{" + "telefono=" + telefono + ", Usuario=" + Usuario + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
}
