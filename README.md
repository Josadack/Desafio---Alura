# 🎬 ScreenMatch Frases --- Full Stack (Desafio Alura)

Projeto desenvolvido como parte do desafio **ScreenMatch** da **Alura**,
simulando um sistema real de mercado:\
um **backend em Java + Spring Boot** que fornece frases aleatórias de
séries e um **frontend em HTML, CSS e JavaScript** que consome essa API
e exibe as informações dinamicamente ao usuário.

O diferencial aqui não é só "funcionar", mas mostrar **integração real
entre front e back**, separação de responsabilidades e boas práticas de
arquitetura.

------------------------------------------------------------------------

## 🎯 Objetivo do Projeto

Construir uma aplicação completa onde:

-   O **backend** expõe uma API REST que retorna uma frase aleatória de
    série.
-   O **frontend** consome essa API via `fetch` e atualiza a interface
    sem recarregar a página.
-   O usuário pode clicar em **"Ver outras frases..."** para carregar
    novas frases dinamicamente.
-   Dados são persistidos em um banco relacional usando **Spring Data
    JPA**.
-   A API retorna um **DTO**, evitando expor diretamente a entidade do
    banco.

------------------------------------------------------------------------

## 🧠 Arquitetura Geral

Fluxo de comunicação do sistema:

    Frontend (HTML + JS)
            |
       fetch GET
            |
    /series/frases
            |
    Spring Boot API
            |
    Service -> Repository -> Banco
            |
         JSON (FraseDTO)
            |
    Frontend renderiza na tela

Ou, em versão dev-friendly:

> Botão → JS chama API → Spring busca no banco → devolve JSON → página
> atualiza na hora.

------------------------------------------------------------------------

## 🗂️ Estrutura do Projeto

### 📌 Backend

    br.com.alura.sreenmatch_frases
    │
    ├── controller
    │   └── FraseController.java
    │
    ├── service
    │   └── FraseService.java
    │
    ├── repository
    │   └── FraseRepository.java
    │
    ├── model
    │   └── Frase.java
    │
    └── DTO
        └── FraseDTO.java

### 📌 Frontend

    /
    │── index.html
    │── style.css
    │── /scripts
    │   ├── index.js
    │   └── getDados.js
    │── /img
    │   └── logo.png

------------------------------------------------------------------------

## 🔌 Endpoint da API

    GET /series/frases

Resposta exemplo:

``` json
{
  "titulo": "Breaking Bad",
  "frase": "I am the one who knocks!",
  "personagem": "Walter White",
  "poster": "https://link-do-poster.jpg"
}
```

------------------------------------------------------------------------

## 🧩 Como o Frontend Funciona

### index.html

-   Layout estático e estrutura visual.
-   Contém um botão com a classe `.btn-sortear`.
-   Possui um container `<div id="ficha-descricao">` onde as informações
    são inseridas dinamicamente.

### index.js

O script:

-   Faz `GET /series/frases`.
-   Recebe o JSON do backend.
-   Monta dinamicamente o HTML com:
    -   imagem do poster\
    -   título da série\
    -   frase icônica\
    -   personagem

Snippet essencial:

``` js
btnSortear.addEventListener('click', carregarInfoSerie);
window.onload = carregarInfoSerie();
```

Ou seja:\
carrega uma frase ao abrir a página e permite sortear outra a cada
clique.

### style.css

Estilização moderna com:

-   Background em degradê\
-   Layout flexível\
-   Responsividade básica para mobile\
-   Botão chamativo e interativo\
-   Tipografia limpa com Google Fonts

Nada de CSS bagunçado: organização clara e legível.

------------------------------------------------------------------------

## 🗄️ Banco de Dados

A entidade `Frase` mapeia a tabela `frases`:

  coluna       tipo
  ------------ --------
  id           bigint
  titulo       text
  frase        text
  personagem   text
  poster       text

A consulta aleatória é feita com:

``` sql
SELECT f FROM Frase f ORDER BY FUNCTION('RANDOM') LIMIT 1
```

Funciona bem em PostgreSQL e H2.

------------------------------------------------------------------------

## 🚀 Como Rodar o Projeto

### 1) Backend

No diretório do backend:

``` bash
mvn spring-boot:run
```

A API ficará disponível em:

    http://localhost:8080/series/frases

### 2) Frontend

Você pode abrir direto no navegador:

    index.html

Ou rodar com Live Server no VS Code.

> Importante: o front assume que o backend está rodando em
> `localhost:8080`.

------------------------------------------------------------------------

## 🛠️ Tecnologias Utilizadas

### Backend

-   Java 17+
-   Spring Boot\
-   Spring Web\
-   Spring Data JPA\
-   Hibernate\
-   PostgreSQL ou H2

### Frontend

-   HTML5\
-   CSS3\
-   JavaScript (ES Modules)\
-   Fetch API\
-   Google Fonts

------------------------------------------------------------------------

## 📚 O que foi aprendido com esse desafio

-   Construção de **API REST limpa**
-   Uso correto de **DTO**
-   Mapeamento JPA com `@Entity`
-   Queries customizadas com `@Query`
-   Integração **front + back real**
-   Manipulação do DOM com JavaScript
-   Consumo de API via `fetch`
-   Responsividade básica em CSS
-   Separação clara de responsabilidades

Em resumo:\
\> não é só código, é **arquitetura de aplicação de verdade**.

------------------------------------------------------------------------

## 👨‍💻 Autor

**Josadaque Ferreira (J Dack)**\
Desenvolvedor Back-end / Full Stack Júnior

GitHub: https://github.com/Josadack\
LinkedIn: https://www.linkedin.com/in/josadaque-ferreira
