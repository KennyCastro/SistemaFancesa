
package CapaLogica;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ExpresionesRegulares {
    private static final String REGEX_NOMBRE_APELLIDO ="^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$";
     private static final String REGEX_CARNET_IDENTIDAD = "^[0-9]{8}(-[a-zA-Z])?$";
    private static final String REGEX_TELEFONO = "^[6-7][0-9]{7}$";
    private static final String REGEX_DIRECCION = "^[a-zA-Z0-9\\s,.-\\\\#]+$";
     //private static final String REGEX_SUELDO = "^\\d+(\\.\\d{1,2})?$";
    private static final String REGEX_SUELDO = "^\\d+$";
    
    
    //parte personacocina
    public static boolean validarNombres(String nombreApellido){
        Pattern pattern = Pattern.compile(REGEX_NOMBRE_APELLIDO);
        Matcher matcher = pattern.matcher(nombreApellido);
        return matcher.matches();
     }
    
    
       public static boolean validarCarnet(String carnetIdentidad) {
            Pattern pattern = Pattern.compile(REGEX_CARNET_IDENTIDAD);
            Matcher matcher = pattern.matcher(carnetIdentidad);
            return matcher.matches();
        }
 
       public static boolean validarTelefono(String telefono) {
        Pattern pattern = Pattern.compile(REGEX_TELEFONO);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }
       
       
       public static boolean validarDireccion(String direccion) {
        Pattern pattern = Pattern.compile(REGEX_DIRECCION);
        Matcher matcher = pattern.matcher(direccion);
        return matcher.matches();
    }
       
    public static boolean validarSueldo(String numero) {
        Pattern pattern = Pattern.compile(REGEX_SUELDO);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }
    
    
    //parte productos
    
    private static final String REGEX_NOMBRE_PRODUCTO = "^[a-zA-Z][a-zA-Z0-9 ]*$";
    private static final String REGEX_PRECIO="^[0-9]+(\\.[0-9]{1,2})?$";
    
    public static boolean validarNombreProducto(String nombre) {
        Pattern pattern = Pattern.compile(REGEX_NOMBRE_PRODUCTO);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
    
    public static boolean validarPrecio(String precio) {
        Pattern pattern = Pattern.compile(REGEX_PRECIO);
        Matcher matcher = pattern.matcher(precio);
        return matcher.matches();
    }
    
    //parte unidades
    
    private static final String REGEX_NOMBRE_UNIDAD = "^[a-zA-Z][a-zA-Z0-9 ]*$";
    private static final String REGEX_CANTIDAD_EN_UNIDADES = "^[1-9]\\d*$";
    
    public static boolean validarNombreUnidad(String unidad) {
        Pattern pattern = Pattern.compile(REGEX_NOMBRE_UNIDAD);
        Matcher matcher = pattern.matcher(unidad);
        return matcher.matches();
    }
    
    public static boolean validarCantidadUnidades(String cantidadU) {
        Pattern pattern = Pattern.compile(REGEX_CANTIDAD_EN_UNIDADES);
        Matcher matcher = pattern.matcher(cantidadU);
        return matcher.matches();
    }
    
}


   
