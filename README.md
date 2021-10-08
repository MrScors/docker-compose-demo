Info commands:
    	docker -v                       <- show current docker version
    	docker images                   <- show list of local up to date images
    	docker images -a                <- show list of all local images (<none> included)
    	docker ps                       <- show list of running containers
    	docker ps -a                    <- show list of all docker containers
    	docker log ${container_name}    <- show all logs of the container

    	docker-compose -v      <- show current docker-compose version
    	docker-compose log     <- show logs of current docker-compose

Build commands:
	docker build -t ${name} ${path}     <- build an image using Dockerfile in ${path} and give it ${name} as tag (if Dockerfile is in the current dir - use . as a ${path})
	docker-compose build                <- build all docker-compose images (use in the directory with docker-compoes.yaml)

Run commands: (to each of this commands you can add -d flag to run them without showing real-time logs)
	docker run --${name} -p ${your_port}:${container_port} ${image_name}    <- create and run docker container with name ${name} from 
                                                                            image with name ${image_name} and expose ${container_port} on local ${your_port}
	docker start ${container_name}                                          <- start existing container with name ${container_name} 
	docker-compose up                                                       <- start docker-compose
	
Stop commands: 
	docker stop ${container_name}        <- stop container with name ${container_name}
	docker-compose down                  <- stop current docker-compose

Remove commands:
	docker rm ${container_name}          <- remove stopped container with name ${container_name} (will not work if container os running)
	docker rmi ${image_name}        <- remove image with name ${image_name} (will not work if any container use it, it has any child images)
	docker system prune                  <- remove all stopped containers, danging images, build cache and unused networks
        docker rmi $(docker images -a -q)    <- remove all images
	docker rm $(docker ps -a -f status=exited -q)    <- remove all containers
	docker image prune        \
	docker container prune    | <- you should already know what it is)
	docker network prune      /

Docker machine:
	docker-machine create --driver virtualbox --virtualbox-memory ${size} ${name}   <- creating docker machine with memory size ${size} and name ${name}
	docker-machine env ${name}        <- tell docker to talk to virtual machine with name ${name}
	docker-machine start ${name}      <- start docker machine on your machine
	docker-machine stop               <- stop docker on your machine