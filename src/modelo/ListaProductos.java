/*
 * Clase para integrar la lista de Producto
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
public class ListaProductos implements Serializable {
    
    private ObservableList<Producto> lista;

    public ListaProductos() {
        lista = ObservableCollections.observableList(new ArrayList<Producto>());
    }
    
    //Creamos una lista de productos que tiene stock
    public ListaProductos productoEnStock(){
        ListaProductos productosConStock = new ListaProductos();
        for (Producto p: lista){
            if(p.getStock()>0){
                productosConStock.altaProducto(p);
            }
        }
        return productosConStock;
    }
    
    public boolean existeProducto(Producto p) {
        return lista.contains(p);
    }
    
    public void altaProducto(Producto p) {
        lista.add(p);
    }
    
    public static final String PROP_LISTA = "lista";

    public ObservableList<Producto> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Producto> lista) {
        ObservableList<Producto> oldLista = this.lista;
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
