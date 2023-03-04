package dataFactory.usuarioDataFactory;

import pojo.UserPojo;

public class UserDataFactory {
    public static UserPojo criarNovoUsuario(){
        UserPojo user = new UserPojo();
        user.setUsuarioNome("Jiraya");
        user.setUsuarioLogin("seninb");
        user.setUsuarioSenha("kurama");

        return user;
    }
}
