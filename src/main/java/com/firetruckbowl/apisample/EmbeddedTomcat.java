package com.firetruckbowl.apisample;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

public class EmbeddedTomcat {
  private static final Logger LOG = LoggerFactory.getLogger(EmbeddedTomcat.class);

  private Tomcat tomcat;

  private void startTomcat(String webappHome) throws ServletException, LifecycleException {
    this.tomcat = new Tomcat();
    this.tomcat.setPort(8080);
    this.tomcat.setBaseDir(".");

    StandardServer server = (StandardServer) this.tomcat.getServer();
    AprLifecycleListener listener = new AprLifecycleListener();
    server.addLifecycleListener(listener);

    String ctxPath = "/";
    String appBase = webappHome ;
    this.tomcat.addWebapp(ctxPath, appBase);

    this.tomcat.start();
    this.tomcat.getServer().await();
  }

  public static void main(String[] arguments) {
    if (arguments[0] == null || "".equals(arguments[0])) {
      LOG.warn("Need to provide a path to the webapp home");
      return;
    }

    try {
      LOG.debug("Loading webapp at [{}] ", arguments[0]);
      EmbeddedTomcat tomcat = new EmbeddedTomcat();
      tomcat.startTomcat(arguments[0]);
    }
    catch (Exception e) {
      LOG.error("A bad exception occured while trying to start Tomcat!", e);
      throw new RuntimeException(e);
    }
  }
}
