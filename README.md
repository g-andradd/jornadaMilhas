# Jornada Milhas

Bem-vindo ao projeto Jornada Milhas! Este projeto consiste em uma API desenvolvida em Java 17 e Spring 3.1.1, integrada ao Frontend, que fornece informações e recursos relacionados a possíveis destinos de viagem, bem como depoimentos de viajantes. Além disso, a aplicação também inclui uma integração com IA para gerar textos descritivos dos destinos.

## Tecnologias Utilizadas

- Java 17
- Spring 3.1.1
- MongoDB
- Maven

## Funcionalidades Principais

### Depoimentos

- **Buscar todos os depoimentos**: `GET /depoimentos`
- **Listar depoimentos para a página inicial**: `GET /depoimentos-home`
- **Inserir depoimento**: `POST /depoimentos`
- **Atualizar depoimento por ID**: `PUT /depoimentos/{id}`
- **Remover depoimento por ID**: `DELETE /depoimentos/{id}`

### Destinos

- **Buscar todos os destinos**: `GET /destinos`
- **Buscar destino por ID**: `GET /destinos/{id}`
- **Buscar destino por nome**: `GET /destinos?nome={nome}`
- **Inserir destino**: `POST /destinos`
- **Atualizar destino por ID**: `PUT /destinos/{id}`
- **Remover destino por ID**: `DELETE /destinos/{id}`

## Instruções de Execução

Para executar o projeto, siga os passos abaixo:

1. Certifique-se de ter o Java SE 17 instalado. [Download Java SE 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

2. Instale o MongoDB. [Download MongoDB](https://www.mongodb.com/try/download/community)

3. Clone o repositório do projeto:
   ```sh
   git clone https://github.com/g-andradd/jornadaMilhas.git
   ```
   
4. Navegue até o diretório do projeto:
   ```sh
   cd jornadaMilhas
   ```

5. Build e rode o projeto usando o Maven:
   ```sh
   mvn spring-boot:run
   ```

6. Acesse a API em http://localhost:8080.

## Integração de IA

A integração com IA foi realizada usando a biblioteca Java disponível no GitHub: [openai-java]([https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://github.com/TheoKanning/openai-java)). A biblioteca é utilizada para integrar uma aplicação feita em java Maven ou Gradle com a IA do openAI.

##Como Contribuir

Contribuições são bem-vindas! Siga os passos abaixo:

1. Fork o repositório
2. Crie uma branch para sua feature (git checkout -b minha-feature)
3. Commit suas mudanças (git commit -am 'Adicionando nova feature')
4. Push para a branch (git push origin minha-feature)
5. Abra um Pull Request

##Contato
Para dúvidas ou colaborações, entre em contato pelo e-mail: gabrielandraad@gmail.com
