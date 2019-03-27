Created by Olga Pavlova
Olga.Pavlova@jetbrains.com

Task:
Debug the SpringBoot application, which is built(maven) inside the container with the connection to the container mysql database.

It is a spring boot application for the local bus service.
The database image is already pre-populated and its name is: opavlova/db-mysql:5.7-test
    container mysql port: 3306
    db name: DOCKERDB
    password: root
    login: root

For it I have a docker-compose file with two services.
One is the application itself, built with the Dockerfile using maven. Another is the mysql database.


Steps:
1. Install Docker integration plugin if it is not installed
2. Create a remote run configuration with docker-compose_debug.yml in the before launch section, for it do the following:
-go to the Project View, call context menu, choose "Create...", press Ok
-go docker-compose_debug.yml file, click "Debug" gutter(or Run->Edit Configurations->create Remote run configuration):
    point another debug port->Apply
    add "Launch docker before debug" in the "Before Launch" section (check that the custom command is Ok), Press Ok
-run debug


Problems, that can happen:
1. the images are not re-build
 To fix: go to the created docker-compose run configuration and turn on the option "--build, force build images"

2. if the port is allocated:
 -check that there is no already running containers at the host ports, pointed in the compose files (13306 for mysql and 18080 for the app container)
 If debug port  is allocated then set another port

3. the "connection link failure" in the application container
To fix:
-check the correctness of the database url from  src\main\resources\application.properties
It should be jdbc:mysql://<db_container_name>:<db_container_port>/DOCKERDB
-try to delete the created "app" container and re-run the compose file(run configuration) again with "--build" option on.

4. Debug re-run doesn't work.
To fix: Run it once more. It happens that it fails to re-run(IDEA-209225).

5. Custom command is not changed after save (IDEA-207868)
To fix: delete the remote run config, create it again

6. Debug doesn't work at all, the error "Unable to locate started container" appears after 2 min:
-check that "HEALTHCHECK"=false if there is no healthcheck for running docker container.

7. The command for debug doesn't contain the needed "running" options.
To Fix:
  the command appears automatically if:
    for Dockerfile - Command field of the docker run config contains this command
    for docker compose:  there is the "command" key with the command for a service
  write it manually in the Custom Command field of the "Docker Configuration" dialog in the "Before Launch" section



Tips:
-run commands like "bash" etc inside the containers:
use DockerView->select a container->context menu-> "exec"

-select one of the services to run in the compose file:
go to the compose run configuration, select any service(s) in the "Services" field

-you can connect to the database via Database view:
go to the DataabseView->+->DataSource from Url
url: jdbc:mysql://0.0.0.0:13306/DOCKERDB

-you can check the working conternerized application:
upon executing GET request at http://127.0.0.1:18080/entitybus/post

