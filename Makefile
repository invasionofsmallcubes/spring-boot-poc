ifneq (,)
This makefile requires GNU Make.
endif

.PHONY: run-example
run-example:
	./gradlew clean build
	docker-compose down -v
	docker-compose up --build

.PHONY: run-batch
run-batch:
	curl http://localhost:8081/woosh