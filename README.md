# Hachi Crepe e Tayaki - API 

> Atualizar este template conforme desenvolvimento!

API REST do sistema de fidelidade da **Hachi Crepe e Tayaki**, desenvolvida pela equipe **H8**, como 
**Projeto de Extensão** do 
2º Período do Curos de Ciência da **Computação da Faculdade** Sâo Paulo Tech School ([SPTech](https://sptech.school/)),

## Sumário

- [Sobre o projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias utilizadas](#tecnologias)
- [Arquitetura do projeto](#arquitetura)
- [Pré-requisitos](#pre-requisitos)
- [Instalação e configuração](#instalacao-e-configuracao)
- [Executando a aplicação](#execucao)
- [Documentação da API](#documentacao-api)
- [Testes](#testes)
- [Estruturas de diretórios](#estrutura-de-diretorios)
- [Variáveis de ambiente](#variaveos-de-ambiente)
- [Segurança](#seguranca)
- [Contribuição](#contribuicao)
- [Liçenca](#licenca)

## Sobre o Projeto

O sistema de fidelidade da Hachi Crepe e Tayaki tem como objetivo promover o relacionamento com os clientes por meio 
de um programa de recompensas.

Esta API é responsável por disponibilizar os serviços de backend necessários para o funcionamento do sistema, 
incluindo o gerenciamento de clientes, o registro de atividades de fidelidade e o controle de pontos e recompensas.

### Objetivos principais

- Centralizar as regras de negócio do programa de fidelidade
- Disponibilizar endpoints para integração com as aplicações clientes
- Garantir a integridade das operações e dos dados
- Facilitar a manutenção e a evolução do sistema

## Funcionalidades

> Atualizar esta seção conforme evolução do projeto

- [ ] Cadastro e gerenciamento de clientes.
- [ ] Consulta de saldo de pontos.
- [ ] Registro de movimentação de pontos.
- [ ] Acúmulo de pontos.
- [ ] Resgate de recompensas.
- [ ] Autenticação e autorização
- [ ] Validação de dados de entrada.
- [ ] ...
- [ ] Documentação dos endpoints
- [ ] Testes automatizados

## Tecnologias utilizadas

| **Tecnologia** | **Finalidade**|
|----------------|---------------|
| Java 21 / Spring Boot |Linguagem e Framework de ambiente de execução| 
| MySQL | Banco de dados |
|     ...  |   ...             |

> Manter somente as tecnologias realmente utilizadas no projeto.

## Arquitetura do projeto

...


## Pré-requesitos

...


## Instalação e configuração

...

## Executando a aplicação

...

## Documentação da API

| **Método** | **Endpoint** | **Descrição** |
|------------|--------------|---------------|
| GET        | `/health`    | Verifica a disponibilidade da aplicação. |
| ... | ... | ... |

> Atualizar cada endpoint

## Testes

## Estrutura de diretórios

```plaintext
.
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── hachi
    │   │           └── api
    │   │               ├── ApiApplication.java
    │   │               ├── controller
    │   │               │   └── UsuarioController.java
    │   │               └── model
    │   │                   ├── Usuario.java
    │   │                   └── UsuarioResponse.java
    │   └── resources
    │       ├── application.properties
    │       └── schema.sql
    └── test
        └── java
            └── com
                └── hachi
                    └── api
                        └── ApiApplicationTests.java

```

> Utilizar o comando `tree` para listar estrutura

## Variáveis de ambiente

| **Variável** | **Descrição** | **Obrigatória** |
| -------------| --------------| ----------------|
| APP_ENV | Ambiente de execução | Conforme configuração |
|... | ... | ... |

## Segurança

...

## Contribuição

...

## Licença

...

--- 

## Estratégia de Branches

O projeto utiliza uma estratégia de branches para organizar o desenvolvimento, validar alterações e manter a estabilidade do código disponibilizado em produção.

### Branches principais

| Branch | Ambiente        | Finalidade                                                                         |
| ------ | --------------- | ---------------------------------------------------------------------------------- |
| `main` | Produção        | Contém a versão estável da API, considerada apta para produção.                    |
| `dev`  | Desenvolvimento | Centraliza as novas funcionalidades, melhorias e correções em desenvolvimento.     |
| `hom`  | Homologação     | Recebe versões candidatas para validação e testes antes da publicação em produção. |

### Fluxo de desenvolvimento

O fluxo padrão de promoção de código segue esta sequência:

```text
feature/* ──► dev ──► hom ──► main
                │       │       │
                ▼       ▼       ▼
          Desenvolvimento  Homologação  Produção
```

1. **Desenvolvimento (`dev`):** novas funcionalidades e correções são implementadas em branches específicas e integradas à `dev` por meio de Pull Requests.
2. **Homologação (`hom`):** após a validação inicial, as alterações aprovadas em `dev` são integradas à `hom`, onde são realizados testes de integração, validação funcional e verificação dos requisitos.
3. **Produção (`main`):** somente versões aprovadas em homologação podem ser promovidas para `main`, após revisão e autorização para publicação.

### Convenção de nomenclatura

Branches temporárias devem utilizar prefixos que identifiquem o propósito da alteração.

| Prefixo     | Finalidade                       | Exemplo                         |
| ----------- | -------------------------------- | ------------------------------- |
| `feature/`  | Nova funcionalidade              | `feature/customer-registration` |
| `fix/`      | Correção de defeito              | `fix/points-calculation`        |
| `hotfix/`   | Correção urgente em produção     | `hotfix/duplicate-redemption`   |
| `refactor/` | Refatoração de código            | `refactor/customer-service`     |
| `docs/`     | Alterações na documentação       | `docs/api-readme`               |
| `test/`     | Criação ou atualização de testes | `test/points-service`           |

Exemplo de criação de uma branch de funcionalidade:

```bash
git switch dev
git pull origin dev
git switch -c feature/customer-registration
```

Após implementar e testar a alteração, publique a branch e abra um Pull Request para `dev`:

```bash
git push -u origin feature/customer-registration
```

### Regras de integração

* Não realizar commits diretamente em `main`, `hom` ou `dev`; utilizar Pull Requests.
* Toda alteração deve passar por revisão antes de ser integrada às branches principais.
* A branch `dev` deve conter código integrado e testado em nível de desenvolvimento.
* A branch `hom` deve receber apenas versões candidatas que passaram pelas verificações iniciais.
* A branch `main` deve conter somente versões aprovadas para produção.
* Correções urgentes em produção devem ser realizadas em branches `hotfix/*`, revisadas e integradas à `main`.
* Após um hotfix, as correções também devem ser propagadas para `hom` e `dev`, evitando divergências entre as branches.
* Os conflitos devem ser resolvidos e os testes executados antes da conclusão de qualquer merge.

### Processo de publicação

A publicação de uma nova versão deve seguir as seguintes etapas:

1. Implementação e revisão das alterações em `dev`.
2. Integração da versão candidata em `hom`.
3. Execução dos testes e aprovação da homologação.
4. Merge da versão aprovada em `main`.
5. Criação de uma tag de versão, quando aplicável.
6. Deploy da versão aprovada no ambiente de produção.

**Importante:** a integração de código em uma branch não implica, por si só, a publicação automática no ambiente correspondente. Os processos de deploy devem ser configurados separadamente.
