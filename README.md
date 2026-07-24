# ⚡ Pokémon API — Spring Boot & Java

> Repositório focado no estudo e aplicação de conceitos fundamentais do **Spring Boot**, **Clean Code** e **Arquitetura em Camadas** para o desenvolvimento de APIs RESTful robustas e escaláveis.

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

## 🏛️ Arquitetura e Anotações Principais

O projeto segue a divisão clássica em camadas para garantir a **separação de responsabilidades** e manter os componentes desacoplados e testáveis.

---

### 📚 Guia de Anotações (Spring & Lombok)

Como este repositório possui foco em aprendizagem, abaixo estão documentadas as principais anotações utilizadas no código e o motivo de sua aplicação:

#### 🟢 Anotações de Componentes do Spring Framework

| Anotação | Camada | Argumento & Finalidade |
| :--- | :--- | :--- |
| `@RestController` | **Controller** | Combina `@Controller` e `@ResponseBody`. Informa ao Spring que esta classe gerencia requisições HTTP e que as respostas serão serializadas diretamente em formato **JSON** (ou XML). |
| `@RequestMapping` | **Controller** | Mapeia a URL base da classe ou método (ex: `@RequestMapping("/api/v1/pokemons")`). Garante a padronização das rotas RESTful. |
| `@Service` | **Service** | Marca a classe como um **Componente de Serviço**. É onde reside toda a regra de negócio do sistema. O Spring estancia e gerencia esse componente automaticamente no container de IoC/DI. |
| `@Repository` | **Repository** | Identifica a interface ou classe responsável pela persistência e comunicação com o banco de dados, além de traduzir exceções de banco para exceções do Spring (`DataAccessException`). |
| `@Autowired` | **Geral** | Injeta dependências gerenciadas pelo Spring. *Nota:* Por boas práticas de Clean Code, prioriza-se a **Injeção de Dependências via Construtor** (com auxílio do Lombok `@RequiredArgsConstructor`). |

---

#### 🟣 Anotações da Persistência de Dados (JPA / Hibernate)

| Anotação | Finalidade |
| :--- | :--- |
| `@Entity` | Especifica que a classe representa uma tabela no banco de dados relacional. |
| `@Table` | Permite customizar o nome da tabela no banco (ex: `@Table(name = "tb_pokemons")`). |
| `@Id` | Define a Chave Primária (*Primary Key*) da entidade. |
| `@GeneratedValue` | Define a estratégia de geração automática de ID (ex: `GenerationType.IDENTITY` ou `UUID`). |

---

#### 🔴 Anotações do Lombok (Produtividade)

| Anotação | Argumento & Finalidade |
| :--- | :--- |
| `@Data` | Anotação utilitária "tudo-em-um". Gera automaticamente os métodos `getters`, `setters`, `toString()`, `equals()`, `hashCode()` e um construtor básico. Reduz o código boilerplate. |
| `@Getter` / `@Setter` | Gera isoladamente apenas os leitores ou gravadores de atributos (útil quando não se quer expor setters desnecessários em entidades imutáveis). |
| `@NoArgsConstructor` | Gera um construtor sem argumentos (obrigatório para o funcionamento interno da especificação JPA/Hibernate). |
| `@AllArgsConstructor` | Gera um construtor com todos os parâmetros contidos na classe. |
| `@Builder` | Implementa o Design Pattern **Builder**, permitindo instanciar objetos com sintaxe fluente e legível (ex: `Pokemon.builder().nome("Pikachu").build()`). |
| `@RequiredArgsConstructor` | Gera um construtor com campos anotados como `final`. É a **forma recomendada para injeção de dependências no Spring**, dispensando o uso de `@Autowired`. |
