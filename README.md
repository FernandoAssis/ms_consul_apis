# ms_consul_apis

Este repositório é uma prova de conceito (POC) da criação de microserviços com Kong SpringBoot e Consul.

#####  Ambiente:
O docker com a instalação do Kong e Consul pode ser obtido a partir do repositório: https://github.com/Mashape/docker-kong/tree/master/compose

#### Instalação:
```
# baixe o container docker a partir do github
$ git clone https://github.com/Mashape/docker-kong.git

# Acesse o diretório docker-kong
$ cd docker-kong

# Instale o pacote
$ docker build .

# acesse o diretório compose
$ cd compose

# Inicialize o container
$ docker-compose up
```

A validação do ambiente pode ser feita acessando as URLs abaixo:

- Admin API Console: http://localhost:8001/
- Consul Console: http://localhost:8500

#### APIs

- cliente-api: Gerência informações de clientes.
- produto-api: Gerência informações de produtos.

Instalação:
```
$ mvn clean install spring-boot:run
```

TODO: implementar spring-cloud-consul-config
TODO: implementar circuit-break
TODO: associar APIs ao kong
TODO: realizar integração oauth2 (google)

##### Referências:
- http://blog.trifork.com/2016/12/14/service-discovery-using-consul-and-spring-cloud/
- https://docs.docker.com/compose/overview/

