package umca.proyectofinal.Modelos;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import umca.proyectofinal.Modelos.TblMatricula;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-27T20:20:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TblEstudiantes.class)
public class TblEstudiantes_ { 

    public static volatile SingularAttribute<TblEstudiantes, String> primerApellido;
    public static volatile SingularAttribute<TblEstudiantes, Date> fechaNacimiento;
    public static volatile SingularAttribute<TblEstudiantes, Integer> pkIdEstudiante;
    public static volatile SingularAttribute<TblEstudiantes, Date> fechaRegistro;
    public static volatile SingularAttribute<TblEstudiantes, String> direccionResidencia;
    public static volatile SingularAttribute<TblEstudiantes, String> usuarioRegistra;
    public static volatile SingularAttribute<TblEstudiantes, String> numeroCedula;
    public static volatile SingularAttribute<TblEstudiantes, String> segundoApellido;
    public static volatile CollectionAttribute<TblEstudiantes, TblMatricula> tblMatriculaCollection;
    public static volatile SingularAttribute<TblEstudiantes, String> nombre;
    public static volatile SingularAttribute<TblEstudiantes, String> email;
    public static volatile SingularAttribute<TblEstudiantes, String> numeroTelefono;

}