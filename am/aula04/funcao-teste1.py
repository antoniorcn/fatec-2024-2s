#               Chave:   Valor 
d1 = {  "nome": "Joao Silva", 
                "cpf": "111.111.111-11", 
                "telefone": "(11) 1111-1111"  }
d1["idade"] = 30

d2 = { "nome": "Maria Silva",
        "cpf": "222.222.222-22",
        "telefone": '(11) 2222-2222',
        "idade": 32 }
w = 100

def somar( numero1=0, numero2=0):
    global w
    w = 2
    print("W dentro da função:", w)
    resultado = numero1 + numero2
    print("numero1: ", numero1)
    print("numero2: ", numero2)
    return resultado

def imprimir_dados( pessoa ):
    print("Dados do ", pessoa["nome"])
    print("Nome: ", pessoa["nome"])
    print("Telefone: ", pessoa["telefone"])
    print("CPF: ", pessoa["cpf"])
    print("Idade: ", pessoa["idade"])

imprimir_dados( d1 )
imprimir_dados( d2 )
s = somar( numero2=40  )   # 30
print("Soma: ", s)
print("W: ", w)
