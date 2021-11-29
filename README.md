# springboot-springcache-redis-gradle
Branch for POC for Spring Boot with Spring Cache Backed by Redis

#Commands Used for Testing

curl -i -X GET http://localhost:8080/employee
		
curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName":"Dummy","lastName":"Dummy","lastUpdatedBy":"Test","lastUpdatedTs":"2021-02-10T08:00:00.000+00:00"}' http://localhost:8080/employee

curl -i -X PUT -H 'Content-Type: application/json' -d '{"employeeId":3,"firstName":"Test","lastName":"Test","lastUpdatedBy":"Test","lastUpdatedTs":"2021-02-10T08:00:00.000+00:00"}' http://localhost:8080/employee/3


curl -i -X POST -H 'Content-Type: application/json' -d '{"employeeId":3,"firstName":"Dummy","lastName":"Dummy","lastUpdatedBy":"Test","lastUpdatedTs":"2021-02-10T08:00:00.000+00:00"}' http://localhost:8080/employee/clearEmpCache

#Redis ACL Change Command
user username on  +@all ~* >password
