# 📚 Atividades - Tópicos Especiais em Informática (Spring Boot)

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-green.svg)
![Java](https://img.shields.io/badge/Java-17-blue.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)

Repositório dedicado às atividades da disciplina ministrada pelo **Professor Emanuel Mineda Carneiro** ✨

## 🗂️ Estrutura do Projeto

src/ <br>
├── main/ <br>
│ ├── java/com/example/demo/ <br>
│ │ ├── controllers/ # 🎮 Controladores REST <br>
│ │ ├── models/ # 🏗️ Classes que mapeiam BD <br>
│ │ ├── repository/ # 💾 Camada de persistência <br>
│ │ ├── services/ # ⚙️ Lógica de negócio <br>
│ │ └── Prova01Application.java <br>
│ └── resources/ # ⚙️ Configurações <br>
└── test/ # 🧪 Testes <br>


## :rocket: Atividade 1

### :red_circle: Trabalho

Execute o seguinte comando no PostgreSQL (ou crie tabela similar no SGBD de sua preferência):

   ```bash
   create table tra_trabalho (
     tra_id bigint generated always as identity,
     tra_titulo varchar(100) not null unique,
     tra_data_hora_entrega timestamp not null,
     tra_descricao varchar(200),
     tra_grupo varchar(20) not null,
     tra_nota int,
     tra_justificativa varchar(100));

   insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_grupo, tra_nota, tra_justificativa)
   values ('Teste 1', current_timestamp, 'Alpha', 6, 'Bom, mas falta conteúdo'),
   ('Teste 2', current_timestamp, 'Beta', null, 'Incompleto');
   ```

**1. Classe Entity (Model)** <br>
Crie uma classe que mapeie a tabela criada. <br>
| Página do Projeto                                                                   | Pasta            | 
| :---------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe TrabalhoModel.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/models/TrabalhoModel.java) | Models | 


**2. Interface Repository** <br>
Crie um repositório para a classe criada no item 1 contendo uma consulta capaz de buscar todos os trabalhos que contenham uma palavra dentro de seu título com nota superior a um número inteiro. Tanto a palavra quanto o número devem ser recebidos como parâmetro do método. <br>
| Página do Projeto                                                                           | Pasta            | 
| :------------------------------------------------------------------------------------------ | :--------------- | 
| [Link para interface TrabalhoRepository.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/repository/TrabalhoRepository.java) | Repository | 


**3. Classe Service** <br>
Crie um serviço com 3 métodos: um para cadastro, um para listar todos os registros da tabela e outro para buscar usando a consulta criada no item 2. No cadastro verifique se o título e o grupo estejam preenchidos, lançando um erro em caso contrário. Ainda no cadastro, use a data/hora atual se a data/hora de entrega não estiver preenchida. <br>
| Página do Projeto                                                                     | Pasta            | 
| :------------------------------------------------------------------------------------ | :--------------- | 
| [Link para classe TrabalhoService.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/services/TrabalhoService.java) | Services | 


**4. Classe Controller** <br>
Crie um controller que atenda na URL “\trabalho” e contenha 3 rotas: uma para cadastro, outra para listar todos os registros e uma última para executar a busca por título e nota criada no item 2. <br>
| Página do Projeto                                                                        | Pasta            | 
| :--------------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe TrabalhoController.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/controllers/TrabalhoController.java) | Controllers | 


> Importante: Utilize java.time.LocalDateTime para mapear timestamp. <br>



## :rocket: Atividade 2

### :red_circle: Fonte

Execute o seguinte comando no PostgreSQL (ou crie tabela similar no SGBD de sua preferência):

   ```bash
   create table fon fonte (
     fon_id bigint generated always as identity, fon_descritivo varchar (50) not null unique,
     fon_preco_sugerido float,
     fon_data_Tancamento date not null,
     fon_potencia_real int,
     fon_potencia_nominal int not null,
     primary key (fon_id));

   insert into fon_fonte (fon_descritivo, fon_data_lancamento, fon_potencia_nominal, fon_potencia_real)
   values ('200w Bronze', current_date, 200, 200), 
   ('350W', '2025-04-01', 350, null);
    
   grant update, delete, insert, select on all tables in schema public to spring;

   ```

**1. Classe Entity (Model)** <br>
Crie uma classe que mapeie a tabela criada. <br>
| Página do Projeto                                                                   | Pasta            | 
| :---------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe FonteModel.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/models/FonteModel.java) | Models | 


**2. Interface Repository** <br>
Crie um repositório para a classe criada no item 1 com uma consulta que busque todas as fontes cuja potência real seja superior a um valor passado como parâmetro e a data de lançamento seja inferior a um outro parâmetro. <br>
| Página do Projeto                                                                           | Pasta            | 
| :------------------------------------------------------------------------------------------ | :--------------- | 
| [Link para interface FonteRepository.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/repository/FonteRespository.java) | Repository | 


