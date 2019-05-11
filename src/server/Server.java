package server;

import DB.PostgreSQL;
import RMI.RemoteInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

/**
 *
 * @author Ricardo
 */
public class Server extends UnicastRemoteObject implements RemoteInterface {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String getAlumno(String pattern) throws Exception {
        String resultados = "";
        PostgreSQL psql = new PostgreSQL();
        ResultSet rs = psql.ejecutaQuery("Select * from alumno where UPPER(tx_nombre || ' ' || tx_primer_ape || ' ' || tx_segundo_ape || ' ' || tx_curp || ' ' || tx_boleta) like UPPER('%"+pattern+"%')");
        while(rs.next()){
            resultados += rs.getString(1) + ";" + rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(7)+":";
        }
        System.out.println(resultados);
        try{
        resultados=resultados.substring(0, (resultados.length()-1));
        }catch(Exception e){            
        }
        return resultados;
    }

    @Override
    public String getUnidadAcademica(String pattern) throws Exception {
        return "En desarrollo :)";
    }

    @Override
    public String getProgramaAcademico(String pattern) throws Exception {
        return "En desarrollo :)";
    }

    @Override
    public String getPlanEstudioc(String pattern) throws Exception {
        return "En desarrollo :)";
    }

    @Override
    public String getHistorialAcademico(int alumnoID) throws Exception {
        String resultados = "";
        PostgreSQL psql = new PostgreSQL();
        String query = "select "
                + "ma.tx_nombre materia"
                + ",ca.tx_nombre calificacion"
                + ",to_char(pe.fh_inicio,'mm/yy') || ' - ' || to_char(pe.fh_fin,'mm/yy') periodo "
                + "from alumno x "
                + "left join curse y on x.id_alumno = y.id_alumno "
                + "left join reinscripcion re on (x.id_alumno = re.id_alumno and y.id_unidad=re.id_unidad) "
                + "left join calificacion_curse cc on y.id_curse = cc.id_curse "
                + "left join calificacion ca on ca.id_calificacion = cc.id_calificacion "
                + "left join materia ma on ma.id_materia = y.id_materia "
                + "join periodo_escolar pe on re.id_periodo = pe.id_periodo "
                + "where x.id_alumno = " + alumnoID;
        ResultSet rs = psql.ejecutaQuery(query);        
        while(rs.next()){
            resultados += rs.getString(1) + ";" + rs.getString(2)+";"+rs.getString(3)+":";
        }
        System.out.println("res: \n\t" + resultados);
        try{
        resultados=resultados.substring(0, (resultados.length()-1));
        }catch(Exception e){
        }
        return resultados;
    }

    @Override
    public String getEstadisticas() throws Exception {
        
        return "En desarrollo :)";
    }
    
    
    
}
