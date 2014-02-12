#!/bin/bash
export TOMCAT_WEBAPP_PATH=$HOME/servers/apache-tomcat-6.0.37/webapps

rm $TOMCAT_WEBAPP_PATH/securedautospring.war
rm -rf $TOMCAT_WEBAPP_PATH/securedautospring

cp target/securedautospring.war $TOMCAT_WEBAPP_PATH
