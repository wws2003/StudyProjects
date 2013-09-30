#!/bin/bash
export DST=/home/admini/apache-tomcat-6.0.36/webapps/sapp1/WEB-INF/classes
rm -rf $DST/*
cp -r bin/* $DST
