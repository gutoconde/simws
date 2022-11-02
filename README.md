mvc clean package -DskipTests

aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket simws-bucket

aws cloudformation deploy --template-file /home/gutoconde/builds/simws/output-sam.yaml --stack-name ServlessSimwsApi  --capabilities CAPABILITY_IAM

