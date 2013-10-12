#!/bin/bash
export DST=/home/admini/servers/apache-tomcat-6.0.36/webapps/sapp1

rm -rf $DST/WEB-INF/classes/*
rm $DST/WEB-INF/web.xml
rm -rf $DST/jsp/*

cp -r bin/* $DST/WEB-INF/classes
cp web.xml $DST/WEB-INF
cp -r jsp/* $DST/jsp
