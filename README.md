# API Relatórios Excel

API REST para geração de relatórios Excel com agregação de dados de múltiplas fontes.

## 📋 Sobre o Projeto

API desenvolvida para consolidar dados de diferentes tabelas e gerar relatórios Excel estruturados com múltiplas abas.

**Funcionalidades principais:**
- ✅ Geração de Excel com 4 abas automaticamente
- ✅ Dados de Pessoa, Remuneração, Vínculo e Dependentes
- ✅ Consulta via JPA com Native Queries
- ✅ Headers dinâmicos e customizáveis
- ✅ Download direto via API REST
- ✅ MapStruct para conversão de dados
- ✅ Spring Security integration
- ✅ Swagger documentation

---

## 🛠️ Tecnologias

| Tecnologia | Versão |
|------------|--------|
| **Java** | 8 |
| **Spring Boot** | 2.7.x |
| **Spring Data JPA** | ✅ |
| **Spring Security** | ✅ |
| **Apache POI** | 5.2.5 |
| **Lombok** | 1.18.4 |
| **MapStruct** | 1.4.2.Final |
| **Swagger** | 3.0.0 |
| **H2 Database** | Testes |

---

## 🏗️ Arquitetura

```
┌─────────────────────────────────────────────┐
│         GET /api/relatorios/{cpf}           │
│              (Controller)                    │
└────────────────┬────────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────────┐
│        DadosRelatorioFacade                 │
│         (Orkestração)                       │
└────────────────┬────────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────────┐
│        DadosRelatorioService                │
│      (Consolidação de Dados)                │
│      • Busca de 4 Repositories (JPA)        │
│      • MapStruct para conversão             │
└────────────────┬────────────────────────────┘
                 │
       ┌─────────┼─────────┬─────────┐
       │         │         │         │
       ▼         ▼         ▼         ▼
   ┌───────┐ ┌───────┐ ┌───────┐ ┌───────┐
   │Repo 1 │ │Repo 2 │ │Repo 3 │ │Repo 4 │
   │Pessoa │ │Remun. │ │Vínculo│ │Depend.│
   └───┬───┘ └───┬───┘ └───┬───┘ └───┬───┘
       │         │         │         │
       └─────────┴─────────┴─────────┘
                 │
            DATABASE (Native Queries)
                 │
                 ▼
┌─────────────────────────────────────────────┐
│      DadosRelatorioResponse (@Builder)      │
│          (Dados Consolidados)               │
└────────────────┬────────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────────┐
│           XlsxService (Apache POI)          │
│           Geração do Excel                  │
└────────────────┬────────────────────────────┘
                 │
                 ▼
         ┌───────────────┐
         │ relatorio.xlsx │
         │   (Download)   │
         └───────────────┘
```

---

## 📦 Estrutura do Projeto

```
src/main/java/com/exemplo/excelgenerator/
├── controller/
│   └── RelatorioController.java
├── facade/
│   └── DadosRelatorioFacade.java
├── service/
│   ├── DadosRelatorioService.java
│   └── XlsxService.java
├── repository/
│   ├── DadosPessoaRepository.java
│   ├── DadosRemuneracaoRepository.java
│   ├── DadosVinculoRepository.java
│   └── DadosDependenteRepository.java
├── mapper/
│   ├── DadosPessoaMapper.java (MapStruct)
│   ├── DadosRemuneracaoMapper.java (MapStruct)
│   └── DadosDependenteMapper.java (MapStruct)
├── entity/
│   ├── DadosPessoa.java
│   ├── DadosRemuneracao.java
│   └── DadosDependente.java
└── model/
    ├── DadosRelatorioResponse.java
    ├── DadosPessoaResponse.java
    ├── DadosRemuneracaoResponse.java
    ├── DadosVinculoResponse.java
    └── DadosDependenteResponse.java
```

---

## 🚀 Como Executar

```bash
# Clonar repositório
git clone https://github.com/cfrot/api-relatorios-excel.git

# Entrar no diretório
cd api-relatorios-excel

# Executar com Maven
./mvnw spring-boot:run

# Acessar
http://localhost:8080/api/relatorios/{cpf}
```

---

## 📊 Endpoint

### Gerar Relatório Excel

```http
GET /api/relatorios/{cpf}
```

**Resposta:**
- Content-Type: `application/vnd.openxmlformats-officedocument.spreadsheetml.sheet`
- Arquivo Excel (.xlsx) para download

**Abas geradas:**
1. **Dados Pessoa** - 4 colunas
2. **Dados Remuneração** - 7 colunas
3. **Dados Vínculo** - 9 colunas
4. **Dados Dependentes** - 5 colunas

---

## 🔧 Exemplo de Uso

### Com curl

```bash
curl -X GET http://localhost:8080/api/relatorios/12345678901 \
  --output relatorio.xlsx
```

---

## 📝 Features

### Controller
- Logs profissionais com SLF4J
- Spring Security integration
- Swagger documentation
- Tratamento de erros (400, 401, 403, 500)

### Service
- Agregação de dados de 4 fontes
- MapStruct para conversão automática
- Builder pattern para response

### Repository
- Spring Data JPA
- Native Queries otimizadas
- Projections para performance

### XlsxService
- Apache POI para geração de Excel
- 4 abas automáticas
- Headers dinâmicos
- Tratamento de dados vazios

---

## 👤 Autor

**Daniel Pacheco**
- GitHub: [@cfrot](https://github.com/cfrot)
- LinkedIn: [danielpachecopii](https://www.linkedin.com/in/danielpachecopii/)

---

## 📄 Licença

Este projeto é apenas para fins educacionais e demonstração.

---

_Status: Pronto para GitHub ✅_
