# System Banking
API Restful genérica que realiza alguns serviços bancários.

# Funcionalidades
1. Gerenciamento de banco (CRUD completo)
2. Gerenciamento de accounts (CRUD Completo)
3. Gerenciamento de cards (CRUD completo)
4. Gerenciamento de typeCards (CRUD completo)

# Documentação
*  A documentação da API foi gerada com Swagger e está disponível em ``` http://localhost:8080/banco-api/swagger-ui.html```

# Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [JDK11](https://www.oracle.com/java/technologies/downloads/#java11), [MAVEN 3](https://maven.apache.org/index.html) e [MYSQL](https://www.mysql.com/downloads/). 
Além disto é bom ter um editor para trabalhar com o código como [Spring Tools](https://spring.io/tools)

# Executar a aplicação
Primeiro é necessário iniciar seu banco de dados MySQL. É necessário criar as tabelas do banco. A API faz isso para você se na primeira execução você utilizar a seguinte propriedade ```spring.datasource.url=jdbc:mysql://localhost:3306/BD_banking?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false``` a base é denominada 'BD_banking' e o banco por padrão é criado desde que o MYSQL tenha sido inicializado, os seguintes dados são utilizados:

# application.properties
```bash
# Servidor Web
server.port=8080

# Spring DATASOURCE (DataSourceProperties)
spring.datasource.url=jdbc:mysql://localhost:3306/BD_banking?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false

spring.datasource.username=root
spring.datasource.password=root

# Hibernate ddl auto (update)
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
```
# Principais técnologias utilizadas
1. Java JDK 11
2. Maven 3
3. MySQL Database
4. Spring Boot 2.6.4
5. JWT
6. Swagger 

### funcionalidades
- [x] Gerenciamento de banco
- [ ] Gerenciamento de accounts
- [x] Gerenciamento de cards
- [x] Gerenciamento de typeCards
- [ ] Validações
- [x] Documentação Swagger
- [ ] Tratamento de exceções
- [ ] Deploy project on AWS

### Status do Projeto
<h4 align="left"> 
	🚧  React Select 🚀 Em construção...  🚧
</h4>

### Autor
---
<a href="https://github.com/klerytondev/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/klerytondev" width="100px;" alt=""/>
 <br />
 <sub><b>Kleryton Souza</b></sub></a> <a>🚀</a>

Made by Kleryton de Souza 👋🏽 Entre em contato!

[![Twitter Badge](https://img.shields.io/badge/-@SouzaKleryton-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/SouzaKleryton)](https://twitter.com/SouzaKleryton) [![Linkedin Badge](https://img.shields.io/badge/-kleryton-souza?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/kleryton-souza-a1733673/)](https://www.linkedin.com/in/kleryton-souza-a1733673/) 
[![Gmail Badge](https://img.shields.io/badge/kleryton.dev@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:kleryton.dev@gmail.com)](mailto:kleryton.dev@gmail.com)

# Copyright
Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
