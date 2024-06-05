## Ramdom Data API

Um API geração de dados randômicos aleatórios.

## Objetivo

A gente sabe que no mundo da programação ter que gerar informações aleatórias é uma tarefa bem complicada.
Sempre temos que ficar criando formas de gerar dados aleatórios de informações que a gente precisa nas
nossas aplicações ou usar bibliotecas que facilitam isso. Por isso que essa API foi criada, 
para facilitar a geração de dados aleatórias pra informações recorrentes sem precisar ter que
ficar tendo que criar do zero ou usar alternativas já existentes.


## Tipos de informações que irão ser geradas de maneira aleatória

- Password (senha)
- CPF 
- Range of numbers (números em um intervalo) Ex:. 10 to 100
- Texts (textos)


## Tecnologias utilizadas
- Java
- Spring

<br>
<br>


## Documentação

#### Retorna uma senha aleatória

```http
  GET /random/password?passwordSize=number
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `passwordSize` | `number` | **Obrigatório** |

##### Resposta (Sucesso)
```json
{
  "password": "string",
  "passwordSize": "number"
}
```

##### Resposta (Erro)
```json
{
  "message": "string",
  "path": "string"
  "statusCode": "number"
}
```


<br>
<br>


#### Retorna um CPF aleatório

```http
  GET /random/cpf?hasEspecialCharacters=boolean
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `hasEspecialCharacters`      | `number` | **Opcional**|


##### Resposta (Sucesso)
```json
{
  "cpf": "string",
  "cpfSize": "number",
  "hasEspecialCharacters": "boolean"
}
```

##### Resposta (Erro)
```json
{
  "message": "string",
  "path": "string"
  "statusCode": "number"
}
```


<br>
<br>

#### Retorna um texto aleatório a partir de uma lista de textos

```http
  POST /random/text
```

##### Corpo da requisição (Obrigatório)

```json
{
  "texts": "string[]"
}
```

##### Resposta (Sucesso)
```json
{
  "text": "string",
  "texts": "string[]",
  "textSize": "number",
  "textsSize": "number"
}
```

##### Resposta (Erro)
```json
{
  "message": "string",
  "path": "string"
  "statusCode": "number"
}
```



## Contribuição

Para poder contribuir o projeto primeiro voce deverá seguir os seguintes passos:
- Ter o Java 21 instalado
- Efetuar o clone ou o fork do projeto no Github

Clone: git clone https://github.com/fernandobarrosd/random-data-api.git

## API

- Link da API: https://random-data-api.onrender.com
- Documentação da API: https://random-data-api.onrender.com/docs/ui
