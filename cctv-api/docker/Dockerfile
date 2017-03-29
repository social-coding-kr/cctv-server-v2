FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD docker-entrypoint.sh docker-entrypoint.sh
ADD app.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Xms1024m -Xmx2048m"
ENTRYPOINT [ "/docker-entrypoint.sh" ]