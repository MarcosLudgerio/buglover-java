# :books: API Restful para treinamento
<div align="center" display="flex" style="justify-content:flex-start;">
      <img align="center" alt="js" height="200" width="200" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" />
</div>

<p align="center">
 <a href="#desc">Descrição</a> •
 <a href="#about">O que a API faz?</a> •
 <a href="#rotas">Rotas</a> •
 <a href="#exemplos">Modelos</a> •
 <a href="#tecnologias">Tecnologias</a> • 
 <a href="#prerequisitos">Pré requisitos</a> • 
 <a href="#executando">Executar o projeto</a> • 
 <a href="#autor">Autor</a>
</p>

<div id="desc"/>

## 📝 Descrição
Este projeto é uma API restful desenvolvida utilizando o framework **Spring Boot** na v3.0. <br>
O desenvolvimento da aplicação foi feito para aplicar conceitos de API Rest utilizando boas praticas de programação Java. <br>
O código fonte está disponível [aqui](https://github.com/MarcosLudgerio/buglover-java/tree/main/appPessoas) <br>

<div id="about"/>

## ⚙️ O que a API faz?
A API Restful da suporte a cadastro de pessoas associadas a endereços. <br>
Consiste em dois módulos: Pessoa e Endereços, onde uma pessoa possui um único endereço <br>
Para cadastrar uma pessoa é necessário informar obrigatóriamente o nome e o documento<br>
Para cadastrar um endereço é necessário primeiramente possuir uma pessoa cadastrada na base e informar os campos especificados abaixo <br>

<div id="exemplos"/>

## 📑 Exemplos
##### JSON para criação de pessoa: <br>
```json
{
   "nome": "Raimundo",
   "documento": "123456-78"
   
}
```

##### JSON para criação de poster: <br>
```json
{
  "tipoLogradouro": "RUA",
  "logradouro": "Rua da Esquerda",
  "cep": "12345678",
  "cidade": "João Pessoa",
  "uf": "PB",
  "pessoa": {
    "id": 1
  }
}
```

<div id="rotas" />

## :busstop: Rotas

### Pessoa:
- [ ] POST /api/pessoas
- [ ] GET /api/pessoas
- [ ] GET /api/pessoas/id
- [ ] PUT /api/pessoas
- [ ] DELETE /api/pessoas/id

### Endereço
- [ ] GET /api/enderecos
- [ ] GET /api/enderecos/id
- [ ] GET /api/enderecos/pessoa/id
- [ ] POST /api/enderecos
- [ ] PUT /api/enderecos
- [ ] DELETE /api/enderecos/id


<div id="tecnologias"/>

## ✨ Tecnologias

-   [ ] [Java](https://www.java.com/pt-BR/)
-   [ ] [Spring Boot](https://spring.io/)
-   [ ] [Project Lombok](https://projectlombok.org/)
-   [ ] [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
-   [ ] [Swagger](https://swagger.io/)
-   [ ] [Hibernate](https://hibernate.org/)

<div id="executando" />

## ▶️ Executando o projeto

#### Para executar em sua máquina:
Abra o terminal e execute os seguintes comandos: 
```sh
$ git clone https://github.com/MarcosLudgerio/buglover-java.git
$ cd buglover-java
$ cd appPessoas
$ ./mvnw spring-boot:run
```

<div id="autor" />

## 👩‍💻 Autor

<table>
   <tr>
     <td align="center">
        <a href="https://github.com/MarcosLudgerio">
         <img style="border-radius: 50%;" src="https://avatars0.githubusercontent.com/u/43012976?s=460&u=1163c04d9f35b577063b3f6550ae520c4dd2f866&v=4" width="100px;" alt=""/>
        </a>
        <br/><sub><b>Raimundo Marcos</b></sub>
     </td>
   </tr>
</table>