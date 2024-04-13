package com.moviles.tp4.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String email;
    private String clave;

    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
