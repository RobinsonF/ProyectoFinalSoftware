package co.edu.unbosque.repository;

import co.edu.unbosque.commons.JasperReportManager;
import co.edu.unbosque.commons.TipoReporteEnum;
import co.edu.unbosque.dto.ReporteUsuarioDTO;
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
public class ReporteRepositoryImp implements ReporteRepository {

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
    @Override
    public ReporteUsuarioDTO obtenerReporteCuadrilla(Map<String, Object> params) {
        try{
            String fileName = "cuadrillas";
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

    @Override
    public ReporteUsuarioDTO obtenerReporteMaterial(Map<String, Object> params) {
        try{
            String fileName = "materiales";
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

    @Override
    public ReporteUsuarioDTO obtenerReporteOrdenes(Map<String, Object> params) {
        try{
            String fileName = "ordenes";
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

    @Override
    public ReporteUsuarioDTO obtenerReporteEmpleados(Map<String, Object> params) {
        try{
            String fileName = "empleados";
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

    @Override
    public ReporteUsuarioDTO obtenerGraficaCuadrillas(Map<String, Object> params) {
        try{
            String fileName = "graficaCuadrillas";
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

    @Override
    public ReporteUsuarioDTO obtenerReporteCuadrilla2(Map<String, Object> params) {
        try{
            String fileName = "cuadrillas2";
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

    @Override
    public ReporteUsuarioDTO obtenerGraficaOrdenesCumplidas(Map<String, Object> params) {
        try{
            String fileName = "ordenesCumplidas";
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

    @Override
    public ReporteUsuarioDTO obtenerGraficaOrdenesNoCumplidas(Map<String, Object> params) {
        try{
            String fileName = "ordenesNoCumplidas";
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
