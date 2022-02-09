docker-start:
	./mvnw clean package -DskipTests=true
	docker-compose up -d

docker-stop:
	docker-compose down