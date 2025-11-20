# TRABALHO TCC USP - ENGENHARIA DE SOFTWARE
Trabalho de TCC em engenharia de software elaborado pelo aluno Matheus Reis Costa. Trata-se de uma aplicação criada
para a gestão de um investário de dados no contexto da LGPD, com base em planilha do Ministério da Gestão e Informação, disponibilizada
para esse fim.

## Requisitos

Antes de iniciar, certifique-se de ter instalado em seu ambiente:

- **Docker**
- **Extensão do Docker para VS Code**

## Passos para rodar o container:

1. Acesse a pasta do módulo:
   ```sh
   cd [caminho da pasta local]
2. Build as imagens que estão no arquivo docker-compose:
   ```sh
   docker-compose build
   ```
3. Inicie os containers com o Docker Compose:
   ```sh
   docker-compose up -d
   ```
4. Para interromper a execução, utilize:
   ```sh
   docker-compose down -v
   ```
## Informações Gerais

5. Para visualizar se os containers estão rodando:
   ```sh
   docker ps
   ```
6. Para acessar a documentação das APIs:
   ```sh
   http://localhost:9001/docs-api-tcc.html
   ```