**3. Classe Service** <br>
Crie um serviço com 3 métodos: um para cadastro, um para listar todos os registros da tabela e outro para a consulta do item 2. No cadastro deve ser validado se o descritivo possui, no mínimo, 4 caracteres e se a potência real, se informada, possui valor menor ou igual à potência nominal. Caso ocorra uma falha de validação, retorne um erro do tipo "Bad Request" (400). <br>
| Página do Projeto                                                                     | Pasta            | 
| :------------------------------------------------------------------------------------ | :--------------- | 
| [Link para classe FonteService.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/services/FonteService.java) | Services | 


**4. Classe Controller** <br>
Crie um controller que atenda na URL "/fonte" e contenha 3 rotas: uma para cadastro, outra para listar todos os registros e uma última para buscar usando a consulta do item 2. <br>
| Página do Projeto                                                                        | Pasta            | 
| :--------------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe FonteController.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/controllers/FonteController.java) | Controllers | 


> Importante: Utilize java.time.LocalDate para mapear date. O comparador do Spring Data JPA correspondente a 'maior" (>) é "Greater Than". O comparador do Spring Data JPA correspondente a 'menor" (<) é "Less Than". <br>



## :rocket: Atividade 3

### :red_circle: Tarifa

Execute o seguinte comando no PostgreSQL (ou crie tabela similar no SGBD de sua preferência):

   ```bash
   create table tar tarifa (
     tar_id bigint generated always as identity,
     tar_nome varchar (50) not null,
     tar aliquota float not null,
     tar data inicio date not null, 
     tar data termino date,
     tar_impacto int,
     primary key (tar_id));

   insert into tar_tarifa (tar_nome, tar_data_inicio, tar_aliquota, tar_impacto)
   values ('TIQ', current_date, 40.5, 3),
   ('TTP', '2024-10-23', 10, null);

   grant update, delete, insert, select on all tables in schema public to spring;

   ```

**1. Classe Entity (Model)** <br>
Crie uma classe que mapeie a tabela criada. <br>
| Página do Projeto                                                                   | Pasta            | 
| :---------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe TarifaModel.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/models/TarifaModel.java) | Models | 


**2. Interface Repository** <br>
Crie um repositório para a classe criada no item 1 com uma consulta que busque todas as tarifas com um determinado nome, passado como parâmetro, cuja data de início seja inferior a um outro parâmetro. <br>
| Página do Projeto                                                                           | Pasta            | 
| :------------------------------------------------------------------------------------------ | :--------------- | 
| [Link para interface TarifaRepository.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/repository/TarifaRepository.java) | Repository | 


**3. Classe Service** <br>
Crie um serviço com 3 métodos: um para cadastro, um para listar todos os registros da tabela e outro para a consulta do item 2. No cadastro a data de início deve ser preenchida com a data atual se estiver em branco. Ainda no cadastro, deve ser validado se a alíquota possui um valor superior a zero e se a data de término é superior à data de início, caso seja informada (não validar se vier nula). Caso ocorra uma falha de validação, retorne um erro do tipo "Bad Request" (400). <br>
| Página do Projeto                                                                     | Pasta            | 
| :------------------------------------------------------------------------------------ | :--------------- | 
| [Link para classe TarifaService.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/services/TarifaService.java) | Services | 


**4. Classe Controller** <br>
Crie um controller que atenda na URL "/tarifa" e contenha 3 rotas: uma para cadastro, outra para listar todos os registros e uma última para buscar usando a consulta do item 2. <br>
| Página do Projeto                                                                        | Pasta            | 
| :--------------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe TarifaController.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/controllers/TarifaController.java) | Controllers | 


> Importante: Utilize java.time.Local Date para mapear date. O comparador do Spring Data JPA correspondente a "maior" (>) é "Greater Than". O comparador do Spring Data JPA correspondente a "menor" (<) é "Less Than". <br>



## :rocket: Atividade 4

### :red_circle: Patrimônio

Execute o seguinte comando no PostgreSQL (ou crie tabela similar no SGBD de sua preferência):

   ```bash
   create table pat_patrimonio (
     pat_id bigint generated always as identity, pat descricao varchar (150) not null,
     pat_data_aquisicao date not null,
     pat_data venda date,
     pat valor float,
     pat_tipo varchar (5) not null,
     primary key (pat_id));

   insert into pat patrimonio (pat_descricao, pat_data_aquisicao, pat_valor, pat_tipo)
   values ('Apartamento', current_date, null, 'BI'),
   ('Conta Corrente', current_date, 3200.53, 'BF');

   grant update, delete, insert, select on all tables in schema public to spring;

   ```

**1. Classe Entity (Model)** <br>
Crie uma classe que mapeie a tabela criada. <br>
| Página do Projeto                                                                   | Pasta            | 
| :---------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe PatrimonioModel.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/models/PatrimonioModel.java) | Models | 


