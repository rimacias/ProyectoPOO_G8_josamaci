package espol.proyectopoo_g8_p2.backend;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    /**
     * Constructor para crear un nuevo usuario.
     * @param nombreUsuario
     * @param contrasenia 
     */
    public Usuario(String nombreUsuario,String contrasenia){
        this.nombreUsuario=nombreUsuario;
        this.contrasenia=contrasenia;
    }
    /**
     * getter que retorna el nombre de usuario del usuario.
     * @return nombreUsuario
     */
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    /**
     * getter que retorna la contrasenia del usuario.
     * @return contrasenia
     */
    public String getContrasenia(){
        return contrasenia;
    }
    /**
     * setter que cambia el nombre de usuario del usario.
     * @param nombre
     */
      public void setNombreUsuario(String nombre){
        nombreUsuario=nombre;
    }
    /**
     * setter que cambia la contrasenia del usario.
     * @param contra
     */
    public void setContrasenia(String contra){
        contrasenia=contra;
    }
    /**
     * Método equals que compara dos usarios y retorna true si son iguales.
     * @param u
     * @return boolean
     */
    public boolean equals(Usuario u){
        if (u.nombreUsuario.equals(nombreUsuario) && u.contrasenia.equals(contrasenia)){
        return true;
        }
    return false;
    }
    /**
     * Método estático que retorna una lista de usuarios que se cargan de admin.txt y residentes.txt
     * @return usuarios
     */
    public static List<Usuario> cargarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(Residente.cargarResidente());
        usuarios.addAll(Administrador.cargarAdmin());
        
        return usuarios;
    }
    /**
     * Método estático que devuelve la lista de los usarios extraídos de admin.txt y residentes.txt
     * @return 
     */
    public static List<Usuario> getListaUsuarios(){
        List<Usuario> usuarios = Usuario.cargarUsuario();
        return usuarios;
    }
    /**
     * Método estático que añade un usario a la lista de usuarios.
     * @param u
     * @return 
     */
    public List<Usuario> nuevoUsuario(Usuario u){
        List<Usuario> usuarios = Usuario.getListaUsuarios();
        usuarios.add(u);
        return usuarios;
    }
    
    
    
    
}

