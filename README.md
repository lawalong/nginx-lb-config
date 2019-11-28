# Webjet-code-demo

## - Architecture
          VM                           Containers                                 support engineers
                                                                Servers
                                      +-----------------------+   |
                          (read)      |                       |   |
                          +-----------+ Nginx Load Balancer   +---+
          +-------------------+       |                       |
          |                   |       +-----------------------+                 +---------------------------+
          | Nginx Config File |                                                 |Option1:                   |
          |                   |                     +---------------------------+  Application (in the demo)|
          +----------------+--+                     |                           |                           |
                           |                        |                           +---------------------------+
                           |                        |
                           |          +-------------+---------+
                           +----------+                       |
                           (edit)     | Config Application    |
                                      | (inbound IP check)    |
    +-------------------------+       |                       |
    |Bash                     |       +-------------+---------+
    |(by Cron or Manual)      |                     |                           +---------------------------+
    |                         |                     |                           |Option2:                   |
    |1. backup config file    |                     |                           |  API (not in demo,        |
    |2. copy config file      |                     |                           |  but with my previous code)
    |3. notify Nginx Reload   |                     +---------------------------+                           +
    |                         |                                                 |  1. Payload with APIKEY   |
    +-------------------------+                                                 |  2. Token Encryption (e.g.|
                                                                                |  DES in both sides)       |
                                                                                |  3. javascript obfuscator |
                                                                                |                           |
                                                                                +---------------------------+





## - Micro Services
   1. Nginx Load Balancer (lb-service)
   2. Config App (lb-config-service)

## - Prerequisites
   1. Docker
   2. Docker-Compose

## - How to use


#### 1. Build Projct (at root path of project)
```
    $ bash build.sh
```
#### 2. Run Docker containers
```
    $ docker-compose up
```

#### 3. Smoke Test

* Nginx Load Balancer
-   http://localhost:44405/
* Config App
-   http://localhost:44406/


Apply changes: 
```
    $ bash override_config.sh
```

## - Assumptions
1. If using Kubernetes, auto pull latest images could be another solution
2. In production environment, we need to write log for every changes
3. Prepare rollback solution for production environment 





