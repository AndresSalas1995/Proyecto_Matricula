package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.Modelos.TblMatricula;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblDetalleMatricula.class)
public class TblDetalleMatricula_ { 

    public static volatile SingularAttribute<TblDetalleMatricula, Date> fecha;
    public static volatile SingularAttribute<TblDetalleMatricula, Integer> precio;
    public static volatile SingularAttribute<TblDetalleMatricula, TblMatricula> fkMatricula;
    public static volatile SingularAttribute<TblDetalleMatricula, Integer> pkidDetalleMatricula;
    public static volatile SingularAttribute<TblDetalleMatricula, String> usuarioRegistra;
    public static volatile SingularAttribute<TblDetalleMatricula, TblCursos> fkCurso;

}