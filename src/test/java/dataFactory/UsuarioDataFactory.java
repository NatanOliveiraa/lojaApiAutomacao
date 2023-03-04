package dataFactory;

import pojo.UsuarioTokenPojo;

public class UsuarioDataFactory {
    public static UsuarioTokenPojo criarUsuarioAdm(){

        UsuarioTokenPojo usuario = new UsuarioTokenPojo();
        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");
        return usuario;
    }

}
