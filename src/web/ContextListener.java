package web;

import javax.servlet.*;
import java.io.File;

/**
 * Created by IBM on 10/03/2017.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String rootPath = System.getProperty("catalina.home");

        ServletContext ctx = sce.getServletContext();

        String relativePath = ctx.getInitParameter("tempfile.dir");

       // File file = new File(rootPath + File.separator + relativePath);

        File file = new File("C:\\cvfile");

        if(!file.exists()) file.mkdirs();

        System.out.println("File Directory created to be used for storing files");

        ctx.setAttribute("FILES_DIR_FILE", file);

        //ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
        ctx.setAttribute("FILES_DIR", "C:\\cvfile\\");



    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
