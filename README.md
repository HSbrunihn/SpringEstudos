# ⚡ SpringEstudos — Gabarito de Spring Boot & Java

> Repositório focado no estudo e aplicação de conceitos fundamentais do **Spring Boot**, **Clean Code** e **Arquitetura em Camadas** para o desenvolvimento de APIs RESTful robustas e escaláveis.

Este README funciona como um **gabarito de consulta rápida**: sempre que bater dúvida sobre uma anotação, verbo HTTP ou conceito de arquitetura, a resposta provavelmente está aqui.

---

## 📑 Sumário

- [Projetos neste repositório](#-projetos-neste-repositório)
- [Tecnologias utilizadas](#️-tecnologias-utilizadas)
- [Fundamentos REST — GET, POST, PUT, DELETE](#-fundamentos-rest--get-post-put-delete)
- [Arquitetura em camadas](#️-arquitetura-em-camadas)
- [Guia de anotações — Spring & Lombok](#-guia-de-anotações-spring--lombok)
  - [Componentes do Spring Framework](#-anotações-de-componentes-do-spring-framework)
  - [Persistência de dados (JPA / Hibernate)](#-anotações-da-persistência-de-dados-jpa--hibernate)
  - [Lombok (produtividade)](#-anotações-do-lombok-produtividade)
- [Erros comuns e como evitar](#-erros-comuns-e-como-evitar)

---

## 📂 Projetos neste repositório

| Pasta | Descrição |
| --- | --- |
| `pokemon-api/` | API REST estudando Spring Boot + JPA, usando Pokémon como domínio de exemplo |
| `Atividade-1/` | API de classificação de atendimento prioritário — Controller/Service/Entity, sem persistência em banco |

Cada pasta é um projeto Maven independente, com seu próprio `pom.xml`. Isso permite testar conceitos isolados sem misturar dependências entre atividades.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+** / **Java 21**
- **Spring Boot 3**
- **Spring Data JPA** (Persistência de Dados)
- **Spring Web** (Construção de APIs REST)
- **PostgreSQL / H2 Database**
- **Lombok** (Produtividade e redução de código boilerplate)
- **Maven** (Gerenciamento de dependências)

---

## 🌐 Fundamentos REST — GET, POST, PUT, DELETE

Antes das anotações, o essencial: cada verbo HTTP representa uma **intenção** diferente sobre um recurso.

| Verbo | Intenção | Exemplo de uso | Anotação Spring |
| --- | --- | --- | --- |
| **GET** | Consultar, sem alterar nada | Buscar um Pokémon pelo ID | `@GetMapping` |
| **POST** | Criar algo novo | Cadastrar um Pokémon capturado | `@PostMapping` |
| **PUT** | Atualizar por completo um recurso existente | Editar todos os dados de um Pokémon | `@PutMapping` |
| **DELETE** | Remover um recurso | Soltar um Pokémon do registro | `@DeleteMapping` |

**Como referenciar dados na requisição:**

```java
@GetMapping("/{id}")
public Pokemon buscar(@PathVariable Long id) { ... }
// @PathVariable -> pega um valor direto da URL, ex: /pokemons/25

@GetMapping
public List<Pokemon> filtrar(@RequestParam String tipo) { ... }
// @RequestParam -> pega um valor de query string, ex: /pokemons?tipo=fogo

@PostMapping
public Pokemon criar(@RequestBody Pokemon novo) { ... }
// @RequestBody -> converte o JSON do corpo da requisição em um objeto Java
```

**Regra de ouro:** GET não muda o mundo, só consulta. POST/PUT/DELETE alteram o estado do sistema.

---

## 🏛️ Arquitetura em Camadas

O projeto segue a divisão clássica em camadas para garantir a **separação de responsabilidades** e manter os componentes desacoplados e testáveis.

```
Requisição HTTP
      │
      ▼
 Controller   →  recebe o pedido, não sabe nada de regra de negócio
      │
      ▼
  Service     →  aplica a regra de negócio, é o "cérebro" da aplicação
      │
      ▼
Repository    →  conversa com o banco de dados (quando existe persistência)
      │
      ▼
  Entity      →  representa os dados (tabela do banco ou objeto de transporte)
```

Cada camada só conhece a camada logo abaixo dela. O Controller nunca deveria calcular regra de negócio sozinho — isso é papel exclusivo da Service.

---

## 📚 Guia de Anotações (Spring & Lombok)

Como este repositório possui foco em aprendizagem, abaixo estão documentadas as principais anotações utilizadas no código e o motivo de sua aplicação:

### 🟢 Anotações de Componentes do Spring Framework

| Anotação | Camada | Argumento & Finalidade |
| --- | --- | --- |
| `@RestController` | **Controller** | Combina `@Controller` e `@ResponseBody`. Informa ao Spring que esta classe gerencia requisições HTTP e que as respostas serão serializadas diretamente em formato **JSON** (ou XML). |
| `@RequestMapping` | **Controller** | Mapeia a URL base da classe ou método (ex: `@RequestMapping("/api/v1/pokemons")`). Garante a padronização das rotas RESTful. |
| `@GetMapping` / `@PostMapping` / `@PutMapping` / `@DeleteMapping` | **Controller** | Atalhos de `@RequestMapping` já amarrados a um verbo HTTP específico. |
| `@PathVariable` | **Controller** | Extrai um valor direto do caminho da URL (ex: `/pokemons/{id}`). |
| `@RequestParam` | **Controller** | Extrai um valor de query string (ex: `?tipo=fogo`). |
| `@RequestBody` | **Controller** | Converte automaticamente o JSON do corpo da requisição em um objeto Java. |
| `@Service` | **Service** | Marca a classe como um **Componente de Serviço**. É onde reside toda a regra de negócio do sistema. O Spring instancia e gerencia esse componente automaticamente no container de IoC/DI. |
| `@Repository` | **Repository** | Identifica a interface ou classe responsável pela persistência e comunicação com o banco de dados, além de traduzir exceções de banco para exceções do Spring (`DataAccessException`). |
| `@Autowired` | **Geral** | Injeta dependências gerenciadas pelo Spring. *Nota:* Por boas práticas de Clean Code, prioriza-se a **Injeção de Dependências via Construtor** (com auxílio do Lombok `@RequiredArgsConstructor`), dispensando essa anotação. |

### 🟣 Anotações da Persistência de Dados (JPA / Hibernate)

| Anotação | Finalidade |
| --- | --- |
| `@Entity` | Especifica que a classe representa uma tabela no banco de dados relacional. |
| `@Table` | Permite customizar o nome da tabela no banco (ex: `@Table(name = "tb_pokemons")`). |
| `@Id` | Define a Chave Primária (*Primary Key*) da entidade. |
| `@GeneratedValue` | Define a estratégia de geração automática de ID (ex: `GenerationType.IDENTITY` ou `UUID`). |

### 🔴 Anotações do Lombok (Produtividade)

| Anotação | Argumento & Finalidade |
| --- | --- |
| `@Data` | Anotação utilitária "tudo-em-um". Gera automaticamente `getters`, `setters`, `toString()`, `equals()`, `hashCode()` e um construtor básico. Reduz o código boilerplate. |
| `@Getter` / `@Setter` | Gera isoladamente apenas os leitores ou gravadores de atributos (útil quando não se quer expor setters desnecessários em entidades imutáveis). |
| `@NoArgsConstructor` | Gera um construtor sem argumentos (obrigatório para o funcionamento interno da especificação JPA/Hibernate). |
| `@AllArgsConstructor` | Gera um construtor com todos os parâmetros contidos na classe, na ordem em que os campos aparecem. |
| `@Builder` | Implementa o Design Pattern **Builder**, permitindo instanciar objetos com sintaxe fluente e legível (ex: `Pokemon.builder().nome("Pikachu").build()`). |
| `@RequiredArgsConstructor` | Gera um construtor com campos anotados como `final`. É a **forma recomendada para injeção de dependências no Spring**, dispensando o uso de `@Autowired`. |

**Exemplo prático combinando Lombok numa entidade de saída:**

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saida {
    private String nome;
    private String tipoAtendimento;
    private String mensagem;
}
```

Sem essas três anotações, seriam necessárias ~15 linhas extras de getters, setters e construtores escritos manualmente.

---

## ⚠️ Erros comuns e como evitar

| Erro | Causa | Solução |
| --- | --- | --- |
| `NullPointerException` ao comparar `Boolean` | Usar `variavel == true` num campo `Boolean` (objeto) que veio `null` do JSON | Usar `Boolean.TRUE.equals(variavel)` |
| Corpo da requisição chega vazio no Controller | Esqueceu o `@RequestBody` no parâmetro | Adicionar `@RequestBody` explicitamente |
| Spring não encontra a Service pra injetar | Esqueceu o `@Service` na classe | Adicionar `@Service` no topo da classe |
| Hibernate não consegue criar a entidade | Faltou `@NoArgsConstructor` numa entidade JPA | Adicionar `@NoArgsConstructor` junto com `@AllArgsConstructor` |

---

*Gabarito mantido como parte dos estudos de Spring Boot. Sinta-se à vontade para expandir conforme novos conceitos forem aprendidos.*