**2. Interface Repository** <br>
Crie um repositório para a classe criada no item 1 com uma consulta que busque todas as propriedades adquiridas depois de uma data passada como parâmetro e com um valor inferior a um outro parâmetro. <br>
| Página do Projeto                                                                           | Pasta            | 
| :------------------------------------------------------------------------------------------ | :--------------- | 
| [Link para interface PatrimonioRepository.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/repository/PatrimonioRepository.java) | Repository | 


**3. Classe Service** <br>
Crie um serviço com 3 métodos: um para cadastro, um para listar todos os registros da tabela e outro para a consulta do item 2. No cadastro a data de aquisição deve ser preenchida com a data atual se estiver em branco. Ainda no cadastro, deve ser validado se o valor não é negativo, se informado, e se o tipo é válido (somente os valores "BI", "BM" ou "BF" devem ser aceitos). Caso ocorra uma falha de validação, retorne um erro do tipo "Bad Request" (400). <br>
| Página do Projeto                                                                     | Pasta            | 
| :------------------------------------------------------------------------------------ | :--------------- | 
| [Link para classe PatrimonioService.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/services/PatrimonioService.java) | Services | 


**4. Classe Controller** <br>
Crie um controller que atenda na URL "/patrimonio" e contenha 3 rotas: uma para cadastro, outra para listar todos os registros e uma última para buscar usando a consulta do item 2. <br>
| Página do Projeto                                                                        | Pasta            | 
| :--------------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe PatrimonioController.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/controllers/PatrimonioController.java) | Controllers | 


> Importante: Utilize java.time.Local Date para mapear date. O comparador do Spring Data JPA correspondente a "maior" (>) é "Greater Than". O comparador do Spring Data JPA correspondente a "menor" (<) é "Less Than". <br>



## :rocket: Atividade 5

### :red_circle: Agendamento

Execute o seguinte comando no PostgreSQL (ou crie tabela similar no SGBD de sua preferência):

   ```bash
   create table age agendamento (
     age_id bigint generated always as identity,
     age_instrucoes varchar (150),
     age valor float,
     age_data_hora_inicio timestamp not null, 
     age_duracao_prevista int,
     primary key (age_id));

   insert into age_agendamento (age_instrucoes, age_data_hora_inicio, age_duracao_prevista)
   values ('Chegue meia hora antes', '2025-04-24 19:35', 15), 
   (null, current_timestamp, null);
   
   grant update, delete, insert, select on all tables in schema public to spring;

   ```

**1. Classe Entity (Model)** <br>
Crie uma classe que mapeie a tabela criada. <br>
| Página do Projeto                                                                   | Pasta            | 
| :---------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe AgendamentoModel.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/models/AgendamentoModel.java) | Models | 


**2. Interface Repository** <br>
Crie um repositório para a classe criada no item 1 com uma consulta que busque todas os agendamentos que iniciem depois de uma data/hora passada como parâmetro e contenham em suas instruções uma palavra passada em outro parâmetro. Se for usar o @Query, não use SQL. <br>
| Página do Projeto                                                                           | Pasta            | 
| :------------------------------------------------------------------------------------------ | :--------------- | 
| [Link para interface AgendamentoRepository.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/repository/AgendamentoRepository.java) | Repository | 


**3. Classe Service** <br>
Crie um serviço com 3 métodos: um para cadastro, um para listar todos os registros da tabela e outro para a consulta do item 2. No cadastro, se a data/hora de início vier nula, ela deve ser preenchida com a data/hora atual acrescidade de 1 dia. Ainda no cadastro, deve ser validado se o o valor e a duração prevista possuem valores superiores a zero, se informados (não validar nada se os valores vierem nulos). Gere um erro do tipo "bad request" (400) em caso uma validação falhe. <br>
| Página do Projeto                                                                     | Pasta            | 
| :------------------------------------------------------------------------------------ | :--------------- | 
| [Link para classe AgendamentoService.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/services/AgendamentoService.java) | Services | 


**4. Classe Controller** <br>
Crie um controller que atenda na URL "/agenda" e contenha 3 rotas: uma para cadastro, outra para listar todos os registros e uma última para buscar usando a consulta do item 2. <br>
| Página do Projeto                                                                        | Pasta            | 
| :--------------------------------------------------------------------------------------- | :--------------- | 
| [Link para classe AgendamentoController.java](https://github.com/ClaudiaCBS/ADS06_ITE002/blob/main/src/main/java/com/example/demo/controllers/AgendamentoController.java) | Controllers | 


> Importante: Utilize java.time.LocalDateTime para mapear timestamp. O comparador do Spring Data JPA correspondente a "maior" (>) é "Greater Than". O comparador do Spring Data JPA correspondente a "menor" (<) é "Less Than". <br>



## 📌 Como Executar a Aplicação

1. Abra o terminal do **VSCode** (Ctrl+` ou Terminal → Novo Terminal)
2. Navegue até a pasta raiz do projeto
3. Execute o comando:

   ```bash
   mvn spring-boot:run
   ```





