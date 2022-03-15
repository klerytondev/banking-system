# System Banking
API Restful genérica que realiza alguns serviços bancários.

# Funcionalidades
1. Gerenciamento de banco (CRUD completo)
2. Gerenciamento de accounts (CRUD Completo)
3. Gerenciamento de cards (CRUD completo)
4. Gerenciamento de typeCards (CRUD completo)

# Documentação
*  A documentação da API foi gerada com Swagger e está disponível em http://localhost:8080/

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [JDK11](https://www.oracle.com/java/technologies/downloads/#java11), [MAVEN 3](https://maven.apache.org/index.html) e [MYSQL](https://www.mysql.com/downloads/). 
Além disto é bom ter um editor para trabalhar com o código como [Spring Tools](https://spring.io/tools)

# Executar a aplicação
Primeiro é necessário iniciar seu banco de dados MySQL. É necessário criar as tabelas do banco. A API faz isso para você se na primeira execução você utilizar a seguinte propriedade spring.datasource.url=jdbc:mysql://localhost:3306/BD_banking?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false a base é denominada 'BD_banking' e o banco por padrão é criado desde que o MYSQL tenha sido inicializado, os seguintes dados são utilizados:

# Executar a aplicação
```bash
#Servidor Web
server.port=8080
```

# Application-prod.properties
```bash
#spring.datasource.url=jdbc:mysql://localhost:3306/BD_banking?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false

spring.datasource.username=root
spring.datasource.password=root

#Dialeto SQL melhorar o SQL gerado pelo Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

#Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=none

spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
```


### Features

- [x] Gerenciamento de banco
- [ ] Gerenciamento de accounts
- [ ] Gerenciamento de cards
- [ ] Gerenciamento de typeCards
- [ ] Validações
- [ ] Documentação Swagger
- [ ] Tratamento de exceções
- [ ] Deploy project on AWS

