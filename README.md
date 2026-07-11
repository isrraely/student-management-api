# Student Management API

Uma API RESTful desenvolvida em Java com Spring Boot para o gerenciamento de registros de alunos, suas matérias e respectivas notas. Este projeto foi construído como parte de um desafio técnico, aplicando boas práticas de engenharia de software, arquitetura em camadas e tratamento global de exceções.

## 🚀 Tecnologias e Ferramentas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

*   **Java 23**
*   **Spring Boot 3.5.16**
*   **Spring Data JPA** (Persistência e mapeamento objeto-relacional)
*   **Spring Validation** (Validação de dados de entrada)
*   **H2 Database** (Banco de dados em memória)
*   **Lombok** (Redução de boilerplate code)
*   **Springdoc OpenAPI / Swagger** (Documentação da API)
*   **Maven** (Gerenciamento de dependências)

## 🏗️ Arquitetura do Projeto

A aplicação foi estruturada seguindo o padrão de arquitetura em camadas para garantir baixo acoplamento, alta coesão e facilidade de manutenção:

*   **Controller:** Responsável por receber as requisições HTTP e retornar as respostas.
*   **Service:** Isola as regras de negócio da aplicação.
*   **Repository:** Interfaces para comunicação direta com o banco de dados via Spring Data JPA.
*   **DTO (Data Transfer Object):** Classes utilizadas para transferir dados entre as camadas, blindando as entidades do banco de dados (Request e Response).
*   **Mapper:** Responsável pela conversão segura entre Entidades e DTOs.
*   **Exception:** Tratamento global de exceções (`GlobalExceptionHandler`) padronizando o retorno de erros para o cliente.

## ⚙️ Funcionalidades

*   **Carga Inicial de Dados:** A aplicação utiliza um `CommandLineRunner` em conjunto com o `ObjectMapper` (Jackson) para ler o arquivo `alunos-iniciais.json` e popular o banco de dados automaticamente na inicialização.
*   **Cadastro de Alunos:** Criação de novos registros de alunos com suas respectivas matérias e notas.
*   **Atualização de Alunos:** Modificação de dados pessoais e gestão das matérias cursadas (inclusão, alteração de notas ou exclusão).
*   **Listagem Completa:** Consulta de todos os alunos registrados e seu histórico.
*   **Listagem de Destaques:** Filtro específico para retornar apenas alunos que possuam matérias com nota final superior a 8.

## 💻 Como Executar o Projeto

### Pré-requisitos
*   **Java 23** instalado.
*   **Maven** instalado (ou utilize o *wrapper* incluído no projeto).

### Passos para execução
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/isrraely/student-management-api.git](https://github.com/isrraely/student-management-api.git)
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd student-management-api
    ```
3.  Execute a aplicação via Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  O servidor iniciará localmente na porta `8080`.

## 📖 Documentação da API (Swagger)

A API está totalmente documentada utilizando a especificação OpenAPI. Com a aplicação rodando, você pode acessar a interface do Swagger para explorar e testar todos os endpoints diretamente pelo navegador.

Para carregar a documentação correta da API:

1. Acesse a **URL do Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) (ou `http://localhost:8080/swagger-ui/index.html`).
2. Na barra de pesquisa no topo da página do Swagger (que por padrão pode carregar o link do *Petstore*), apague a URL existente e insira a rota da documentação local:
   **`http://localhost:8080/v3/api-docs`**
3. Clique no botão verde **"Explore"**. A interface será atualizada exibindo todos os endpoints da Student Management API.

## 🗄️ Acesso ao Banco de Dados (H2 Console)

O projeto utiliza o banco de dados em memória H2, o que significa que os dados são recriados a cada inicialização. Para visualizar as tabelas e realizar consultas SQL manuais, acesse o console do H2:

*   **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
*   **Driver Class:** `org.h2.Driver`
*   **JDBC URL:** `jdbc:h2:mem:studentdb`
*   **User Name:** `sa`
*   **Password:** *(deixe em branco)*

## 🔗 Endpoints Principais

Abaixo estão as rotas disponíveis na API (todas as requisições e respostas seguem o formato JSON):

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/alunos` | Cadastra um novo aluno com suas matérias e notas. |
| `PUT` | `/alunos/{matricula}` | Atualiza os dados de um aluno existente pelo número da matrícula. |
| `GET` | `/alunos` | Retorna a lista de todos os alunos cadastrados. |
| `GET` | `/alunos/notas-superiores` | Retorna os alunos que possuem notas superiores a 8. |