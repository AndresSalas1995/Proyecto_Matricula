package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TbltipoUsuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblUsuario.class)
public class TblUsuario_ { 

    public static volatile SingularAttribute<TblUsuario, String> ultimoUsuarioModifico;
    public static volatile SingularAttribute<TblUsuario, String> primerApellido;
    public static volatile SingularAttribute<TblUsuario, String> usuarioRegistro;
    public static volatile SingularAttribute<TblUsuario, Date> fechaRegistro;
    public static volatile SingularAttribute<TblUsuario, String> segundoApellido;
    public static volatile SingularAttribute<TblUsuario, String> contrasena;
    public static volatile SingularAttribute<TblUsuario, TbltipoUsuario> fkTipoUsuario;
    public static volatile SingularAttribute<TblUsuario, String> nombreUsuario;
    public static volatile SingularAttribute<TblUsuario, String> nombre;
    public static volatile SingularAttribute<TblUsuario, String> email;
    public static volatile SingularAttribute<TblUsuario, Integer> pkIdUsuario;

}