package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblCarreraCurso;
import umca.proyectofinal.Modelos.TblDetalleMatricula;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblCursos.class)
public class TblCursos_ { 

    public static volatile SingularAttribute<TblCursos, Integer> precioCurso;
    public static volatile SingularAttribute<TblCursos, String> ultimoUsuarioModifico;
    public static volatile SingularAttribute<TblCursos, String> codigoCurso;
    public static volatile CollectionAttribute<TblCursos, TblCarreraCurso> tblCarreraCursoCollection;
    public static volatile SingularAttribute<TblCursos, Integer> pkIdCurso;
    public static volatile SingularAttribute<TblCursos, Date> fechaRegistro;
    public static volatile SingularAttribute<TblCursos, String> usuarioRegistra;
    public static volatile SingularAttribute<TblCursos, String> nombreCurso;
    public static volatile CollectionAttribute<TblCursos, TblDetalleMatricula> tblDetalleMatriculaCollection;
    public static volatile SingularAttribute<TblCursos, Integer> creditosCurso;

}