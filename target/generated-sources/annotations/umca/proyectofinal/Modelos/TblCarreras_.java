package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblCarreraCurso;
import umca.proyectofinal.Modelos.TblMatricula;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblCarreras.class)
public class TblCarreras_ { 

    public static volatile CollectionAttribute<TblCarreras, TblCarreraCurso> tblCarreraCursoCollection;
    public static volatile SingularAttribute<TblCarreras, Date> fechaRegistro;
    public static volatile SingularAttribute<TblCarreras, String> usuarioRegistra;
    public static volatile SingularAttribute<TblCarreras, String> nombreCarrera;
    public static volatile CollectionAttribute<TblCarreras, TblMatricula> tblMatriculaCollection;
    public static volatile SingularAttribute<TblCarreras, Integer> pkIdCarrera;

}