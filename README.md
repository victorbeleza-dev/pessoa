# Instruções para rodar a aplicação angular

* 1 - Use o comando `ng serve` . Entre no navegador na pagina `http://localhost:4200/`

# Instruções para rodar a aplicação springboot

* 1 - Clone o repositório;
* 2 - Entre na primeira pasta;
* 3 - Abra o bash, e digite mvn clean install para instalar as dependencias do projeto;
* 4 - Digite mvn spring-boot:run para rodar o programa;

## Rotas para consultas
* A rota para realizar a consulta de todos os registros é `localhost:8080/pessoas` usando o metodo `GET` irá retornar como no exemplo abaixo;
```
[
    {
        "id": 1,
        "nome": "Fulano",
        "cpf": "12345678900"
    }
]
```

* A segunda consulta é reponsavel por buscar pelo id e é necessario colocar o id na consulta exeplo `localhost:8080/pessoas/1` usando o metodo `GET`  irá retornar como no exemplo abaixo:
```
{
    "id": 1,
    "nome": "Fulano",
    "cpf": "12345678900"
}
```

* A Terceira consulta é responsavel por buscar a pessoa pelo cpf, é necessario saber o cpf para realizar a consulta por exemplo `localhost:8080/pessoas/cpf/12345678900` usando o metodo `GET` irá retornar como no exemplo abaixo:
```
{
    "id": 1,
    "nome": "Fulano",
    "cpf": "12345678900"
}
```

## Rotas para cadastrar e atualizar uma pessoa
* Para cadastrar uma nova pessoa é necessario mandar um request do tipo post para a rota `localhost:8080/pessoas` usando método `POST` com o body abaixo:
```
{
    "nome": "Fulano",
    "cpf": "12345678900"
}
```
Irá retornar o seguinte json:
```
{
    "id": 1,
    "nome": "Fulano",
    "cpf": "12345678900"
}
```

* Para atualizar uma pessoa é necessario mandar o id no request como por exemplo `localhost:8080/pessoas/1` usando o método `PUT` com o body abaixo:
```
{
    "nome": "Fulano",
    "cpf": "12345678900"
}
```

## Rota para deletar uma pessoa
* Para deletar uma pessoa é necessario somente mandar o id como por exemplo `localhost:8080/pessoas/1` usando o método `DELETE` essa requisição não irá retornar nada somente o status `204`;

## Considerações
* Os testes unitários foram implementados usando Junit;
* O banco de dados H2 é ultilizado tanto nos testes quanto na api;
* O primeiro serviço sobe na porta **4200** e o segundo na **8080**;
