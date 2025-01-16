package br.ifpr.edu.receitas.utils;

import br.ifpr.edu.receitas.models.Usuario;

public class VariavelGlobalUsuario {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        VariavelGlobalUsuario.usuario = usuario;
    }
}
