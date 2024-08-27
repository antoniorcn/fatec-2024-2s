#          0                1                2
# lista = ["Joao Silva", "111.111.111-11", "(11) 1111-1111"] 
# print("Telefone: ", lista[2])

#               Chave:   Valor 
d1 = {  "nome": "Joao Silva", 
                "cpf": "111.111.111-11", 
                "telefone": "(11) 1111-1111"  }
d1["idade"] = 30
# d1["nome"] = "Maria Silva"

d2 = { "nome": "Maria Silva",
        "cpf": "222.222.222-22",
        "telefone": '(11) 2222-2222',
        "idade": 32 }

print("Dados do João Silva")
print("Dicionario: ", d1)
print("Nome: ", d1["nome"])
print("Chaves: ", d1.keys())
print("Valores: ", d1.values())
print("Items: ", d1.items())

print("Dados da Maria Silva")
print("Dicionario: ", d2)
print("Nome: ", d2["nome"])
print("Chaves: ", d2.keys())
print("Valores: ", d2.values())
print("Items: ", d2.items())

