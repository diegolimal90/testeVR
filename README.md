# VR- DESAFIO
Mini autorizador de transações.

### Descrição
Projeto springboot com java 8 ou superior, banco de dados dockerizado com o arquivo na raiz do projeto


### Swagger

As especificacoeso pode ser encontradas no caminho
> localhost:8080/swagger-ui.html


### Implementação
O projeto foi desenvolvido aplicando tecnicas de TDD onde visei cobrir o maximo de cenarios que fopi levantado no prazo do teste. O projeto segue o clean arch facilitando novas implementaçõe e ate mesmo a manutenção da aplicação.


### Transações concorrentes
Não implementei uma solução de concorrencia, mas acredito que poderiamos abordar da seguinte forma

Controlar as requisiçoes com uma abordagem orientada a eventos e assim permitir o processamento atravez de uma fila SQS. Existem outras medidas que poderiamos abordar com o auxilio de uma base nao relacional mas seria mais claro a abordagem entrando mais a fundo na solução proposta.

### Comandos

Criar banco de dados com docker-compose

> docker-compose up

Iniciar o projeto

> ./mvnw  spring-boot:run