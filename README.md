# Aula 12 — Computação em Nuvem

API REST de produtos em Spring Boot para publicar no Railway.

## Endpoints

- `GET /produtos` lista os produtos iniciais.
- `POST /produtos` cadastra um produto enviado em JSON.
- `PUT /produtos/{id}` altera nome e preço de um produto.
- `DELETE /produtos/{id}` remove um produto.

Exemplo de JSON para POST:

```json
{
  "id": 4,
  "nome": "Monitor",
  "preco": 899.90
}
```

O servidor usa a porta definida pelo Railway (`PORT`) e, localmente, a porta 8080. Os dados ficam em memória e voltam à lista inicial quando a aplicação reinicia.

