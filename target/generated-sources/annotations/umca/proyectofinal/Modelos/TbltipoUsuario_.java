package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblUsuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TbltipoUsuario.class)
public class TbltipoUsuario_ { 

    public static volatile CollectionAttribute<TbltipoUsuario, TblUsuario> tblUsuarioCollection;
    public static volatile SingularAttribute<TbltipoUsuario, Integer> pkIdTipo;
    public static volatile SingularAttribute<TbltipoUsuario, Date> fechaRegistro;
    public static volatile SingularAttribute<TbltipoUsuario, String> usuarioRegistra;
    public static volatile SingularAttribute<TbltipoUsuario, String> tipoUsuario;

}