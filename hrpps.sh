export lib="/home/kvn/workspace/hrpps/target/lib/"
export context="/home/kvn/workspace/hrpps/src/main/resources/pps-context.xml"
java -Dapplication-context=${context} -Dfile.encoding=UTF-8 -classpath /home/kvn/workspace/x/bin:/home/kvn/workspace/hrpps/target/hspps.jar:${lib}/xpp3_min-1.1.4c.jar:${lib}/hsqldb-2.2.9.jar:${lib}/jettison-1.2.jar:${lib}/javax.batch-api-1.0.jar:${lib}/commons-pool-1.5.4.jar:${lib}/commons-logging-1.1.3.jar:${lib}/commons-dbcp-1.4.jar:${lib}/xstream-1.4.7.jar:${lib}/com.ibm.jbatch-tck-spi-1.0.jar:${lib}/spring-aop-4.1.1.RELEASE.jar:${lib}/spring-beans-4.1.1.RELEASE.jar:${lib}/spring-context-4.1.1.RELEASE.jar:${lib}/xmlpull-1.1.3.1.jar:${lib}/spring-retry-1.1.0.RELEASE.jar:${lib}/spring-batch-infrastructure-3.0.1.RELEASE.jar:${lib}/spring-batch-core-3.0.1.RELEASE.jar:${lib}/spring-tx-4.1.1.RELEASE.jar:${lib}/spring-jdbc-4.1.1.RELEASE.jar:${lib}/spring-expression-4.1.1.RELEASE.jar:${lib}/spring-core-4.1.1.RELEASE.jar:${lib}/aopalliance-1.0.jar com.philips.cn.hr.pps.App

