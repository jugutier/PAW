if [[ $(netstat -lnp | grep ':8080') == *java* ]]; then
  echo "Found a Tomcat! You're good for deploy."
else
  echo "Tomcat not found, restoring..."
  $CATALINA_HOME/bin/startup.sh
fi