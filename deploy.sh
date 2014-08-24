mvn clean package
rm /usr/local/tomcat/webapps/*.war
cp target/*.war /usr/local/tomcat/webapps