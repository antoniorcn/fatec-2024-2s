#         0  1  2   3
lista1 = [4, 6, 8, 10]
lista = list([4, 6, 8, 10])


pares_1a10 = [2, 4, 6, 8, 10]
pares_1a1000 = [n for n in range(0, 1000, 2)]

# print(pares_1a1000)

print("Sub lista apenas os 20 primeiros numeros:")
print(pares_1a1000[0:10])
   #           0    1    2
joao = [  
            [ 5.0, 7.0, 8.0 ],  # 0 Inglês
            [ 9.0, 0.0, 2.0 ],  # 1 Fundamentos de Redação
            [ 7.0, 6.5, 8.0 ],  # 2 Prog. Disp Moveis II
            [ 5.0, 7.0, 3.5 ],  # 3 Aprendizagem de Maquina
       ]

# print("Nota final de Redação: ", joao[1][2])

joao[0]  # [ 5.0, 7.0, 8.0 ]
soma = 0
for indice in range(3):
    soma = soma + joao[0][indice]

qtd_materias = len(joao)
tamanho = len( joao[0] )
media = soma / tamanho
print(soma)
print(media)
