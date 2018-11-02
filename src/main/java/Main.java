/**
 * Created by EE on 2018-11-01.
 */
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp/";
        int port = 8080;

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);

        StandardContext ctx = (StandardContext) tomcat.addWebapp(
            "/", new File(webappDirLocation).getAbsolutePath()
        );
        System.out.println(
            "configuring app with basedir: "
                + new File("./" + webappDirLocation).getAbsolutePath()
        );

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work

        File additionWebInfClasses = new File("out/production/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
            new DirResourceSet(
                resources,
                "/WEB-INF/classes",
            additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
