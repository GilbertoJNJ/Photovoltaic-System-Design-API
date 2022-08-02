# Photovoltaic-System-Design-API
## :book:Summary 
* [1. Description](#description)
* [2. Technologies](#technologies)
* [3. Dependencies](#dependencies)
* [4. Integration](#integration)
* [5. Prerequisites](#prerequisites)
* [6. Install](#install)
* [7. How To Use](#how-to-use)

## Description
:construction: IN CONSTRUCTION...
- deverá ser feito, a principio, uma consulta na viaCEP para retornar o endereço do cliente para servir de parametros a api do google maps platform 
que por sua vez retornará latitude e longetude de uma localização para servir de input a api da NREL para retornar as taxas de irradiação solar mensal e anual
para servir de base para os calculos de dimencionamento de um sistema fotovoltaico
- deverá ser respeitado os principios de design patterns tais como singleton, strategy, facade, entre outros
- o objetivo é reduzir o nivel de complexidade, pois é preciso consultar 3 apis para coletar dados para realização de calculos
- um dos endpoints é cadastrar o cliente uma vez que é inserido alguns campos como nome e endereço, e outro para ser inserido o consumo de energia de cada mês

## Technologies
- <img src="https://img.shields.io/static/v1?label=kotlin&message=language&color=violet&style=for-the-badge&logo=kotlin"/>
- <img src="https://img.shields.io/static/v1?label=gradle&message=build&color=darkgreen&style=for-the-badge&logo=gradle"/>
- <img src="https://img.shields.io/static/v1?label=docker&message=container&color=cyan&style=for-the-badge&logo=docker"/>
- <img src="https://img.shields.io/static/v1?label=mysql&message=database&color=blue&style=for-the-badge&logo=mysql"/>
- <img src="https://img.shields.io/static/v1?label=spring&message=framework&color=green&style=for-the-badge&logo=spring"/>
- <img src="https://img.shields.io/static/v1?label=junit&message=tests&color=darkgreen&style=for-the-badge&logo=junit5"/>
- <img src="https://img.shields.io/static/v1?label=aws&message=deploy&color=orange&style=for-the-badge&logo=amazonaws"/>

## Dependencies
 - Spring Data JPA
 - Spring Web
 - OpenFeign
 - Openapi-ui
 - MapStruct
 - MySQL
 - Spring Test
 
## Integration
 - [ViaCEP](https://viacep.com.br/)
 - [Google Maps Platform](https://mapsplatform.google.com/intl/pt-BR/)
 - [Developer Network NREL](https://developer.nrel.gov/)

## Prerequisites
1. Must be connected to a MySQL database on port: 3306.
2. If you prefer, a container can be used.

## Install 
1. In the terminal, clone the project:
```shell script
git clone https://github.com/GilbertoJNJ/Photovoltaic-System-Design-API.git

```

2. Enter in the projet diretory:
```shell script
cd ~\photovoltaic-system-design
```

3. Execute the command:
```shell script
gradle bootrun
```

4. To run the tests:
```shell script
gradle clean test
```

5. To use docker-compose:

   5.1 Create .jar
    ```shell script
    ./gradlew bootjar 
    ```
   5.2 Run docker-compose command
    ```shell script
    docker-compose up 
    ```

## How To Use
