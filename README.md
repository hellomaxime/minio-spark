# minio-spark

## Minio with Docker

__run minio__
`docker run -p 9000:9000 -p 9001:9001 -d quay.io/minio/minio server /data --console-address ":9001"`

__username : minioadmin__  
__password : minioadmin__  
Set 'MINIO_ROOT_USER' and 'MINIO_ROOT_PASSWORD' environment variables to change username and password  
  
http://localhost:9000/  
