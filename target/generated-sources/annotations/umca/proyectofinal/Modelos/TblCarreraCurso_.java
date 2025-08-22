package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblCursos;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblCarreraCurso.class)
public class TblCarreraCurso_ { 

    public static volatile SingularAttribute<TblCarreraCurso, TblCarreras> fkCarrera;
    public static volatile SingularAttribute<TblCarreraCurso, Date> fechaRegistro;
    public static volatile SingularAttribute<TblCarreraCurso, String> usuarioRegistra;
    public static volatile SingularAttribute<TblCarreraCurso, Integer> pkIdCarreraCurso;
    public static volatile SingularAttribute<TblCarreraCurso, TblCursos> fkCurso;

}