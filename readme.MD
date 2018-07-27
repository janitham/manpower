### Manpower Inc

#### How to run

1. ```mvn clean install``` will build the artifacts and image automatically
2. ```docker-compose up -d``` will will deploy all db and application
3. wait for serveral miniutes...
4. connect to the mysql database using root:root on localhost:3306
5. apply the mysql files, manpower_inc_data.sql and manpower_utils_sql.sql
6. browse for localhost:8082/

#####Monitoring: 
1. ```docker-compose -f docker-compose-monitoring.yml up -d``` will create prometheus and grafana instances
2. browse ```localhost:3000``` for find grafana ui
3. use admin:admin then select the datasource as promethues.

### Kubernetes & JenkinsFile
1. Sample jenkinsfile created to automate build and release pipeline.
2. Sample Kubernetes deployments files added to deploy the application to Kubernetes cluster.