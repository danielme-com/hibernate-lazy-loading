FROM mysql:5.7.30
ENV MYSQL_ROOT_HOST=% \
    MYSQL_ROOT_PASSWORD=root
COPY birds.sql /docker-entrypoint-initdb.d/