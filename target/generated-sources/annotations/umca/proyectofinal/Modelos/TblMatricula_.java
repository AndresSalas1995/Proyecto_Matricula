package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblDetalleMatricula;
import umca.proyectofinal.Modelos.TblEstudiantes;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblMatricula.class)
public class TblMatricula_ { 

    public static volatile SingularAttribute<TblMatricula, Integer> total;
    public static volatile SingularAttribute<TblMatricula, TblCarreras> fkCarrera;
    public static volatile SingularAttribute<TblMatricula, TblEstudiantes> fkEstudiante;
    public static volatile SingularAttribute<TblMatricula, Integer> iva;
    public static volatile SingularAttribute<TblMatricula, Integer> subtotal;
    public static volatile SingularAttribute<TblMatricula, Date> fechaRegistro;
    public static volatile SingularAttribute<TblMatricula, Integer> fkidmatricula;
    public static volatile SingularAttribute<TblMatricula, String> usuarioRegistra;
    public static volatile CollectionAttribute<TblMatricula, TblDetalleMatricula> tblDetalleMatriculaCollection;

}