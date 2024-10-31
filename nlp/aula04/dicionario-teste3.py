a2 = {'ra': '000002', 'nome': 'Maria Silva', 
      'telefone': '(11) 2222-2222', 'nascimento': '03/02/1989',
      'notas': [7.5, 8.5, 9.2, 6,3], 'ano de ingresso': 2016 }

a3 = a2.copy()

print("Tamanho do dicionario: ", len(a2))
print("Antes de apagar: ", a2)
del a2['notas']
print("Depois de apagar: ", a2)

if 'nome' in a3:
    print("Há a chave nome no dicionario")
else: 
    print("Não há a chave nome no dicionario")

if 'notas' in a3:
    print("Há a chave notas no dicionario")
else: 
    print("Não há a chave notas no dicionario")
