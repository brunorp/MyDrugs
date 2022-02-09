docker-install:
	./mvnw clean install -DskipTests=true

docker-start:
	docker-compose up --build

docker-stop:
	docker-compose down