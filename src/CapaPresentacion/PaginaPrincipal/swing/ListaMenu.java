
package CapaPresentacion.PaginaPrincipal.swing;

 //@author KENNY
import CapaPresentacion.PaginaPrincipal.event.EventMenuSelected;
import CapaPresentacion.PaginaPrincipal.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;


 
public class ListaMenu<E extends Object> extends JList<E>{
    
    private final DefaultListModel model;
    
    private int IndexSeleccionado = -1;
    
    private int pintarIndexSeleccionado = -1;
    
   
     private EventMenuSelected evento; //nos ayudará a cambiar de paginas (pestañas)
    
    public void addEventMenuSelected (EventMenuSelected evento) {
        this.evento = evento;
    }
    
    
    
    public ListaMenu(){
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        int index= locationToIndex(e.getPoint());
                        Object ob=model.getElementAt(index);
                        if (ob instanceof Model_Menu){
                            Model_Menu menu= (Model_Menu) ob;
                            if (menu.getType()==Model_Menu.MenuTipo.MENU) {
                                IndexSeleccionado=index;
                                if (evento!=null) {
                                        evento.seleccion(index);
                                }
                            }
                        } else {
                            IndexSeleccionado = index;
                        }
                        
                        repaint();
                    }
            }

            @Override
            public void mouseExited(MouseEvent e) {
               pintarIndexSeleccionado=-1;
                repaint();
            }
            
            
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index!=pintarIndexSeleccionado) {
                    Object o = model.getElementAt(index);
                    if (o instanceof Model_Menu) {
                        Model_Menu menu = (Model_Menu) o;
                        if (menu.getType()==Model_Menu.MenuTipo.MENU) {
                            pintarIndexSeleccionado = index;
                        } else {
                            pintarIndexSeleccionado=-1;
                        }
                        
                        repaint();
                    }
                }
            }
            
            
        
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
               Model_Menu datos;
               if (o instanceof Model_Menu) {
                   datos=(Model_Menu)o;
               } else {
                       datos= new Model_Menu("",o+"",Model_Menu.MenuTipo.EMPTY);
               }
               MenuItems item = new MenuItems(datos);
               item.setItemSeleccionado(IndexSeleccionado==index);
               item.setPintarItem(pintarIndexSeleccionado==index);
               return item;
            } 
        };
    }
    
    
    public void addItem(Model_Menu datos){
        model.addElement(datos);
    }
    
    
}
