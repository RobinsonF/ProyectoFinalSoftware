package co.edu.unbosque.dto;


import java.security.MessageDigest;

public class UsuarioDTO {

private int id_usuario;
private String nombre;
private String login;
private String direccion;
private String telefono;
private String correo;

private Integer id_rol;

private String password;

    public UsuarioDTO(){

    }
    public UsuarioDTO(int id_usuario, String nombre, String login, String direccion, String telefono, String correo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.login = login;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public  String shaEncode(String str) throws Exception {

        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.getStackTrace();
            return "";
        }
        byte[] byteArray = str.getBytes("utf-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
