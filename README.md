# Compile:
javac -classpath lib/jade.jar -d classes src/examples/mlr/*.java

# Run:
java -cp lib/jade.jar;classes jade.Boot -gui -port 3100 -agents MultiLinearRegression:examples.mlr.MLRAgent