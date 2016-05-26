/*
 * Entidad Cliente
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfontana
 */
public class Cliente implements Serializable, Comparable, Cloneable { //añadimos Comparable e implementamos 
                                                                      //todos los metodos abstractos
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;

    public Cliente() {
        nif = "";
        nombre = "";
        apellidos = "";
        direccion = "";
        poblacion = "";
    }

    @Override
    public String toString() {
        if(apellidos.equals("-- Escoge un cliente --")){
            return apellidos;
        } else{
        return apellidos + ", " + nombre;
        }
    }

    public Cliente(String nif, String nombre, String apellidos, String direccion, String poblacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return other.getNif().equalsIgnoreCase(nif);
    }

    public static final String PROP_POBLACION = "poblacion";

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        String oldPoblacion = this.poblacion;
        this.poblacion = poblacion;
        propertyChangeSupport.firePropertyChange(PROP_POBLACION, oldPoblacion, poblacion);
    }

    public static final String PROP_DIRECCION = "direccion";

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCION, oldDireccion, direccion);
    }

    public static final String PROP_APELLIDOS = "apellidos";

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        propertyChangeSupport.firePropertyChange(PROP_APELLIDOS, oldApellidos, apellidos);
    }

    public static final String PROP_NOMBRE = "nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    public static final String PROP_NIF = "nif";

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        propertyChangeSupport.firePropertyChange(PROP_NIF, oldNif, nif);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
//Insert code> Overrride method> clone()
    @Override
    public Object clone() { //no lanzamos la excepcion
        try{
            return super.clone();
        } catch(CloneNotSupportedException ex){
            System.out.println("Error, no se ha podido clonar el objeto");
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex); //Lo guardamos en un fichero log el error
            return null;
        }
//        Cliente copia = new Cliente();
//        copia.setNif(nif);
//        copia.setNombre(nombre);
//        copia.setApellidos(apellidos);
//        copia.setDireccion(direccion);
//        copia.setPoblacion(poblacion);
//        return copia;
    }

    
    
    @Override
    public int compareTo(Object t) {
        Cliente otro = (Cliente) t;
        //queremos que ordene por apellido
        return apellidos.compareTo(otro.getApellidos());
    }

}
