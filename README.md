# SIMWS - API do aplicativo SIM

### Instalação na AWS

Obs.: Nesta versao não é possível atualizar a base de dados sqlite na AWS.

Defina as seguintes variaveis de ambiente: 

```
- WS_ACCESS_KEY_ID
- AWS_SECRET_ACCESS_KEY
```

Na raiz do projeto execute o comando abaixo para gerar o arquivo zip:

```
> mvn clean package -P zip -DskipTests
```

Com o CLI aws instalado, execute o comando na raiz do projeto para empacotar o projeto:

```
> aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket simws-bucket
```

Execute o comando abaixo para fazer o deploy na AWS:

```
aws cloudformation deploy --template-file /home/gutoconde/builds/simws/output-sam.yaml --stack-name simws  --capabilities CAPABILITY_IAM
```

### Criando a imagem Docker

Execute o comando maven na raiz do projeto: 

```
> mvn clean package -DskipTests -P jar
```

Execute o comando a seguir na raiz do projeto para criar as imagens:

```
> docker-compose up -d --build
```

Para enviar as imagens para o docker-hub

```
> docker-compose push
```
