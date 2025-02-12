#Before building docker image, compile code and generate jar using: mvn package
#then run: docker build -t kubernetes-demo:1 .
#then to create new tag for above image do: docker tag <image-name> <registry-url>/<username>/<image-name>:<tag>
#Eg: docker tag kubernetes-demo:1 dheeratp/kubernetes-demo:1
#the do docker push image to dockerhub: docker push dheeratp/kubernetes-demo:1
# Use an OpenJDK image with JDK 17
# Use command to deploy via kubernetes after updating kubernetes deploy manifest with the above image: kubectl apply -f <blah.yaml>
# We need to use this command to set the port-forwarding to the pods (Note that deployment/kubernetes-demo is to tell kubernetes to forward to a port on pods, not the deployment itself ..see as we have not used kubectl port-forward --address 0.0.0.0 kubernetes-demo)
#                   : kubectl port-forward --address 0.0.0.0 deployment/kubernetes-demo 8081:8081
# Use this command to get details of what image is deployed by kubernetes: kubectl get deployment -o wide
# Use this commanbd to check the pods: kubectl get pods
# Access API using http://localhost:8081/api/greetings/greet?username=Dheera
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build file
COPY target/kubernetes-demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (assuming 8080)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
