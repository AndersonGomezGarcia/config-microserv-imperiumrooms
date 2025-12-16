cd API-productService
docker build -t product_service:1.0 .
cd ..

cd gateway
docker build -t imperium-rooms-gateway:1.0 .
cd ..

cd imperiumRoomsDS3
docker build -t imperiumrooms:1.1 .
cd .. 

cd AuthUsers
docker build -t auth-service:1.0 .
cd ..

