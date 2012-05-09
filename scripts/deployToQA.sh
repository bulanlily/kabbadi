/opt/gradle-1.0-rc-1/bin/gradle -P env=qa war
scp ./build/libs/kabbadi.war twu@10.4.4.129:/opt/jetty/webapps
ssh twu@10.4.4.129 /etc/init.d/jetty restart
