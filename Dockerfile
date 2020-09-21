# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11
# Create work folder
RUN mkdir /work

# Make port 9102 available to the world outside this container
EXPOSE 8062

# Copying the application's jar file inside the container
COPY target/reference-producer-1.0-SNAPSHOT.jar /work/producer.jar

# Run the jar file 
CMD java -jar /work/producer.jar