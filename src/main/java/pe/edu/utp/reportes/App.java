package pe.edu.utp.reportes;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class App{
    /*
    
*/
    public static void main(String[] args) throws Exception{
        System.out.println("HOla");
        
        InputStream arch = App.class.getClassLoader().getResourceAsStream("informes/Recibo.jrxml");
        System.out.println( "Ubicacion de reporte " + arch.toString() );
        try{
            JasperReport jr = JasperCompileManager.compileReport(arch);
            Map<String, Object> pr = new HashMap<>();
            JREmptyDataSource jre = new JREmptyDataSource();
            JasperPrint jp = JasperFillManager.fillReport(jr, pr, jre);
            JasperViewer.viewReport(jp);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
