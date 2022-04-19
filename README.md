# BancoVeiculos
Um microsserviço que consome dados de aeronaves de um servidor RabbitMQ, persiste em um banco de dados e disponibiliza ações básicas de CRUD através de uma API REST.

É necessário instalar a biblioteca [RabbitMqLibrary](https://github.com/marcelosbar/RabbitMqLibrary) no repositório Maven local para rodar esse projeto.

O projeto utiliza o Eureka, da Netflix, como serviço de descoberta.
