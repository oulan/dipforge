@echo off
set JAVA_HOME="/usr/lib/jvm/java-6-openjdk"
set DIPFORGE_HOME=/home/brettc/Documents/external/github/dipforge.git/release/dipforge/
set EXTRA=""
set JAVA="/usr/lib/jvm/java-6-openjdk/jre/bin/java"
set JAVA_OPTS=-Dcoad.config=com.rift.coad.lib.configuration.xml.XMLConfigurationFactory
set JAVA_OPTS=%JAVA_OPTS% -Dxml.config.path="%DIPFORGE_HOME%/etc/config.xml"
set JAVA_OPTS=%JAVA_OPTS% -DLog.File="%DIPFORGE_HOME%/etc/log4j.properties"
set JAVA_OPTS=%JAVA_OPTS% -Djava.security.policy=="%DIPFORGE_HOME%/etc/server.policy"
set JAVA_OPTS=%JAVA_OPTS% -Djava.security.manager
set JAVA_OPTS=%JAVA_OPTS% -Dsptmail.data.directory="%DIPFORGE_HOME%/var/spt"
set JAVA_OPTS=%JAVA_OPTS% -Duser.home="%DIPFORGE_HOME%/var/home"
set JAVA_OPTS=%JAVA_OPTS% -Dbase.dir="%DIPFORGE_HOME%"
set JAVA_OPTS=%JAVA_OPTS% -Djava.rmi.server.RMIClassLoaderSpi=com.rift.coad.RemoteClassLoaderSpi
set CURRENT_DIR=./
set COAD_LIB_DIRS=%DIPFORGE_HOME%/lib;/usr/lib/jvm/java-6-openjdk/lib/tools.jar;

echo %JAVA% %JAVA_OPTS% -Xmx768M -XX:PermSize=128M -XX:MaxPermSize=256M -cp %EXTRA% -jar "%DIPFORGE_HOME%/sbin/CoadunationBase.jar"
%JAVA% %JAVA_OPTS% -Xmx768M -XX:PermSize=128M -XX:MaxPermSize=256M -cp %EXTRA% -jar "%DIPFORGE_HOME%/sbin/CoadunationBase.jar"