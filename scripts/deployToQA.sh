/opt/gradle-1.0-rc-1/bin/gradle -P env=qa war
scp ./build/libs/kabbadi.war twu@10.4.3.1:/opt/jetty/webapp
ssh twu@10.4.3.1 /etc/init.d/jetty restart
