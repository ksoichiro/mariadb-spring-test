# mariadb-spring-test

A tiny application powered by Spring Boot to test MariaDB.

## Vagrant VMs

### Contents

* Ubuntu 12.04 Precise 64bit
* MariaDB 10.1 (Galera Cluster)

### VM operations

There are three VM configurations: g1, g2, g3.  
Each one is a master node of Galera Cluster.

#### Setup

1. `vagrant up g1 g2 g3`
1. Login to g1 by `vagrant ssh g1`
1. Copy content of `/etc/mysql/debian.cnf` in g1
1. Login to g2 by `vagrant ssh g2`
1. Replace content of `/etc/mysql/debian.cnf` with copied debian.cnf from g1
1. Do same things in g3
1. Restart hosts

#### Other operations

```sh
# launch
vagrant up g1
# login to g1 VM
vagrant ssh g1
# stop g1 VM
vagrant halt g1
```

### MariaDB service operations

Execute as root user(`sudo su -` from vagrant user):

```sh
# start
service mysql start
# stop
service mysql stop
# show cluster status
mysql -uroot -ptest -e"show status like 'wsrep_%'"
# check query log
tail -f /var/log/mysql/mysql.log
```

## App

To run, execute with Gradle wrapper:

```sh
./gradlew bootRun
```

You can configure JDBC connection with `src/main/resources/application.yml`.
## License

Copyright © 2015 Soichiro Kashima.

Licensed under MIT License.  
See the bundled LICENSE file for details.
