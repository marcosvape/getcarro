# getcarro
get carro interview

mvn clean install

docker build --tag 'getcarro' .

docker run -d -p 8080:8080 getcarro

run postman collection