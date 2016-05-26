/*
 * Clase para integrar la lista de Cliente
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author mfontana
 */
public class ListaClientes implements Serializable {
       
    private ObservableList<Cliente> lista;

    public ListaClientes() {
        lista = ObservableCollections.observableList(new ArrayList<Cliente>());
    }
    
    //Metodo para eliminar un cliente de la lista
    public void bajaCliente(Cliente c){
        lista.remove(c);
    }
    
    
    //Metodo que me devuelve una copia de la lista
    public ListaClientes copiaClientes() {
        ListaClientes copia = new ListaClientes();
        for (Cliente c : lista){
            copia.altaCliente(c);
        }
        return copia;
    }
    
    // contains utiliza equals, debemos sobreescribirlo en Cliente
    public boolean existeCliente(Cliente c) {
        return lista.contains(c);
    }
    
    public void altaCliente(Cliente c) {
        lista.add(c);
    }

    public static final String PROP_LISTA = "lista";

    public ObservableList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Cliente> lista) {
        ObservableList<Cliente> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
 
}
