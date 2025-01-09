# Projeto de Inventário
Este repositório contém o código-fonte do serviço de inventário, parte essencial do sistema ERP. O serviço de inventário é responsável por gerenciar os estoques de produtos, processar reservas para pedidos e manter a consistência dos dados de inventário com outros serviços.

## Funcionalidades Principais

1-  Gerenciamento de Estoque:
- Mantém informações atualizadas sobre os produtos e suas quantidades em estoque.
- Escuta eventos do Product-Service para criar, atualizar ou remover produtos do inventário.
  
2-  Reserva de Estoque:
- Processa requisições de reserva enviadas pelo Order-Service.
- Verifica se há quantidade suficiente de um produto em estoque.
-Realiza reservas temporárias, garantindo consistência em pedidos.

3-  Eventos e Mensageria:
-  Publica eventos para informar sobre o status das reservas (aprovadas ou rejeitadas).
-  Escuta eventos de confirmação ou cancelamento de pedidos para ajustar o estoque permanentemente.
 
 ## Tecnologias Utilizadas

- Java com Spring Boot para criação do serviço.
- RabbitMQ para mensageria entre os serviços.
- JPA/Hibernate para persistência de dados no banco de dados.
- MySQL como banco de dados relacional.
- Docker para containerização.

## Eventos do RabbitMQ
### Escutados:

1-  inventory.reserve: Solicitação de reserva de estoque.

2-  product.created: Informa a criação de um novo produto

3-  product.updated: Atualiza informações do produto.

4-  product.deleted: Remove um produto do inventário.

### Publicados:

1-  inventory.reserved: Reserva de estoque aprovada.

2-  inventory.rejected: Reserva de estoque rejeitada.

# Autor 👦
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/136930797?v=4" width=150><br><sub>Felipe Araujo</sub>](https://github.com/FelipeAraujo32)
| :---: |

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a MIT License.

## Contato
Para mais informações, entre em contato pelo e-mail: felipecafsx@gmail.com
