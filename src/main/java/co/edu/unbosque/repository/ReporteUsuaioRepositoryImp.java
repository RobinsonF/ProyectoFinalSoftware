package co.edu.unbosque.repository;

import co.edu.unbosque.commons.JasperReportManager;
import co.edu.unbosque.commons.TipoReporteEnum;
import co.edu.unbosque.dto.AuditoriaDTO;
import co.edu.unbosque.dto.ReporteUsuarioDTO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

@Repository
@Transactional
public class ReporteUsuaioRepositoryImp implements ReporteUsuarioRepository{

    @PersistenceContext
    EntityManager entityManager;

    ReporteUsuarioRepository repository;
    @Autowired
    JasperReportManager jasperReportManager;

    @Autowired
    DataSource dataSource;


    @Override
    public ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params) {
        try{
            String fileName = "usuarios";
            ReporteUsuarioDTO dto = new ReporteUsuarioDTO();
            String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
                    : ".pdf";
            dto.setFileName(fileName + extension);

            ByteArrayOutputStream stream = jasperReportManager.export(fileName, params.get("tipo").toString(), params,
                    dataSource.getConnection());

            byte[] bs = stream.toByteArray();
            dto.setStream(new ByteArrayInputStream(bs));
            dto.setLength(bs.length);

            return dto;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
